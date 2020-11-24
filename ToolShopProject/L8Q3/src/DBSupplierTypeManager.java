import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Pre-Project Exercise 

// This program allows you to create and manage a store inventory database.
// It creates a database and datatable, then populates that table with tools from
// Tools.txt.
public class DBSupplierTypeManager {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "toolshop", tableName = "international", dataFile = "international.txt";
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the
	// "[DATABASE NAME]" blank to get a connection and create one with the
	// createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/toolshop", // "jdbc:mysql://localhost:3306/toolshop",
			login = "root", password = "2703961Five!";

	public DBSupplierTypeManager()
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
					 "IMPORTTAX DOUBLE(16,8) NOT NULL, "+
				     "PRIMARY KEY ( ID ), FOREIGN KEY ( ID ) REFERENCES suppliers( SUPPLIERID ) )";
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
				String supplierInfo[] = sc.nextLine().split(";");
				String sql = "INSERT INTO " + tableName +
					" VALUES ( " + 
					Integer.parseInt(supplierInfo[0]) + ", " + 
					Double.parseDouble(supplierInfo[1]) + " );";
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
				System.out.println(tools.getInt("ID") + " " + 
								   tools.getString("IMPORTTAX"));
			}
			tools.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}