package clientLogin;

import java.net.*;
import java.util.*;


import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;

/**
 * Clase: Client
 * Descripcion: Implementa el programa cliente para comprar billetes de lotería en 
 * la administración "El Gato Negro". Implementa WindowListener
 * @author Claudio Martín Lume
 * @date 28/11/2020
 * @version 1.0
 *
 */
public class Client  {
	/**
	 * Puerto de escucha del servidor
	 */
	private int port = 5000;
	/**
	 * Dirección del servidor
	 */
	private String hostname = "localhost";
	/**
	 * Socket de conexión con el servidor
	 */
	private Socket socket;
	/**
	 * Stream para leer datos recibidos desde el servidor en formato mensaje (Ver clase Message). 
	 */
	private ObjectInputStream reader;
	/**
	 * Stream para enviar datos al servidor en formato mensaje (Ver clase Message).
	 */
	private ObjectOutputStream writer;
	/**
	 * Ventana del programa cliente.
	 */
	

	/**
	 * Constructor por defecto
	 */
	public Client() {
		
	}

	/**
	 * Inicia la ejecución del cliente. 
	 */
	public void initClient() {
		try {
			socket = new Socket(hostname, port);  // Login
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
			System.out.println("Conectado al servidor");
			
		} catch (UnknownHostException ex) {
			System.out.println("Servidor no encontrado");
			endClient();
		} catch (IOException ex) {
			System.out.println("Error de comunicación con el servidor");
			endClient();
		}
	}

	/**
	 * Finaliza la ejecución del cliente.
	 */
	public void endClient() {
		try {
			writer.close();
			reader.close();
			socket.close();
		} catch (IOException e) {
			System.out.println("Fallo al cerrar la conexión con el servidor");
		} finally {
			System.exit(0);
		}
	}



	/**
	 * Método para enviar un mensaje al servidor y recibir la respuesta de este. 
	 * @param msg Objeto Message que contiene el mensaje a enviar. 
	 */
//	public void send(Message msg) {
//		try {
//			writer.reset();
//			writer.writeObject(msg);
//			responseHandler((Message) reader.readObject());
//		} catch (IOException e) {
//			view.displayError("No se ha podido enviar solicitud al servidor");
//		} catch (ClassNotFoundException e) {
//			view.displayError("Error de implementación. Por favor contacte con el administrador.");
//		}
//	}

	/**
	 * Procesa la respuesta recibida del servidor.
	 * @param response Mensaje recibido desde el servidor. 
	 */
	//@SuppressWarnings("unchecked")
//	private void responseHandler(Message response) {
//		switch (response.getCode()) {
//			case Protocol.LOTERY_NUMBERS:
//				view.displayBuyPanel((ArrayList<LoteryNumber>) response.getPayload());
//				break;
//			case Protocol.REQUEST_BUY_CONFIRMATION:
//				processBuyConfirmation(response);
//				break;
//			case Protocol.NOTIFY_BUY_SUCCESSFULL:
//				view.completeBuy((ArrayList<LoteryNumber>) response.getPayload());
//				break;
//			case Protocol.NOTIFY_BUY_CANCELLED:
//				view.cancelBuy((ArrayList<LoteryNumber>) response.getPayload());
//				break;
//			case Protocol.BUY_TICKET:
//				view.displayBuyTicket((Ticket) response.getPayload());
//				break;
//			default:
//				break;
//		}
//
//	}

	
	
	/**
	 * Método main para iniciar la ejecución del programa cliente. 
	 * @param args
	 */
	public static void main (String args[]) {
		new Client().initClient();
	}
}