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

import model.Supplier;

/**
 * This class manages the supplies SQL database, creating and populating the table within the database with the suppliers.txt
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */
public class SupplierDBManager {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "toolshop607", tableName = "suppliers", dataFile = "suppliers.txt";
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306/toolshop607",  
				  login          = "root",
				  password       = "Engineering4Elohim";

 	/**
	 * Constructor that initializes a connection to the specified database
	 */
	public SupplierDBManager()
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
	 * Create a data table inside of the database to hold suppliers
	 */
	public void createTable()
	{
		String sql = "CREATE TABLE " + tableName + "(" +
					 "SUPPLIERID INT(4) NOT NULL, " +
					 "TYPE VARCHAR(20) NOT NULL, "+
				     "NAME VARCHAR(45) NOT NULL, " + 
				     "ADDRESS VARCHAR(45) NOT NULL, " + 
				     "CONTACT VARCHAR(20) NOT NULL, " + 
				     "PRIMARY KEY ( SUPPLIERID ))";
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
	 * Fills the data table with all the tools from the text file 'items.txt' if found
	 */
	public void fillTable()
	{
		try{
			Scanner sc = new Scanner(new FileReader(dataFile));
			while(sc.hasNext())
			{
				String supInfo[] = sc.nextLine().split(";");
				addSupplier( new Supplier( Integer.parseInt(supInfo[0]),
													supInfo[1],
                                                    supInfo[2],
                                                    supInfo[3],
                                                    supInfo[4]));
						          
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
	 * add a Supplier to the database table
	 * @param sup to add to table
	 */
	public void addSupplier(Supplier sup)
	{
		String sql = "INSERT INTO " + tableName +
				" VALUES ( " + sup.getSupplierId() + ", '" + 
				sup.getType() + "', '" + 
				sup.getCompanyName() + "', '" + 
				sup.getAddress() + "', '" + 
                sup.getContact() + "');";
                
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
	 * This method searches the database table for a Supplier matching the supplier ID parameter and return that supplier.
	 * @param supId to search for
	 * @return Supplier found, or null if not found
	 */
	public Supplier searchSupplier(int supID)
	{
		String sql = "SELECT * FROM " + tableName + " WHERE SUPPLIERID=" + supID;
		ResultSet sup;
		try {
			statement = jdbc_connection.createStatement();
			sup = statement.executeQuery(sql);
			if(sup.next())
			{
				return new Supplier(sup.getInt("SUPPLIERID"),
								sup.getString("TYPE"),
								sup.getString("NAME"), 
                                sup.getString("ADDRESS"),
                                sup.getString("CONTACT"));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}

	/**
	 * pulls all the suppliers from the database table
	 * @return ArrayList of all Supplier
	 */
	public ArrayList<Supplier> getAllSuppliers()
	{
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
		String sql = "SELECT * FROM " + tableName;
		ResultSet sup;
		try {
			statement = jdbc_connection.createStatement();
			sup = statement.executeQuery(sql);
			while(sup.next())
			{
				suppliers.add(new Supplier(sup.getInt("SUPPLIERID"),
								sup.getString("TYPE"),
								sup.getString("NAME"), 
                                sup.getString("ADDRESS"),
                                sup.getString("CONTACT")));
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return suppliers;
	}


	/**
	 * Prints all the suppliers in the database to console
	 */
	public void printTable()
	{
		try {
			String sql = "SELECT * FROM " + tableName;
			statement = jdbc_connection.createStatement();
			ResultSet sups = statement.executeQuery(sql);
			System.out.println("Suppliers:");
			while(sups.next())
			{
				System.out.println(sups.getInt("SUPPLIERID")+" "+
                                    sups.getString("TYPE")+ " " +
                                    sups.getString("NAME")+ " " + 
                                    sups.getString("ADDRESS")+ " " +
                                    sups.getString("CONTACT"));
                    

			}
			sups.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		SupplierDBManager suplist = new SupplierDBManager();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//suplist.createDB();

		suplist.createTable();
		
		System.out.println("\nFilling the table with suppliers");
		suplist.fillTable();

		System.out.println("Reading all suppliers from the table:");
		suplist.printTable();
        
		
		SupplierTypeDBManager supType = new SupplierTypeDBManager();
		//supType.createDB();
		supType.createTable();
		supType.fillTable();
		supType.printTable();

		//System.out.println("\nTrying to remove the table");
		//supType.removeTable();
		
		try {
			supType.statement.close();
			supType.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}

		//System.out.println("\nTrying to remove the table");
		//suplist.removeTable();
		
		try {
			suplist.statement.close();
			suplist.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
	}
}