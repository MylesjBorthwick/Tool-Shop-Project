import java.util.ArrayList;
/**
 * Supplier class holds supplier information
 * @author Myles Borthwick
 * @version 1.0
 */
public class Supplier {
    //Member variables (supplier info)
    private int supplierId;
    private String companyName;
    private String address;
    private String contact;
    private ArrayList<Tool> itemList;

    /**
     * Supplier Constructor
     * @param id of supplier
     * @param comp company name
     * @param addy address
     * @param c contact name
     */
    public Supplier(int id, String comp, String addy, String c){
        
        setAddress(addy);
        setCompanyName(comp);
        setContact(c);
        setSupplierId(id);
        setItemList(new ArrayList<Tool>());

    }
    /**
     * ToString for formatting supplier object into string
     */
    @Override
    public String toString(){
        String s = "ID:"+getSupplierId()+", Company:"+getCompanyName()+", Address:("+getAddress()+"), Contact:"+getContact();
        return s;
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

    /**
     * @return String return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return String return the contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(String contact) {
        this.contact = contact;
    }


    /**
     * @return ArrayList<Item> return the itemList
     */
    public ArrayList<Tool> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(ArrayList<Tool> itemList) {
        this.itemList = itemList;
    }

}