/**

 * @author Myles Borthwick
 * @author Ken Loughery
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Server {
	
	private Socket theSocket;
	private ServerSocket serverSocket; 
	private ExecutorService handleClients;

	
	/**
	 * constructor that starts the server
	 */
	public Server(int port) {
		try {
			serverSocket = new ServerSocket(port);
			System.out.println("Server is running...");
			handleClients = Executors.newFixedThreadPool(10);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}


		
	
	/**
	* method that runs the server - does not return, continues to wait for new
	* players and starts games until externally stopped
	*/
	public void runServer () {

		while (true) {
			connectNewSocket();
			
			handleClients.execute(new ServerThread(theSocket));
	        	        
		}
	}

	
	/**
	 * method that waits for a new connection, then sets theSocket to the new connection
	*/
	private void connectNewSocket() {
		
		try {
			this.theSocket = this.serverSocket.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * closes all server connections
	 */
	public void disconnect() {

		try {
			theSocket.close();
			serverSocket.close();		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Driver function for server
	 * @param args external arguments passed on run (not used)
	 */
	public static void main (String [] args) {
	
			Server myServer = new Server(8099); //same port as for client
			myServer.runServer();
			myServer.disconnect();
	}
}
