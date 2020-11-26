package managers;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * This class manages the international SQL database, creating and populating the table within the database with the international.txt
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

public class SupplierTypeDBManager {

	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "toolshop607", tableName = "international", dataFile = "international.txt";
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the
	// "[DATABASE NAME]" blank to get a connection and create one with the
	// createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/toolshop607", // "jdbc:mysql://localhost:3306/toolshop",
			login = "root", password = "2703961Five!";

	/**
	 * Constructor that initializes a connection to the specified database
	 */
	public SupplierTypeDBManager()
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
	 * Create a data table inside of the database to hold the supplier international information
	 */
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
	 * Fills the data table with all the international supplier information from the text file 'international.txt' if found
	 */
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

	/**
	 * Prints all the international supplier information in the database to console
	 */
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