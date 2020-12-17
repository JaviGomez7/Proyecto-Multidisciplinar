package serverFTP;

import java.io.File;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.ssl.SslConfigurationFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.SaltedPasswordEncryptor;
import org.apache.ftpserver.usermanager.impl.BaseUser;

public class ServerFTP {

	public static void main(String args[]) {
		int port = 2221;
		FtpServerFactory serverFactory = new FtpServerFactory();
		ListenerFactory factory = new ListenerFactory();

		// set the port of the listener
		factory.setPort(port);

		// replace the default listener
		serverFactory.addListener("default", factory.createListener());
		PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();

		// CAMBIAR TAMBIEN ESTA RUTA!!!!
//		userManagerFactory.setFile(new File(
//				"D:\\Desarrollo de Aplicaciones Multiplataforma\\Acceso a Datos\\workspace\\ProyectoDisciplinar\\myusers.properties"));
//		serverFactory.setUserManager(userManagerFactory.createUserManager());

		// start the server
		FtpServer server = serverFactory.createServer();
		try {
			server.start();
			System.out.printf("Servidor escuchando en el puerto %d\n", port);
		} catch (FtpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * public static void main (String args[]) { 
	 * int port = 2221; 
	 * FtpServerFactory
	 * serverFactory = new FtpServerFactory(); ListenerFactory factory = new
	 * ListenerFactory();
	 * 
	 * // set the port of the listener factory.setPort(port);
	 * 
	 * // define SSL configuration SslConfigurationFactory ssl = new
	 * SslConfigurationFactory();
	 * 
	 * // ACORDARSE DE CAMBIAR LA RUTA DEL FICHERO!!!!!! 
	 * ssl.setKeystoreFile(new File("D:\\Desarrollo de Aplicaciones Multiplataforma\\Acceso a Datos\\workspace\\ProyectoDisciplinar\\apache-ftpserver-1.1.1\\res\\ftpserver.jks")); 
	 * ssl.setKeystorePassword("password");
	 * 
	 * // set the SSL configuration for the listener
	 * factory.setSslConfiguration(ssl.createSslConfiguration());
	 * factory.setImplicitSsl(true);
	 * 
	 * 
	 * }
	 */

}
