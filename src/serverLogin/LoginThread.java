package serverLogin;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;




	public class LoginThread extends Thread {

		/**
		 * Socket de comunicación con el cliente.
		 */
		private Socket socket;
		/**
		 * Servidor principal
		 */
		private ServerLogin server;
		/**
		 * Stream de lectura de datos enviados por el cliente en formato mensaje (ver
		 * clase Message).
		 */
		private ObjectInputStream reader;
		/**
		 * Stream para envío de datos al cliente en formato mensaje (ver clase Message).
		 */
		private ObjectOutputStream writer;

		private Pipe pipe;

		public LoginThread(Socket socket, ServerLogin server, Pipe pipe) {
			this.socket = socket;
			this.server = server;
			
			try {
				writer = new ObjectOutputStream(socket.getOutputStream());
				reader = new ObjectInputStream(socket.getInputStream());
			} catch (IOException e) {
				System.out.println("Se ha producido un error de I/O");
			}
		}

		

		/**
		 * Método de ejecución del hilo. Atiende mensajes entrantes desde el cliente.
		 */
		public void run() {
			// implementar funcionalidad del  hilo.
		}

		/**
		 * Método para procesar los mensajes recibidos desde el cliente
		 * 
		 * @param message Mensaje recibido desde el cliente
		 */
//		private void messageHandler(Message message) {
//			switch (message.getCode()) {
//			case Protocol.USER_LOGIN:
//				initSession(message);
//				break;
//			case Protocol.END_SESSION:
//				endLoteryProvider();
//				break;
//			case Protocol.BUY_REQUEST:
//				registerBuyRequest((LoteryNumber) message.getPayload());
//				break;
//			case Protocol.REQUEST_BUY_TICKET:
//				sendTicket();
//				break;
//			default:
//				break;
//			}
//		}

		

	}

