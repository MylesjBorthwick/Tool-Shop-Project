package controller;

import managers.ClientDBManager;
import model.CustomerList;


/**
 * This class controls the backend functionality for the client, including updating & adding clients, searching for client information, 
 * and returning responses. This class will use the customerList to set responses to send back to the GUI. 
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

public class ClientMainController 
{

	private ClientDBManager clientDB;
	private CustomerList customerList;

	/**
	 * Default constructor that will create a DB manager and pull all the information from the SQL database to populate the customer list instance
	 */
    public ClientMainController(){
		clientDB = new ClientDBManager();
		customerList = new CustomerList(clientDB.getAll());
	}        


	/**
	 * method to receive queries from the frontend and send a response by populating the response field of the InventoryModel. Query codes
	 * call methods in the backend shop and SQL database to achieve the following features (by query id number):
	 * 1: add a new client
	 * 2: update a client by id (null fields are ignored)
	 * 3: remove a client by id
	 * 4: display client information by id
	 * 5: display client information by last name
	 * 6: display client information by client type
	 * @param query the input query that contains the query id to find, and will store the response
	 * @return query object that has the response and all previous fields
	 */
	public synchronized Object receiveQuery(CustomerModel query){
		switch(query.getQueryId()){
				case 1:
					clientDB.addClient(new model.Client(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), query.isClientType()));
					query.setResponse(customerList.addCustomer(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), query.isClientType()));
				break;
				case 2:
					clientDB.updateClient(new model.Client(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), query.isClientType()));
					query.setResponse(customerList.updateCustomer(query.getClientId(),query.getFirstName(), query.getLastName(),query.getAddress(),query.getPostalCode(), query.getPhoneNumber(), query.isClientType()));
					break;
				case 3:		
					clientDB.deleteClient(query.getClientId());		
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

}