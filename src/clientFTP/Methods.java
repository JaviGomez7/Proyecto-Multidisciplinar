package clientFTP;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Methods {

	FTPClient ftpClient;

	public Methods(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	/**
	 * Método para crear un nuevo directorio
	 * 
	 * @param path dirección para crear direcctorio
	 * @return true or false
	 */
	
	private boolean makeDirectory(String path) {

		boolean created = makeDirectory(path);

		if (created) {

			System.out.println("Directorio creado correctamente en : " + path);

		} else {

			System.out.println("Directorio incorrecto en esta dirección : " + path);
		}
		return created;
	}

	/**
	 * Método para borrar directorios recursivamente
	 * @param ftpClient parametro del servidor cliente
	 * @param parentDir dirección del directorio padre
	 * @param currentDir dirección del directorio actual
	 */

	private void removeDirectory(FTPClient ftpClient, String parentDir, String currentDir) {

		String dirToList = parentDir;
		//Si el directorio no está vacio se lo añadimos al directorio padre
		if (!currentDir.equals("")) {
			dirToList += "/" + currentDir;
		}
		//Creamos array para guardar los subdirectorios
		FTPFile[] subFiles;
		try {
			//Guardamos todos los directorios en el array
			subFiles = ftpClient.listFiles(dirToList);
			if (subFiles != null && subFiles.length > 0) {
				for (FTPFile aFile : subFiles) {
					String currentFileName = aFile.getName();
					if (currentFileName.equals(".") || currentFileName.equals("..")) {
						// Se salta primero el directorio principal y pasa a los siguientes
						continue;
					}
					//Si la dirección actual esta vacia no la incluimos en el filePath
					String filePath = parentDir + "/" + currentDir + "/" + currentFileName;
					if (currentDir.equals("")) {
						filePath = parentDir + "/" + currentFileName;
					}

					if (aFile.isDirectory()) {						
							// Eliminar sub-directorio
							removeDirectory(ftpClient, dirToList, currentFileName);
					}	
						 else {
							// Borra archivo
							boolean deleted = ftpClient.deleteFile(filePath);
							if (deleted) {
								System.out.println("Directorio borrado: " + filePath);
							} else {
								System.out.println("No se ha podido borrar este directorio: " + filePath);
							}
						}
						// Por último elimina el directorio en sí
						boolean removed = ftpClient.removeDirectory(dirToList);
						if (removed) {
							System.out.println("Directorio eliminado: " + dirToList);
						} else {
							System.out.println("No se ha podido eliminar: " + dirToList);
						}
					} 
					}	
			
					
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	/**
	 * Método para renombrar un archivo o directorio, recibe dos string, uno con el
	 * nombre viejo y otro con el nuevo.
	 * 
	 * @param oldName
	 * @param newName
	 */
	public void rename(String oldName, String newName) {
		// renaming file

		boolean success;
		try {
			success = ftpClient.rename(oldName, newName);

			if (success) {
				System.out.println(oldName + " was successfully renamed to: " + newName);
			} else {
				System.out.println("Failed to rename: " + oldName);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			ftpClient.logout();
//			ftpClient.disconnect();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	/**
	 * Método para borrar un fichero, recibe el path donde se encuentra el archivo.
	 * 
	 * @param fileToDelete
	 */

	public void deleteFile(String pathFileToDelete) {

		boolean deleted;
		try {
			deleted = ftpClient.deleteFile(pathFileToDelete);

			if (deleted) {
				System.out.println("The file was deleted successfully.");
			} else {
				System.out.println("Could not delete the  file, it may not exist.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//		ftpClient.logout();
//		ftpClient.disconnect();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}

	}

	
	/**
	 * 
	 * Método para descargar un archivo del servidor
	 * @param pathServer
	 * @param nameFile
	 * @param pathUser
	 */
	public void FTPDownloadFile(String pathServer,String nameFile,String pathUser) {

		
		try {
			ftpClient.changeWorkingDirectory(pathServer);

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(pathUser));
			if (ftpClient.retrieveFile(nameFile, out)) {
				System.out.println("Archivo bajado  correctamente...  ");
			} else {
				System.out.println("No  se ha podido descargar...  ");
				out.close();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	
	/**
	 *  Método para subir un archivo al servidor.
	 * @param pathServer
	 * @param nameFile
	 * @param pathUser
	 */
	public void makeUpLoadFile(String pathServer,String nameFile,String pathUser) {
		
		
		try {
			ftpClient.changeWorkingDirectory(pathServer);
			ftpClient. setFileType (FTP . BINARY_FILE_TYPE) ;
			//stream de entrada con el fichero a subir
			BufferedInputStream in = new BufferedInputStream(
			new FileInputStream(pathUser+nameFile)) ;   		// !ojo que hay path por medio y pueden petar las barras o lo que sea.
			ftpClient.storeFile(nameFile, in);
			
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
			}
		
		
	}
	
	
	
}
	
