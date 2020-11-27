package model;
/**
 * Class representing Tool in inventory
 * @author Ken Loughery
 * @author Myles Borthwick
 * @since Nov, 2020
 */

public class Tool {

    private int ToolId;
    private double ToolPrice;
    private int ToolQuant;
    private String ToolName;
    private boolean alreadyOrdered;
    private int supplierId;
    private String type;

    /**
     * Tool Constructor
     * @param id of tool
     * @param name of tool
     * @param quantity of tool
     * @param price of tool
     * @param sup supplier of tool
     */
    public Tool (int id, String powertype, String name, int quantity, double price, int sup){

        setToolId(id);
        setType(powertype);
        setToolName(name);
        setToolQuant(quantity);
        setToolPrice(price);
        setSupplierId(sup);
        setAlreadyOrdered(false);
        
    }
    /**
     * Decreases Tool quantity if quantity is positive
     * @return true or false
     */
    public boolean decreaseToolQuant(){
        if(ToolQuant>0){
            ToolQuant--;
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Creates order line for Tool
     * @return orderline
     */
    public OrderLine generateOrderLine(){
        OrderLine ol;
        //If quantity drops below 40 and hasnt been ordered
        if(getToolQuant()<40 && alreadyOrdered ==false){
            //Create orderline with 20 of this Tool
            ol = new OrderLine(this, 20);
            alreadyOrdered = true;
            return ol;
        }
        return null;
    }
    /**
     * ToString method for formatting Tool 
     */
    @Override
    public String toString(){
        String s = "ToolID:"+getToolId()+", "+ getToolName()+", Quantity:"+getToolQuant()+", Price:"+getToolPrice()+ ", Type:"+getType()+", Supplier:"+getSupplierId()+"\n";
        //Optional addition of supplier info for Tool format
        //+", SupplierInfo:["+getToolSupplier()+"]\n";
        return s;
    }

    /**
     * @return int return the ToolId
     */
    public int getToolId() {
        return ToolId;
    }

    /**
     * @param ToolId the ToolId to set
     */
    public void setToolId(int ToolId) {
        this.ToolId = ToolId;
    }

    /**
     * @return double return the ToolPrice
     */
    public double getToolPrice() {
        return ToolPrice;
    }

    /**
     * @param ToolPrice the ToolPrice to set
     */
    public void setToolPrice(double ToolPrice) {
        this.ToolPrice = ToolPrice;
    }

    /**
     * @return int return the ToolQuant
     */
    public int getToolQuant() {
        return ToolQuant;
    }

    /**
     * @param ToolQuant the ToolQuant to set
     */
    public void setToolQuant(int ToolQuant) {
        this.ToolQuant = ToolQuant;
    }

    /**
     * @return String return the ToolName
     */
    public String getToolName() {
        return ToolName;
    }

    /**
     * @param ToolName the ToolName to set
     */
    public void setToolName(String ToolName) {
        this.ToolName = ToolName;
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
