package clientFTP;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

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
	 * M�todo para crear un nuevo directorio
	 * 
	 * @param path direcci�n para crear direcctorio
	 * @return true or false
	 */
	
	private boolean makeDirectory(String path) {

		boolean created = makeDirectory(path);

		if (created) {

			System.out.println("Directorio creado correctamente en : " + path);

		} else {

			System.out.println("Directorio incorrecto en esta direcci�n : " + path);
		}
		return created;
	}

	/**
	 * M�todo para borrar directorios recursivamente
	 * @param ftpClient parametro del servidor cliente
	 * @param parentDir direcci�n del directorio padre
	 * @param currentDir direcci�n del directorio actual
	 */

	private void removeDirectory(FTPClient ftpClient, String parentDir, String currentDir) {

		String dirToList = parentDir;
		//Si el directorio no est� vacio se lo a�adimos al directorio padre
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
					//Si la direcci�n actual esta vacia no la incluimos en el filePath
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
						// Por �ltimo elimina el directorio en s�
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

	 * M�todo para cambiar de directorio
	 * @param client cliente del servidor FTP
	 * @param directory direcci�n nueva a la que queremos cambiar
	 */
	private void changeDirectory(FTPClient client, String directory) {
		
		try {
			String currentDirectory = client.printWorkingDirectory();
			if(!currentDirectory.equals(directory)) {
				client.changeWorkingDirectory(directory);
			}
			
			
		} catch (IOException e) {
			
			JOptionPane.showMessageDialog(null, "La direcci�n es erronea");
			
		}
	}
	
	/**
	 * 
	 * @param Client cliente del servidor FTP
	 * @param remoteFilePath 
	 * @param savePath nombre del nuevo fichero
	 * @return
	 * @throws IOException captura posibles errores con los ficheros 
	 */
	private boolean downloadSingleFile(FTPClient Client,
	        String remoteFilePath, String savePath) throws IOException {
	    File downloadFile = new File(savePath);
	     
	    File parentDir = downloadFile.getParentFile();
	    if (!parentDir.exists()) {
	        parentDir.mkdir();
	    }
	         
	    OutputStream outputStream = new BufferedOutputStream(
	            new FileOutputStream(downloadFile));
	    try {
	        Client.setFileType(FTP.BINARY_FILE_TYPE);
	        return Client.retrieveFile(remoteFilePath, outputStream);
	    } catch (IOException ex) {
	        throw ex;
	    } finally {
	        if (outputStream != null) {
	            outputStream.close();
	        }
	    }
	}
	
	/**
	 * 
	 * @param Client cliente del servidor FTP
	 * @param parentDir directorio al que partimos
	 * @param currentDir direcci�n directorio actual
	 * @param saveDir 
	 */
	private void viewFilesOfThisDirectory(FTPClient Client, String parentDir,
	        String currentDir, String saveDir) {
	    String dirToList = parentDir;
	    if (!currentDir.equals("")) {
	        dirToList += "/" + currentDir;
	    }
	 
	    FTPFile[] subFiles;
		try {
			subFiles = Client.listFiles(dirToList);
			if (subFiles != null && subFiles.length > 0) {
		        for (FTPFile aFile : subFiles) {
		            String currentFileName = aFile.getName();
		            if (currentFileName.equals(".") || currentFileName.equals("..")) {
		                // skip parent directory and the directory itself
		                continue;
		            }
		            String filePath = parentDir + "/" + currentDir + "/"
		                    + currentFileName;
		            if (currentDir.equals("")) {
		                filePath = parentDir + "/" + currentFileName;
		            }
		 
		            String newDirPath = saveDir + parentDir + File.separator
		                    + currentDir + File.separator + currentFileName;
		            if (currentDir.equals("")) {
		                newDirPath = saveDir + parentDir + File.separator
		                          + currentFileName;
		            }
		 
		            if (aFile.isDirectory()) {
		                // create the directory in saveDir
		                File newDir = new File(newDirPath);
		                boolean created = newDir.mkdirs();
		                if (created) {
		                    System.out.println("CREATED the directory: " + newDirPath);
		                } else {
		                    System.out.println("COULD NOT create the directory: " + newDirPath);
		                }
		 
		                // download the sub directory
		                viewFilesOfThisDirectory(Client, dirToList, currentFileName,
		                        saveDir);
		            } else {
		                // download the file
		                boolean success = downloadSingleFile(Client, filePath,
		                        newDirPath);
		                if (success) {
		                    System.out.println("DOWNLOADED the file: " + filePath);
		                } else {
		                    System.out.println("COULD NOT download the file: "
		                            + filePath);
		                }
		            }
		        }
		    }
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	    
	}
		


/**
	 * M�todo para renombrar un archivo o directorio, recibe dos string, uno con el
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
	 * M�todo para borrar un fichero, recibe el path donde se encuentra el archivo.
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
	 * M�todo para descargar un archivo del servidor
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
	 *  M�todo para subir un archivo al servidor.
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
>>>>>>> branch 'ClientFTP' of https://github.com/JaviGomez7/Proyecto-Multidisciplinar.git
	
