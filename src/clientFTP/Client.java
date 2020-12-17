package clientFTP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketException;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;

public class Client {

	public static void main(String args[]) {
		String server = "localhost";
        int port = 2221;
        String user = "harrypotter@hogwarts.net";
        String pass = "123456";
        
        // AQUI VA EL LOGIN
        
        
        
        //FTPSClient ftpClient = new FTPSClient("SSL");
        //ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        
        FTPClient ftpClient = new FTPClient();
        try {
        	ftpClient.connect(server, port);
        	System.out.println("Conexion establecida");
        	Methods methods = new Methods(ftpClient);  
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(replyCode)) {
                System.out.println("Operation failed. Server reply code: " + replyCode);
                return;
            }
            
            
            
            /*
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            if (!success) {
                System.out.println("Could not login to the server");
                return;
            } else {
                System.out.println("LOGGED IN SERVER");
            }
            */
            
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private static void showServerReply(FTPClient ftpClient) {
	    String[] replies = ftpClient.getReplyStrings();
	    if (replies != null && replies.length > 0) {
	        for (String aReply : replies) {
	            System.out.println("SERVER: " + aReply);
	        }
	    }
	}
}
