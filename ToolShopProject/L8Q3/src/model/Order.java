package model;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
/**
 * Class for Order object. Initializes order with an order id and time
 * Can add orderlines to its orders
 * @author Myles Borthwick
 * @version 1.0
 */
public class Order {
    //Member Variables
    private int orderId;
    private String orderDate;
    
    private ArrayList<OrderLine> orders;
    /**
     * Order Constructor
     */
    public Order(){
        setOrders(new ArrayList<OrderLine>());
     
    }

    /**
     * Adds orderline to orderlist
     * @param o orderline
     */
    public void addOrderLine(OrderLine o){
        if(o!=null){
            orders.add(o);
        }
    }
    /**
     * Grabs local date from machine
     * @return current date
     */
    public static LocalDate getLocalDate(){
        return LocalDate.now();
    }
    /**
     * Formatts order header and ordelines to print order
     */
    public String toString(){
        //Creates random id
        Random rnd = new Random();
        int id = 10000 + rnd.nextInt(90000);
        //Header
        String s = "Order ID:            "+ id +"\n"
                +"Date Ordered:        "+ getLocalDate()+"\n"
                +"**********************************";
        //Ordelines
        for(OrderLine o : orders){
            s+=o;
        }
        return s;
    }

    /**
     * @return ArrayList<OrderLine> return the orders
     */
    public ArrayList<OrderLine> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(ArrayList<OrderLine> orders) {
        this.orders = orders;
    }


    /**
     * @return int return the orderId
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }


    /**
     * @return String return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

}
