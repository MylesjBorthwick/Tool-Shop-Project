package model;
import java.util.ArrayList;
/**
 * Supplier List Class
 * Holds shop suppliers and can set/print list
 * @author Myles Borthwick
 * @version 1.0
 */
public class SupplierList {

    private ArrayList<Supplier> supplierList;
    /**
     * Constructor
     * @param suppliers
     */
    public SupplierList(ArrayList<Supplier> suppliers){
        setSupplierList(suppliers);
    }

    /**
     * Print supplier list
     */
    public void printList(){
        for(Supplier sup:supplierList){
            System.out.println(sup);
        }
    }
    /**
     * @return ArrayList<Supplier> return the supplierList
     */
    public ArrayList<Supplier> getSupplierList() {
        return supplierList;
    }

    /**
     * @param supplierList the supplierList to set
     */
    public void setSupplierList(ArrayList<Supplier> supplierList) {
        this.supplierList = supplierList;
    }

}
