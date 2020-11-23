/**
 * Class representing item in inventory
 * @author Myles Borthwick
 * @version 1.0
 */
public class Tool {
    //Member variables
    private int itemId;
    private double itemPrice;
    private int itemQuant;
    private String itemName;
    private boolean alreadyOrdered;
    private int supplierId;
    private String type;
    /**
     * Item Constructor
     * @param id of tool
     * @param name of tool
     * @param quantity of tool
     * @param price of tool
     * @param sup supplier of tool
     */
    public Tool (int id, String powertype, String name, int quantity, double price, int sup){

        setItemId(id);
        setType(powertype);
        setItemName(name);
        setItemQuant(quantity);
        setItemPrice(price);
        setSupplierId(sup);
        setAlreadyOrdered(false);
        
    }
    /**
     * Decreases item quantity if quantity is positive
     * @return true or false
     */
    public boolean decreaseItemQuant(){
        if(itemQuant>0){
            itemQuant--;
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Creates order line for item
     * @return orderline
     */
    public OrderLine generateOrderLine(){
        OrderLine ol;
        //If quantity drops below 40 and hasnt been ordered
        if(getItemQuant()<40 && alreadyOrdered ==false){
            //Create orderline with 20 of this item
            ol = new OrderLine(this, 20);
            alreadyOrdered = true;
            return ol;
        }
        return null;
    }
    /**
     * ToString method for formatting item 
     */
    @Override
    public String toString(){
        String s = "ItemID:"+getItemId()+", "+ getItemName()+", Quantity:"+getItemQuant()+", Price:"+getItemPrice()+"\n";
        //Optional addition of supplier info for item format
        //+", SupplierInfo:["+getItemSupplier()+"]\n";
        return s;
    }

    /**
     * @return int return the itemId
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * @param itemId the itemId to set
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * @return double return the itemPrice
     */
    public double getItemPrice() {
        return itemPrice;
    }

    /**
     * @param itemPrice the itemPrice to set
     */
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * @return int return the itemQuant
     */
    public int getItemQuant() {
        return itemQuant;
    }

    /**
     * @param itemQuant the itemQuant to set
     */
    public void setItemQuant(int itemQuant) {
        this.itemQuant = itemQuant;
    }

    /**
     * @return String return the itemName
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * @param itemName the itemName to set
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * @return boolean return the alreadyOrdered
     */
    public boolean isAlreadyOrdered() {
        return alreadyOrdered;
    }

    /**
     * @param alreadyOrdered the alreadyOrdered to set
     */
    public void setAlreadyOrdered(boolean alreadyOrdered) {
        this.alreadyOrdered = alreadyOrdered;
    }


    /**
     * @return String return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * @return int return the supplierId
     */
    public int getSupplierId() {
        return supplierId;
    }

    /**
     * @param supplierId the supplierId to set
     */
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

}
