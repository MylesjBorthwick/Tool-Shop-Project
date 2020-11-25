package controller;

import java.sql.SQLException;

import managers.ClientManager;
import model.CustomerList;

public class ClientMainController 
{

	private ClientManager clientDBManager;
	private CustomerList customerList;

    public ClientMainController(){
		clientDBManager = new ClientManager();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//inventory.createDB();

		clientDBManager.createTable();
		
		System.out.println("\nFilling the table with clients");
		clientDBManager.fillTable();

		System.out.println("Reading all clients from the table:");
		clientDBManager.printTable();


		customerList = new CustomerList(clientDBManager.getAll());

		System.out.println(customerList.printList());
		System.out.println("\nTrying to remove the table");
		clientDBManager.removeTable();
		
		try {
			clientDBManager.statement.close();
			clientDBManager.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
		
	}        



	


    public static void main(String[] args) throws Exception 
    {
        ClientMainController clientMainControl = new ClientMainController();
    }
}