package clientFTP;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class ClientFTP {
	
	
	public static void main(String[] args) {
		 
        // Creando nuestro objeto ClienteFTP
        FTPClient client = new FTPClient();
 
        // Datos para conectar al servidor FTP
        String ftp = "ftp.miservidor.com"; // También puede ir la IP
        String user = "usuario";
        String password = "password";
 
        try {
            // Conactando al servidor
            client.connect(ftp);
 
            // Logueado un usuario (true = pudo conectarse, false = no pudo
            // conectarse)
            boolean login = client.login(user, password);
 
            // Cerrando sesión
            client.logout();
 
            // Desconectandose con el servidor
            client.disconnect();
 
        } catch (IOException ioe) {
 
        }
    }

	 
	    
	}


