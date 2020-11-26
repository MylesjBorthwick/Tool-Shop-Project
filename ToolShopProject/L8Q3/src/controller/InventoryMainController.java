package controller;

import managers.InventoryDBManager;
import managers.SupplierDBManager;
import model.Inventory;
import model.Shop;
import model.SupplierList;

/**
 * This class controls the backend functionality for the inventory, including decrementing the items, searching for items, 
 * and returning responses. This class will use the InventoryModel to set responses to send back to the GUI. 
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */
public class InventoryMainController 
{
    private InventoryDBManager inventoryDBManager;
    private SupplierDBManager supplierDBManager;
    private Shop shop;
    

	/**
	 * Default constructor that will create a DB manager and pull all the information from the SQL database to populate the shop instance
	 */
    public InventoryMainController(){
		inventoryDBManager = new InventoryDBManager();
		supplierDBManager = new SupplierDBManager();
        shop = new Shop(new Inventory(inventoryDBManager.getAllTools()),new SupplierList(supplierDBManager.getAllSuppliers()));

	}        
        

	/**
	 * method to receive queries from the frontend and send a response by populating the response field of the InventoryModel. Query codes
	 * call methods in the backend shop and SQL database to achieve the following features (by query id number):
	 * 1: display all the tools
	 * 2: tool information by tool name
	 * 3: tool information by tool id
	 * 4: tool quantity by tool name
	 * 5: decrease tool quantity
	 * 6: display order information
	 * @param query the input query that contains the query id to find, and will store the response
	 * @return query object that has the response and all previous fields
	 */
	public synchronized Object receiveQuery(InventoryModel query){
		switch(query.getQueryId()){
				case 1:
					query.setResponse(shop.printoutOfInventory());
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
				case 5:
					inventoryDBManager.updateToolQuantity(shop.getToolId(query.getToolName()));
					query.setResponse(shop.reduceItem(query.getToolName()));
				break;
				case 6: 
					query.setResponse(shop.generateOrder());
				break;
				default:
					query.setResponse("Invalid query id\n");
				break;
		}
		return query;
	}




    public static void main(String[] args) throws Exception 
    {
        InventoryMainController InventoryMainController = new InventoryMainController();
    }
}