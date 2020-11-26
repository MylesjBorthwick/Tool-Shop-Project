package server;

import java.io.*;
import java.net.Socket;
import controller.CustomerGUIController;
import controller.CustomerModel;
import controller.InventoryModel;
import view.CustomerGUI;
/**
 * @author Myles Borthwick
 * @author Ken Loughery
 */

public class ClientSocket {

	private ObjectOutputStream socketOut;
	private ObjectInputStream socketIn;
	private Socket thisSocket;

	/**
	 * Constructor that receives the server information to create a new socket to
	 * establish a connection to the server
	 * 
	 * @param serverName the name of the server to connect to
	 * @param portNumber the port number of the server to connect to
	 */
	public ClientSocket(String serverName, int portNumber) {
		try {
			thisSocket = new Socket(serverName, portNumber);
			socketIn = new ObjectInputStream(thisSocket.getInputStream());
			socketOut = new ObjectOutputStream(thisSocket.getOutputStream());

		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
	}

	public Object pipelineRequest(Serializable sendRequest) {
		for(int i = 0; i< 10;i++){
			try {
				socketOut.writeObject(sendRequest);
				return socketIn.readObject();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sendRequest;
	}
	
	/**
	 * closes all connections
	 */
	public void disconnect() {
		try {
			socketIn.close();
			socketOut.close();
			thisSocket.close();
		} catch (Exception e) {
			System.err.println(e.getStackTrace());
		}
		
	}
	
	/**
	 * main function to run the client
	 */
	public static void main(String[] args)  {
		ClientSocket aClient = new ClientSocket("localhost", 8099);
		aClient.pipelineRequest(new InventoryModel());
        CustomerGUI cust = new CustomerGUI();
        CustomerModel cm = new CustomerModel();
		CustomerGUIController cont = new CustomerGUIController(cust, cm, aClient);
	}


}