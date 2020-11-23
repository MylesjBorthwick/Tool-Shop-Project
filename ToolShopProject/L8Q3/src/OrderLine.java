/**
 * Class representing an ordeline for an object
 * @author Myles Borthwick
 * @version 1.0
 */
public class OrderLine {
    //Member variables
    private int orderQuant;
    //Tool object to be included in order
    private Tool orderTool;
    
    /**
     * Constructor
     * @param orderedTool
     * @param orderQuantity
     */
    public OrderLine(Tool orderedTool, int orderQuantity){
        setOrderTool(orderedTool);
        setOrderQuant(orderQuantity);

    }
    /**
     * To string to print orderline with formatting
     */
    @Override
    public String toString(){
        String s="\nTool description:    "+ orderTool.getToolName()+"\n"
                +"Amount Ordered:      "+ getOrderQuant()+"\n"
                +"Supplier:            "+ orderTool.getSupplierId()+"\n"
                +"--------------------------------------------------------";
        return s;
    }

    /**
     * @return int return the orderQuant
     */
    public int getOrderQuant() {
        return orderQuant;
    }

    /**
     * @param orderQuant the orderQuant to set
     */
    public void setOrderQuant(int orderQuant) {
        this.orderQuant = orderQuant;
    }

    /**
     * @return Tool return the orderTool
     */
    public Tool getOrderTool() {
        return orderTool;
    }

    /**
     * @param orderTool the orderTool to set
     */
    public void setOrderTool(Tool orderTool) {
        this.orderTool = orderTool;
    }

}
