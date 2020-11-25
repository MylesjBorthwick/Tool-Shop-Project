package controller;

import java.io.Serializable;
import java.sql.SQLException;

import managers.ElectricalManager;
import managers.InventoryDBManager;
import managers.SupplierDBManager;
import model.Inventory;
import model.Shop;
import model.SupplierList;
import model.Tool;

public class InventoryMainController 
{
    private InventoryDBManager inventoryDBManager;
    private SupplierDBManager supplierDBManager;
    private Shop shop;
    

    public InventoryMainController(){
		inventoryDBManager = new InventoryDBManager();

        shop = new Shop(new Inventory(inventoryDBManager.getAllTools()),new SupplierList(supplierDBManager.getAllSuppliers()));

	}        
        
    

	/**
	 *	body of the front end, which calls the methods to display menu, receive results, and then interprets the menu items through 
	 * a switch statement to generate the proper response from the backend, calling on the shop to generate an output
	 */
	public Object receiveQuery(InventoryModel query){
		switch(query.getQueryId()){
				case 1:
					System.out.println(shop.printoutOfInventory());
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