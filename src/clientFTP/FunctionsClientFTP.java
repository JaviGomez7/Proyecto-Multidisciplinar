package clientFTP;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * Clase que contiene las funcionalidad del cliente para borrar, renombar, crear
 * directorios y archivos.
 * 
 * @author Jose Arias
 *
 */
public class FunctionsClientFTP {

	/*
	 *  
	 * 
	 * 
	 * 
	 * 
	 */
	FTPClient ftpClient;

	public FunctionsClientFTP(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
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

	public void FTPDownloadFile(String pathServer,String nameFile,String ourPath) {

		String direc = "/htdocs/NUEVODIREC/NUEVO";
		try {
			ftpClient.changeWorkingDirectory(direc);

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(ourPath));
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
		// stream de salida para recibir el fichero•descargado

	}
}
