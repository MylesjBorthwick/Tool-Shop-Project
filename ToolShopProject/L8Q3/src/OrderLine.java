/**
 * Class representing an ordeline for an object
 * @author Myles Borthwick
 * @version 1.0
 */
public class OrderLine {
    //Member variables
    private int orderQuant;
    //Item object to be included in order
    private Tool orderItem;
    
    /**
     * Constructor
     * @param orderedItem
     * @param orderQuantity
     */
    public OrderLine(Tool orderedItem, int orderQuantity){
        setOrderItem(orderedItem);
        setOrderQuant(orderQuantity);

    }
    /**
     * To string to print orderline with formatting
     */
    @Override
    public String toString(){
        String s="\nItem description:    "+ orderItem.getItemName()+"\n"
                +"Amount Ordered:      "+ getOrderQuant()+"\n"
                +"Supplier:            "+ orderItem.getSupplierId()+"\n"
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
     * @return Item return the orderItem
     */
    public Tool getOrderItem() {
        return orderItem;
    }

    /**
     * @param orderItem the orderItem to set
     */
    public void setOrderItem(Tool orderItem) {
        this.orderItem = orderItem;
    }

}
