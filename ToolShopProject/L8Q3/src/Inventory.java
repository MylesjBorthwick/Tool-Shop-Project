import java.util.ArrayList;
/**
 * Inventory Class represents shop inventory. This class
 * holds Tools in inventory and handles searching for Tools 
 * as well as creating orders
 * @author Myles Borthwick
 */

public class Inventory {

   private ArrayList <Tool> ToolList;
   private Order myOrder;
    /**
     * Constructor
     * @param Tools
     */
   public Inventory(ArrayList<Tool> Tools){
       setToolList(Tools);
       myOrder = new Order();
   }
   
   /**
    * Searches for Tool by name
    * @param name
    * @return Tool
    */
   public Tool searchForToolName(String name){
        for(Tool i: ToolList){
            if(name.equals(i.getToolName())){
            return i;
            }
        }
        return null;
    }
    /**
     * Searches for Tool by ID
     * @param id
     * @return Tool
     */
    public Tool searchForToolId(int id){
        for(Tool i: ToolList){
            if(id == i.getToolId()){
            return i;
            }
        }
        return null;
    }
    /**
     * Add orderline to Order
     * @param myTool
     */
    public void placeOrder(Tool myTool){
        OrderLine ol = myTool.generateOrderLine();
        if(ol!=null){
            myOrder.addOrderLine(ol);
        }
    }
    /**
     * Manages Tools (decrease and order placement)
     * @param name
     * @return Tool
     */
    public Tool manageTool(String name){
        Tool myTool = decreaseTool(name);

        if(myTool!=null){
            placeOrder(myTool);
        }
        
        return myTool;
    }
    /**
     * Decreases Tool quantity
     * @param name
     * @return decreased Tool
     */
    private Tool decreaseTool(String name){
        //Search for Tool
        Tool myTool = searchForToolName(name);

        if(myTool==null){
            return null;
        }
        //If Tool exists and can be decreased. Call decease 
        //function in Tool and return
        if(myTool.decreaseToolQuant()==true){
            return myTool;
        }

        return null;
    }

    @Override
    /**
     * Format inventory into string
     */
    public String toString(){
       String s = "";
       for(Tool i : ToolList){
           s+=i;
           s+="\n";
       }
       return s;
   }
    
    /**
     * @return ArrayList<Tool> return the ToolList
     */
    public ArrayList<Tool> getToolList() {
        return ToolList;
    }

    /**
     * @param ToolList the ToolList to set
     */
    public void setToolList(ArrayList<Tool> ToolList) {
        this.ToolList = ToolList;
    }

    /**
     * @return Order return the myOrder
     */
    public Order getMyOrder() {
        return myOrder;
    }

    /**
     * @param myOrder the myOrder to set
     */
    public void setMyOrder(Order myOrder) {
        this.myOrder = myOrder;
    }

}
