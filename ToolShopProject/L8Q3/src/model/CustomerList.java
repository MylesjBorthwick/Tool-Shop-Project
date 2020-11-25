package model;
import java.util.ArrayList;
/**
 * @author Myles Borthwick
 * @version 1.0
 */

public class CustomerList {

    private ArrayList<Client> customerList;
    /**
     * Constructor
     * @param suppliers
     */
    public CustomerList(ArrayList<Client> clients){
        setCustomerList(clients);
    }

    /**
     * Print supplier list
     */
    public String printList(){
        String s = "";
        for(Client sup:customerList){
            s+= sup;
            s += "\n";
        }
        return s;
    }

    /**
     * @return ArrayList<Supplier> return the supplierList
     */
    public ArrayList<Client> getCustomerList() {
        return customerList;
    }

    /**
     * @param supplierList the supplierList to set
     */
    public void setCustomerList(ArrayList<Client> customerList) {
        this.customerList = customerList;
    }

    public Client findClient(int id){
        for (Client temp: customerList){
            if(temp.getId() == id){
                return temp;
            }
        }
        return null;
    }


	public String addCustomer(int clientId, String firstName, String lastName, String address, String postalCode,
			String phoneNumber, String clientType) {
                /////asdf//asdfkljaskldjflkadsjfkjadslfkjadslkfjadlskjfdjsfdjslfjsadljflasdjfkjasdlfjadklsjfadsjkfjadslfjlajsfdjaflsdjf
                customerList.add(new Client(clientId,firstName,lastName,address,postalCode,phoneNumber,clientType));

	}

}
