package server;

/**
 * This class handles the communications from the clients who have connected to the server,
 * sending the information to the main backend controller until the client disconnects
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

import java.io.*;
import java.net.Socket;

import controller.ServerMainController;

public class ServerThread implements Runnable {

	private ObjectOutputStream socketOut;
	private ObjectInputStream socketIn;
	private ServerMainController mainController;

	/**
	 * Constructor that receives a socket, initiates the input and output streams, and
	 * sets the main controller to pass the incoming objects to
	 * @param theSocket the socket for the connections from the first player
	 * @param mainController the socket for the connections from the second player
	 */
	public ServerThread(Socket theSocket, ServerMainController mainController) {
		this.mainController = mainController;
		try {
			socketOut = new ObjectOutputStream(theSocket.getOutputStream());
			socketIn = new ObjectInputStream(theSocket.getInputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that will run to pass the objects to the backend and send the received objects back to the 
	 * client socket
	 */
	@Override
	public void run() {
		Object receive = null;
		while(true){
			try {
				receive = socketIn.readObject();
				if(receive!= null){
					socketOut.writeObject(mainController.passSerial(receive));	
				}
				Thread.sleep(1000);
			} catch(EOFException e){
				break;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}


	}


	
} // end of class
