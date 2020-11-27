package server;

/**
 * This class runs the server socket and sets up threads for the client to connect to with socket information and a 
 * mainController to pass objects to
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import controller.ServerMainController;


public class Server {
	
	private Socket theSocket;
	private ServerSocket serverSocket; 
	private ExecutorService handleClients;
	private ServerMainController mainController;

	
	/**
	 * Constructor that initializes the server with a port and mainController
	 * @param port number of the server port
	 * @param mainController the mainController required to set up threads
	 */
	public Server(int port,ServerMainController mainController) {
		this.mainController = mainController;
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
	* connections and starts threads until externally interrupted
	*/
	public void runServer () {
		while (true) {
			connectNewSocket();
			handleClients.execute(new ServerThread(theSocket, mainController));
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


}
