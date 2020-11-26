package model;
import java.util.ArrayList;

/**
 * This class controls the functionality for the list of clients, including updating & adding clients, searching for client information, 
 * and returning responses.
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

public class CustomerList {

    private ArrayList<Client> customerList;

    /**
     * Constructor that sets the ArrayList of Client that methods will work on
     * @param clients an arrayList of type Client
     */
    public CustomerList(ArrayList<Client> clients){
        this.customerList = clients;
    }

    /**
     * @return a string of all the Clients in the list
     */
    public synchronized String printList(){
        String s = "";
        for(Client cust:customerList){
            s+= cust;
            s += "\n";
        }
        return s;
    }

    /**
     * Helper method that will find a client within the list by the client id
     * @param id of the client to find
     * @return Client found in the list
     */
    private synchronized Client findClient(int id){
        for (Client temp: customerList){
            if(temp.getId() == id){
                return temp;
            }
        }
        return null;
    }

    /**
     * method that returns a printout of the client information for a client found by id
     * @param id of the client to find information for
     * @return string representation of the client information
     */
    public synchronized String findClientId(int id){
        Client foundClient = findClient(id);
        if(foundClient==null){
            return "Client was not found.\n"+id+" does not exists as a client id in the database.\n";
        }       
        return foundClient.toString()+ "\n";
    }

    /**
     * method that returns a printout of the client information for all the clients with the same name
     * @param lastName of the clients to find information for
     * @return string representation of all the client's information
     */
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

    /**
     * method that returns a printout of the client information for all the clients with the type
     * @param clientType of the clients to find information for
     * @return string representation of all the client's information
     */
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

    /**
     * Create and add a new client to the list
     * @param clientId for the client to add
     * @param firstName for the client to add
     * @param lastName for the client to add
     * @param address for the client to add
     * @param postalCode for the client to add
     * @param phoneNumber for the client to add
     * @param clientType for the client to add
     * @return a string of whether the client could be added (based on if the id is unique)
     */
	public synchronized String addCustomer(int clientId, String firstName, String lastName, String address, String postalCode,
			String phoneNumber, String clientType) {
                if(findClient(clientId)!= null){
                    return firstName+ " was not added as a new client.\n"+clientId+" already exists as a client id in the database.\n";
                }
                customerList.add(new Client(clientId,firstName,lastName,address,postalCode,phoneNumber,clientType));
                return firstName+ " was successfully added as a new client.\n";
    }

    /**
     * remove a client from the list, based on their client id
     * @param clientId the id of the client to remove
     * @return a string based on whether the client could be deleted (based on if their id exists)
     */
	public synchronized String removeCustomer(int clientId) {
        Client deleteClient = findClient(clientId);
        if(deleteClient== null){
            return "Could not delete client.\n"+clientId+" does not exist as a client id in the database.\n";
        }
        customerList.remove(deleteClient);
        return deleteClient.getFirstName()+ " was successfully removed from the list of clients.\n";
	}

    /**
     * Updates a client information, based on their id. This method will search for the client and will update their fields based on
     * the inputs that are not null
     * @param clientId of the client to find
     * @param firstName to update (if not null)
     * @param lastName to update (if not null)
     * @param address to update (if not null)
     * @param postalCode to update (if not null)
     * @param phoneNumber to update (if not null)
     * @param clientType to update (if not null)
     * @return a string of whether the client was updated (based on whether the id exists)
     */
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
