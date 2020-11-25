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
	 * 
+updateCustomer()
+removeCustomer()
+searchCustomer(): void
overload by lastname, id, and type for search

+switch()*/
	public Object receiveQuery(CustomerModel query){
		switch(query.getQueryId()){
				case 1:
					String clientType = "R";
					if(query.isClientType()){clientType = "C";}
					query.setResponse(customerList.addCustomer(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), clientType));
				break;
				case 2:
					query.setResponse(shop.getItem(query.getToolName()));
				break;
				case 3:					
					query.setResponse(shop.getItem(query.getId()));
				break;
				case 4:
					query.setResponse(shop.getQuantity(query.getToolName()));
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