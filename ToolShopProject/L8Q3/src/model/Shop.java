package model;
/**
 * Shop class sets the Inventory and SupplierList for the shop
 * This class makes calls to inventory to search and decrease Tools
 * @author Myles Borthwick
 * @version 1.0
 * @since Oct, 2020
 */

public class Shop {

	private Inventory theInventory;
	private SupplierList suppliers;

	
	/**
	 * Initializes the shop with the supplier and inventory classes
	 * @param theInventory to initialize
	 * @param suppliers to initialize
	 */
	public Shop(Inventory theInventory, SupplierList suppliers) {
		this.theInventory = theInventory;
		this.suppliers = suppliers;
	}

	/**
	 *	@return a string containing all the generated aspects of an order
	 */
	public synchronized String generateOrder() {
		return theInventory.getMyOrder().toString();
	}

	
	/**
	 * attempts to reduce an item and returns a description of whether this was successful
	 *	@return string indicating the success or failure of an item reduction
	 */
	public synchronized String reduceItem(String itemName) {
		if(theInventory.manageTool(itemName) != null) {		
			return "Success! Reduced the number of items."; }
		return "Unable to reduce the number of items.";	
	}

	/**
	 * overloaded method to find an item by its name
	 * @param itemName to search
	 *	@return string of the item 
	 */
	public synchronized String getItem(String itemName) {
		Tool foundItem = theInventory.searchForToolName(itemName);
		if(foundItem == null)
			return "\nItem not found. \n";
		return foundItem.toString();
	}
	
	/**
	 * overloaded method to find an item by its id
	 * @param id to search for
	 *	@return string of the item 
	 */
	public synchronized String getItem(int id) {
		Tool foundItem = theInventory.searchForToolId(id);
		if(foundItem == null)
			return "\nItem not found. \n";
		return foundItem.toString();
	}
	
	/**
	 * gets the quantity in stock of an item searched for by name
	 * @param itemName to search
	 *	@return string of the item's quantity, or an error message
	 */
	public synchronized String getQuantity(String itName) {
		Tool foundItem = theInventory.searchForToolName(itName);
		if(foundItem == null)
			return "\nItem not found. \n";
		return "\nItem Quantity: " + foundItem.getToolQuant() + "\n";
	}
	
	
	/**
	 *	prints out the full inventory
	 */
	public synchronized String printoutOfInventory() {
		return theInventory.toString();
	}

	public synchronized int getToolId(String toolName) {
		Tool foundItem = theInventory.searchForToolName(toolName);
		return foundItem.getToolId();
	}
	

	
	
}
