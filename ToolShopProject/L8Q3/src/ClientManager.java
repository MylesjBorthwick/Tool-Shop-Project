import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

// Pre-Project Exercise 

// This program allows you to create and manage a store inventory database.
// It creates a database and datatable, then populates that table with tools from
// items.txt.
public class ClientManager {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "toolshop", tableName = "Clients", dataFile = "clients.txt";
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/toolshop",  
				  login          = "root",
				  password       = "Engineering4Elohim";

	public ClientManager()
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
	
	// Use the jdbc connection to create a new database in MySQL. 
	// (e.g. if you are connected to "jdbc:mysql://localhost:3306", the database will be created at "jdbc:mysql://localhost:3306/InventoryDB")
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

	// Create a data table inside of the database to hold tools
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

	// Removes the data table from the database (and all the data held within it!)
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

	// Fills the data table with all the tools from the text file 'items.txt' if found
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

	// Add a tool to the database table
	public void addClient(Client client)
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

	// This method should search the database table for a tool matching the toolID parameter and return that tool.
	// It should return null if no tools matching that ID are found.
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



	// Prints all the items in the database to console
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
	
	public static void main(String args[])
	{
		ClientManager clientList = new ClientManager();
		
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