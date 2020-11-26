package controller;
import managers.ClientDBManager;
import model.CustomerList;

public class ClientMainController 
{

	private ClientDBManager clientDB;
	private CustomerList customerList;

    public ClientMainController(){
		clientDB = new ClientDBManager();
		customerList = new CustomerList(clientDB.getAll());
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




    public static void main(String[] args) throws Exception 
    {
        ClientMainController clientMainControl = new ClientMainController();
    }
}