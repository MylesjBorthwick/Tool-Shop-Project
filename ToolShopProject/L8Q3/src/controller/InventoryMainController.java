package controller;

import java.io.Serializable;
import java.sql.SQLException;

import managers.ElectricalManager;
import managers.InventoryManager;
import managers.SupplierManager;
import model.Inventory;
import model.Shop;
import model.SupplierList;
import model.Tool;

public class InventoryMainController 
{
    private InventoryManager inventoryDBManager;
    private ElectricalManager electricalDBManager;
    private SupplierManager supplierDBManager;
    private Shop shop;
    

    public InventoryMainController(){
		inventoryDBManager = new InventoryManager();
		inventoryDBManager.createTable();
		System.out.println("\nFilling the table with tools");
		inventoryDBManager.fillTable();
		System.out.println("Reading all tools from the table:");
		inventoryDBManager.printTable();

		System.out.println("\nSearching table for tool 1002: should return 'Grommets'");
		int toolID = 1002;
		Tool searchResult = inventoryDBManager.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());

		System.out.println("\nSearching table for tool 9000: should fail to find a tool");
		toolID = 9000;
		searchResult = inventoryDBManager.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());
		

		//MANAGE THE ELECTRICALS

		electricalDBManager = new ElectricalManager();
	
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		//inventory.createDB();

		electricalDBManager.createTable();
		
		System.out.println("\nFilling the table with tools");
		electricalDBManager.fillTable();

		System.out.println("Reading all tools from the table:");
		electricalDBManager.printTable();


        supplierDBManager = new SupplierManager();
		supplierDBManager.createTable();
		
		System.out.println("\nFilling the table with suppliers");
		supplierDBManager.fillTable();

		System.out.println("Reading all suppliers from the table:");
		supplierDBManager.printTable();



        shop = new Shop(new Inventory(inventoryDBManager.getAllTools()),new SupplierList(supplierDBManager.getAllSuppliers()));

		System.out.println("\nTrying to remove the table");
		electricalDBManager.removeTable();
		
		try {
			electricalDBManager.statement.close();
			electricalDBManager.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}



		System.out.println("\nTrying to remove the table");
		inventoryDBManager.removeTable();
		
		try {
			inventoryDBManager.statement.close();
			inventoryDBManager.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
        }
        

        System.out.println("\nTrying to remove the table");
		supplierDBManager.removeTable();
		
		try {
			supplierDBManager.statement.close();
			supplierDBManager.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
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