package controller;

import java.io.*;
import java.net.Socket;
import model.CustomerModel;
import model.InventoryModel;
import view.CustomerGUI;

/**
 * This class connects the front end GUI controllers to the server. It instantiates the first of the GUI controllers,
 * begins a connection, and has the necessary methods to send serializable models to the server
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
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
	/**
	 * Method that will pipeline a serializable object to the backend server and return the response
	 * @param sendRequest the serializable to be sent to the server
	 * @return the server response, if no response is received after 10 tries, returns the input object
	 */
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
	
	public static void main(String[] args)  {
		ClientSocket aClient = new ClientSocket("localhost", 8099);
		aClient.pipelineRequest(new InventoryModel());
        CustomerGUI cust = new CustomerGUI();
        CustomerModel cm = new CustomerModel();
		CustomerGUIController cont = new CustomerGUIController(cust, cm, aClient);
	}


}