package controller;

import java.sql.SQLException;

import com.mysql.fabric.xmlrpc.Client;

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

	/**
	 * addNewCustomer
	 * (Inventory)1: print all tools
	 * 4: remaining quantity
	 * 5: reduce quantity
	 * 6: show order

(Customer)
1:  add New Customer
2: update Customer (set any non-updating fields to null)
3: remove Customer
4: search Customer (by id)
5: search Customer (by last name)
6: search Customer (by type)
+updateCustomer()
+removeCustomer()
+searchCustomer(): void
overload by lastname, id, and type for search

+switch()*/
	public Object receiveQuery(CustomerModel query){
		switch(query.getQueryId()){
				case 1:
					query.setResponse(customerList.addCustomer(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), query.isClientType()));
				break;
				case 2:
					query.setResponse(customerList.updateCustomer(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), query.isClientType()));
					break;
				case 3:				
					query.setResponse(customerList.removeCustomer(query.getClientId()));
				break;
				case 4:
					query.setResponse(customerList.findClientId(query.getClientId()));
				break;
				case 5:
					query.setResponse(customerList.findClientName(query.getLastName()));
				break;
				case 6:
					query.setResponse(customerList.findClientType(query.isClientType()));
				break;
				default:
					query.setResponse("Invalid query id\n");
				break;
		}
		return query;
	}




    public static void main(String[] args) throws Exception 
    {
        ClientMainController clientMainControl = new ClientMainController();
    }
}