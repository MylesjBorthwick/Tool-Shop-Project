
/**
 * This class handles the two client sockets during the game, to allow them to communicate
 * and update themselves during gameplay, until an end-game condition has been achieved
 * 
 * ENSF 607 Lab 6
 * @author Myles Borthwick
 * @author Ken Loughery
 */

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {

	private ObjectOutputStream socketOut;
	private ObjectInputStream socketIn;
	private ServerMainController maincontroller;
	/**
	 * Constructor that receives two sockets, one for each player, and initiates the
	 * player names from them to complete the player classes
	 * 
	 * @param player1 the socket for the connections from the first player
	 * @param player2 the socket for the connections from the second player
	 */
	public ServerThread(Socket theSocket, ServerMainController maincontroller) {
		this.maincontroller = maincontroller;
		try {
			socketOut = new ObjectOutputStream(theSocket.getOutputStream());
			socketIn = new ObjectInputStream(theSocket.getInputStream());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that will run to organize the gameplay, sending messages to each
	 * client when it is their turn, as well as with end-game conditions, as needed.
	 */

	@Override
	public void run() {

		try {
			System.out.println(socketIn.readObject().getClass());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

	public synchronized void pipeline(){
		
	}
	
} // end of class
