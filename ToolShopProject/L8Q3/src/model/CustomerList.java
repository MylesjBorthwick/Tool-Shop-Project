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
    public synchronized String printList(){
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
    public synchronized void setCustomerList(ArrayList<Client> customerList) {
        this.customerList = customerList;
    }

    private synchronized Client findClient(int id){
        for (Client temp: customerList){
            if(temp.getId() == id){
                return temp;
            }
        }
        return null;
    }

    public synchronized String findClientId(int id){
        Client foundClient = findClient(id);
        if(foundClient==null){
            return "Client was not found.\n"+id+" does not exists as a client id in the database.\n";
        }       
        return foundClient.toString()+ "\n";
    }

    public synchronized String findClientName(String lastName){
        String s = "";
        for (Client temp: customerList){
            if(temp.getLastName().equals(lastName)){
                s += temp+ "\n";
            }
        }
        if(s.length()>1){return s;}
        return "No clients named "+lastName+ " were found in the database";
    }

    public synchronized String findClientType(String clientType){       
        String s = "";
        for (Client temp: customerList){
            if(temp.getClientType().equals(clientType)){
                s += temp+ "\n";
            }
        }
        if(s.length()>1){return s;}
        return "No clients of type "+clientType+ " was found in the database";
    }  

	public synchronized String addCustomer(int clientId, String firstName, String lastName, String address, String postalCode,
			String phoneNumber, String clientType) {
                if(findClient(clientId)!= null){
                    return firstName+ " was not added as a new client.\n"+clientId+" already exists as a client id in the database.\n";
                }
                customerList.add(new Client(clientId,firstName,lastName,address,postalCode,phoneNumber,clientType));
                return firstName+ " was successfully added as a new client.\n";
    }

	public synchronized String removeCustomer(int clientId) {
        Client deleteClient = findClient(clientId);
        if(deleteClient== null){
            return "Could not delete client.\n"+clientId+" does not exist as a client id in the database.\n";
        }
        customerList.remove(deleteClient);
        return deleteClient.getFirstName()+ " was successfully removed from the list of clients.\n";
	}

	public synchronized String updateCustomer(int clientId, String firstName, String lastName, String address, String postalCode,
			String phoneNumber, String clientType) {
                Client foundClient = findClient(clientId);
                if(foundClient== null){
                    return "Client was not updated.\n"+clientId+" does not exist as a client id in the database.\n";
                }
                if(firstName!= null){
                    foundClient.setFirstName(firstName);
                }
                if(lastName != null){
                    foundClient.setLastName(lastName);
                }
                if(address!=null){
                    foundClient.setAddress(address);
                }
                if(postalCode != null){
                    foundClient.setPostalCode(postalCode);
                }
                if(phoneNumber!= null){
                    foundClient.setPhoneNumber(phoneNumber);
                }
                if(clientType!= null){
                    foundClient.setClientType(clientType);
                }
                return foundClient.getFirstName()+ " was successfully updated with new client information.\n";       
	}

}
