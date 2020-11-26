package managers;

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

import model.Tool;

// Pre-Project Exercise 

// This program allows you to create and manage a store inventory database.
// It creates a database and datatable, then populates that table with tools from
// Tools.txt.
public class InventoryDBManager {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "toolshop", tableName = "Tools", dataFile = "items.txt";
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/toolshop",  //"jdbc:mysql://localhost:3306/toolshop",
				  login          = "root",
				  password       = "Engineering4Elohim" ;

	public InventoryDBManager()
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
					 "TYPE VARCHAR(20) NOT NULL, "+
				     "TOOLNAME VARCHAR(20) NOT NULL, " + 
				     "QUANTITY INT(4) NOT NULL, " + 
				     "PRICE DOUBLE(5,2) NOT NULL, " + 
				     "SUPPLIERID INT(4) NOT NULL, " + 
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

	// Fills the data table with all the tools from the text file 'Tools.txt' if found
	public void fillTable()
	{
		try{
			Scanner sc = new Scanner(new FileReader(dataFile));
			while(sc.hasNext())
			{
				String toolInfo[] = sc.nextLine().split(";");
				addTool( new Tool( Integer.parseInt(toolInfo[0]),
													toolInfo[1],
													toolInfo[2],
						           Integer.parseInt(toolInfo[3]),
						         Double.parseDouble(toolInfo[4]),
						           Integer.parseInt(toolInfo[5])));
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
	public void updateToolQuantity(int toolId)
	{
		Tool foundTool =  searchTool(toolId);
		
		if(foundTool.getToolQuant()-1 >= 0){
			String sql = "UPDATE " + tableName + " SET QUANTITY = "+ 
			Integer.toString(foundTool.getToolQuant()-1) + " WHERE ID = " 
			+ Integer.toString(toolId);
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

	// Add a tool to the database table
	public void addTool(Tool tool)
	{
		String sql = "INSERT INTO " + tableName +
				" VALUES ( " + tool.getToolId() + ", '" + 
				tool.getType() + "', '" + 
				tool.getToolName() + "', " + 
				tool.getToolQuant() + ", " + 
				tool.getToolPrice() + ", " + 
				tool.getSupplierId() + ");";
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
	public Tool searchTool(int toolID)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE ID=" + toolID;
		ResultSet tool;
		try {
			statement = jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			if(tool.next())
			{
				return new Tool(tool.getInt("ToolId"),
								tool.getString("Type"),
								tool.getString("ToolName"), 
								tool.getInt("Quantity"), 
								tool.getDouble("Price"), 
								tool.getInt("SupplierId"));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}

	// This method should search the database table for a tool matching the toolID parameter and return that tool.
	// It should return null if no tools matching that ID are found.
	public ArrayList<Tool> getAllTools()
	{
		ArrayList<Tool> array = new ArrayList<Tool>();
		String sql = "SELECT * FROM " + tableName;
		ResultSet tool;
		try {
			statement = jdbc_connection.createStatement();
			tool = statement.executeQuery(sql);
			while(tool.next())
			{
				array.add(new Tool(tool.getInt("ToolId"),
								tool.getString("Type"),
								tool.getString("ToolName"), 
								tool.getInt("Quantity"), 
								tool.getDouble("Price"), 
								tool.getInt("SupplierId")));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return array;
	}




	// Prints all the Tools in the database to console
	public void printTable()
	{
		try {
			String sql = "SELECT * FROM " + tableName;
			statement = jdbc_connection.createStatement();
			ResultSet tools = statement.executeQuery(sql);
			System.out.println("Tools:");
			while(tools.next())
			{
				System.out.println(tools.getInt("ToolId") + " " + 
								   tools.getString("Type")+ " " +
								   tools.getString("ToolName") + " " + 
								   tools.getInt("Quantity") + " " + 
								   tools.getDouble("Price") + " " + 
								   tools.getInt("SupplierId"));
			}
			tools.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	


	public static void main(String args[])
	{
		InventoryDBManager inventory = new InventoryDBManager();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//inventory.createDB();

		inventory.createTable();
		
		System.out.println("\nFilling the table with tools");
		inventory.fillTable();

		System.out.println("Reading all tools from the table:");
		inventory.printTable();

		System.out.println("\nSearching table for tool 1002: should return 'Grommets'");
		int toolID = 1002;
		Tool searchResult = inventory.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());

		System.out.println("\nSearching table for tool 9000: should fail to find a tool");
		toolID = 9000;
		searchResult = inventory.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());
		

		//MANAGE THE ELECTRICALS

		ElectricalManager electricalAddOns = new ElectricalManager();
	
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//inventory.createDB();

		electricalAddOns.createTable();
		
		System.out.println("\nFilling the table with tools");
		electricalAddOns.fillTable();

		System.out.println("Reading all tools from the table:");
		electricalAddOns.printTable();


		//System.out.println("\nTrying to remove the table");
		//electricalAddOns.removeTable();
		
		try {
			electricalAddOns.statement.close();
			electricalAddOns.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}

		

		//System.out.println("\nTrying to remove the table");
		//inventory.removeTable();
		
		try {
			inventory.statement.close();
			inventory.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
	}
}