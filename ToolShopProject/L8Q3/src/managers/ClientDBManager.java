package managers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import model.Client;


/**
 * This class manages the client SQL database, creating and populating the table within the database with the clients.txt
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

public class ClientDBManager {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "toolshop607", tableName = "Clients", dataFile = "clients.txt";
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/toolshop607",  
				  login          = "root",
				  password       = "2703961Five!";


	/**
	 * Constructor that initializes a connection to the specified database
	 */
	public ClientDBManager()
	{
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			Class.forName("com.mysql.jdbc.Driver");
			
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	
	
	/**
	 * Use the jdbc connection to create a new database in MySQL. 
	 * (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database will be created at "jdbc:mysql://localhost:3306/toolshop")
	 */
	public void createDB()
	{
		try {
			statement = jdbc_connection.createStatement();
			statement.executeUpdate("CREATE DATABASE " + databaseName);
			System.out.println("Created Database " + databaseName);
		} 
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a data table inside of the database to hold clients
	 */
	public void createTable()
	{
		String sql = "CREATE TABLE " + tableName + "(" +
					"ID INT(4) NOT NULL, " +
					"FIRSTNAME VARCHAR(20) NOT NULL, " + 
					"LASTNAME VARCHAR(20) NOT NULL, " + 
					"ADDRESS VARCHAR(50) NOT NULL, " + 
					"POSTALCODE CHAR(7) NOT NULL, " + 
					"PHONENUMBER CHAR(12) NOT NULL, " + 
					"CLIENTTYPE CHAR(1) NOT NULL," +
					"PRIMARY KEY ( id ))";
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Created Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * pulls all the clients from the database table
	 * @return ArrayList of Client
	 */
	public ArrayList<Client> getAll()
	{
		ArrayList<Client> list = new ArrayList<Client>();
		String sql = "SELECT * FROM " + tableName;
		ResultSet client;
		try {
			statement = jdbc_connection.createStatement();
			client = statement.executeQuery(sql);
			while(client.next())
			{
				list.add( new Client(client.getInt("ID"),
								  client.getString("FIRSTNAME"),
								  client.getString("LASTNAME"),
								  client.getString("ADDRESS"),
								  client.getString("POSTALCODE"),
								  client.getString("PHONENUMBER"),
								  client.getString("CLIENTTYPE")));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return list;
	}

	/**
	 * Removes the data table from the database (and all the data held within it!)
	 */
	public void removeTable()
	{
		String sql = "DROP TABLE " + tableName;
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
			System.out.println("Removed Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Fills the data table with all the clients from the text file 'clients.txt' if found
	 */
	public void fillTable()
	{
		try{
			int newID = 1;
			Scanner sc = new Scanner(new FileReader(dataFile));
			while(sc.hasNext())
			{
				String clientInfo[] = sc.nextLine().split(";");
				addClient( new Client(newID++, clientInfo[0], clientInfo[1], clientInfo[2],
				clientInfo[3], clientInfo[4], clientInfo[5]));
			}
			sc.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File " + dataFile + " Not Found!");
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
	}


	/**
	 * delete a row from the client table that matches the client id
	 * @param clientId of the client to delete (if not found does nothing)
	 */
	public synchronized void deleteClient(int clientId)
	{
		String sql = "DELETE FROM " + tableName +
				" WHERE ID = " + clientId + ";";
		System.out.println(sql);
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * updates a client found by their client id with new values. If any fields in the received client are 
	 * null these are skipped, if client id is not found does nothing
	 * @param client information client class containing update information
	 */
	public synchronized void updateClient(Client client)
	{
		boolean updatedField = false;
		String sql = "UPDATE " + tableName + " SET ";
		if(client.getFirstName()!= null){
			sql += "FIRSTNAME = '"+ client.getFirstName()+"'";
			updatedField = true;
		}
		if(client.getLastName() != null){
			if(updatedField){
				sql += ", LASTNAME = '"+ client.getLastName()+"'";
			}else{
				sql += "LASTNAME = '"+ client.getLastName()+"'";
			}
			updatedField = true;
		}
		if(client.getAddress()!=null){
			if(updatedField){
				sql += ", ADDRESS = '"+ client.getLastName()+"'";
			}else{
				sql += "ADDRESS = '"+ client.getLastName()+"'";
			}			
			updatedField = true;
		}
		if(client.getPostalCode() != null){
			if(updatedField){
				sql += ", POSTALCODE = '"+ client.getPostalCode()+"'";
			}else{
				sql += "POSTALCODE = '"+ client.getPostalCode()+"'";
			}	
			updatedField = true;
		}
		if(client.getPhoneNumber()!= null){
			if(updatedField){
				sql += ", PHONENUMBER = '"+ client.getPhoneNumber()+"'";
			}else{
				sql += "PHONENUMBER = '"+ client.getPhoneNumber()+"'";
			}	
			updatedField = true;
		}
		if(client.getClientType()!= null){
			if(updatedField){
				sql += ", CLIENTTYPE = '"+ client.getClientType()+"'";
			}else{
				sql += "CLIENTTYPE = '"+ client.getClientType()+"'";
			}			
			updatedField = true;
		}
		if(updatedField){
			sql+= " WHERE ID = " + Integer.toString(client.getId());
			System.out.println(sql);
			try{
				statement = jdbc_connection.createStatement();
				statement.executeUpdate(sql);
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}

	}

	/**
	 * add a client to the database table
	 * @param client client to add to table
	 */
	public synchronized void addClient(Client client)
	{
		String sql = "INSERT INTO " + tableName +
				" VALUES ( " + client.getId() + ", '" + 
				client.getFirstName() + "', '" + 
				client.getLastName() + "', '" + 
				client.getAddress() + "', '" + 
				client.getPostalCode()+"', '"+
				client.getPhoneNumber() + "', '" + 
				client.getClientType() + "');";
		System.out.println(sql);
		try{
			statement = jdbc_connection.createStatement();
			statement.executeUpdate(sql);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}


	/**
	 * This method searches the database table for a client matching the clientID parameter and return that client.
	 * @param clientId to search for
	 * @return client found, or null if not found
	 */
	public Client searchClient(int clientId)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE ID=" + clientId;
		ResultSet client;
		try {
			statement = jdbc_connection.createStatement();
			client = statement.executeQuery(sql);
			if(client.next())
			{
				return new Client(client.getInt("ID"),
								  client.getString("FIRSTNAME"),
								  client.getString("LASTNAME"),
								  client.getString("ADDRESS"),
								  client.getString("POSTALCODE"),
								  client.getString("PHONENUMBER"),
								  client.getString("CLIENTTYPE"));
			}
		
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}

	/**
	 * Prints all the clients in the database to console
	 */
	public void printTable()
	{
		try {
			String sql = "SELECT * FROM " + tableName;
			statement = jdbc_connection.createStatement();
			ResultSet clients = statement.executeQuery(sql);
			System.out.println("Clients:");
			while(clients.next())
			{
				System.out.println(clients.getInt("ID") + " " + 
								   clients.getString("FIRSTNAME")+ " " +
								   clients.getString("LASTNAME") + " " + 
								   clients.getString("ADDRESS")+ " " +
								   clients.getString("POSTALCODE") + " " +
								   clients.getString("PHONENUMBER")+ " " +
								   clients.getString("CLIENTTYPE")
								   );
			}

		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @param args[]
	 */
	public static void main(String args[])
	{
		ClientDBManager clientList = new ClientDBManager();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//inventory.createDB();

		clientList.createTable();
		
		System.out.println("\nFilling the table with clients");
		clientList.fillTable();

		System.out.println("Reading all clients from the table:");
		clientList.printTable();

		System.out.println("\nSearching table for client 1002: should return 'Dr.Evil'");
		int clientId = 5;
		Client searchResult = clientList.searchClient(clientId);
		if(searchResult == null)
			System.out.println("Search Failed to find a client matching ID: " + clientId);
		else
			System.out.println("Search Result: " + searchResult.toString());

		System.out.println("\nSearching table for client 9000: should fail to find a client");
		clientId = 9000;
		searchResult = clientList.searchClient(clientId);
		if(searchResult == null)
			System.out.println("Search Failed to find a client matching ID: " + clientId);
		else
			System.out.println("Search Result: " + searchResult.toString());
		
		//System.out.println("\nTrying to remove the table");
		//clientList.removeTable();
		
		try {
			clientList.statement.close();
			clientList.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
	}
}