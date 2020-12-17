package serverLogin;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Clase Server
 * Descripción: Implementa el servidor del logín de la Universidad de Hogwarts".
 *
 * @date 14/12/2020
 * @version 1.0
 *
 */
public class ServerLogin {

	/**
	 * Futura tuberia para coordinar
	 */
	Pipe pipe;
	
	/**
	 * Puerto de escucha del servidor
	 */
	private final int port = 5000;
	
	/**
	 * Inicia la ejecución del servidor
	 */
	public void initServer() {
		
		pipe = new Pipe();
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			 
            System.out.println("Servidor escuchando en el puerto " + port);
            
            //Pienso que aqui hay que lanzar la ventana ventana a la espera de clientes
            
            
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente "+ socket.getPort()+" conectado");
 
                LoginThread st = new LoginThread(socket, this, pipe);
                st.start(); 
            }
 
        } catch (IOException ex) {
            System.out.println("Error en el servidor: " + ex.getMessage());
        }
	}
	
	/**
	 * Método principal de inicio del programa
	 * @param args
	 */
	public static void main(String args[]) {
		new ServerLogin().initServer();
	}
}