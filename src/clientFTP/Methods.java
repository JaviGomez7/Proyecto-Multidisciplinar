package clientFTP;

import java.io.IOException;

import javax.swing.JOptionPane;

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
}
	
