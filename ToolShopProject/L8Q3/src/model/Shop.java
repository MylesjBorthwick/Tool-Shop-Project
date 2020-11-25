package model;
/**
 * Shop class sets the Inventory and SupplierList for the shop
 * This class makes calls to inventory to search and decrease Tools
 * @author Myles Borthwick
 * @version 1.0
 * @since Oct, 2020
 */

public class Shop {

    private Inventory shopInventory;
    private SupplierList shopSuppliers;

    /**
     * Shop constructor
     * @param inventory of shop
     * @param suppliers of shop
     */
    public Shop(Inventory inventory, SupplierList suppliers){

        setShopInventory(inventory);
        setShopSuppliers(suppliers);
    }

    /**
     * Function too print shop's Tools
     */
    public void listShopTools(){
        System.out.println(shopInventory);
    }

    /**
     * Gets Tool by name from inventory
     * @param name
     * @return searched Tool
     */
    public String getToolName(String name){
        Tool theTool = shopInventory.searchForToolName(name);
        if(theTool==null){
            String s = "Sorry, no Tool matching that name was found in inventory";
            return s;
        }
        else{
            return theTool.toString();
        }
    }
    /**
     * Gets Tool by id from inventory
     * @param id
     * @return searched Tool
     */
    public String getToolId(int id){
        Tool theTool = shopInventory.searchForToolId(id);
        if(theTool==null){
            String s = "Sorry, no Tool matching that ID was found in inventory";
            return s;
        }
        else{
            return theTool.toString();
        }
    }

    /**
     * Finds quantity of Tool by searching
     * Tool by name in inventory
     * @param name
     * @return qunatity of searched Tool
     */
    public String getToolQuant(String name){
        Tool theTool = shopInventory.searchForToolName(name);
        if(theTool==null){
            String s = "Sorry, no Tool matching that name was found in inventory";
            return s;
        }
        else{
            int quant = theTool.getToolQuant();
            return Integer.toString(quant);
        }
    }
    /**
     * Checks to see if Tool could be decreased in inventory
     * @param name
     * @return messsage
     */
    public String decreaseTool(String name){
        if(shopInventory.manageTool(name)==null){
            return "Couldn't decrease Tool quantity\n";
        }

        else{
            return "Tool quantity was decreased\n";
        }
    }

    /**
     * @return Inventory return the shopInventory
     */
    public Inventory getShopInventory() {
        return shopInventory;
    }

    /**
     * @param shopInventory the shopInventory to set
     */
    public void setShopInventory(Inventory shopInventory) {
        this.shopInventory = shopInventory;
    }

    /**
     * @return SupplierList return the shopSuppliers
     */
    public SupplierList getShopSuppliers() {
        return shopSuppliers;
    }

    /**
     * @param shopSuppliers the shopSuppliers to set
     */
    public void setShopSuppliers(SupplierList shopSuppliers) {
        this.shopSuppliers = shopSuppliers;
    }

}
