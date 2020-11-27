package controller;
import java.io.Serializable;

/**
 * This class is the model that will store the information for the queries that will be sent from the frontend to the backend
 * for the customer Model. Query id is set to get the response from the backend, and is encoded as follows:
 * 1: add a new client
 * 2: update a client by id (null fields are ignored)
 * 3: remove a client by id
 * 4: display client information by id
 * 5: display client information by last name
 * 6: display client information by client type
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */

public class CustomerModel implements Serializable
	{

    private static final long serialVersionUID = 1L;
    private int queryId;
    private String response;
    private boolean answered;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private int clientId;
    private String phoneNumber;
    private String clientType; 
    

    /**
     * default constructor that sets all the fields to default configurations
     */
    public CustomerModel(){
        queryId = 0;
        response = null;
        answered = false;
        firstName = null;
        lastName = null;
        address = null;
        postalCode = null;
        clientId = -1;
        phoneNumber = null;
        clientType = null; 
    }

		
	
    /**
     * @return String return the query
     */
    public int getQueryId() {
        return queryId;
    }

    /**
     * @param query the query to set, setting the query sets the answered attribute to false
     */
    public void setQueryId(int queryId) {
		this.queryId = queryId;
		this.answered = false;
    }

    /**
     * @return String return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set, setting the response sets the answered attribute to true
     */
    public void setResponse(String response) {
		this.response = response;
		this.answered = true;
    }

    /**
     * @return boolean return the answered
     */
    public boolean isAnswered() {
        return answered;
    }

    /**
     * @param answered the answered to set
     */
    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name, if a blank or empty string is passed, sets to null
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        if(firstName.equals("") || firstName.equals(" ")){
            firstName= null;
        }else{
            this.firstName = firstName;
        }
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the first name, if a blank or empty string is passed, sets to null
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        if(lastName.equals("") || lastName.equals(" ")){
            this.lastName= null;
        }else{
            this.lastName = lastName;
        }
    }

    /**
     * @return String return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the first name, if a blank or empty string is passed, sets to null
     * @param address the address to set
     */
    public void setAddress(String address) {
        if(address.equals("") || address.equals(" ")){
            this.address= null;
        }else{
            this.address = address;
        }
    }

    /**
     * @return String return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * sets the first name, if a blank or empty string is passed, sets to null
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        if(postalCode.equals("") || postalCode.equals(" ")){
            this.postalCode= null;
        }else{
            this.postalCode = postalCode;
        }
    }

    /**
     * @return int return the clientId
     */
    public int getClientId() {
        return clientId;
    }

    /**
     * @param clientId the clientId to set
     */
    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    /**
     * @return int return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * sets the first name, if a blank or empty string is passed, sets to null
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.equals("") || phoneNumber.equals(" ")){
            this.phoneNumber= null;
        }else{
            this.phoneNumber = phoneNumber;
        }
    }

    /**
     * @return boolean return the clientType
     */
    public String isClientType() {
        return clientType;
    }

    /**
     * sets the first name, if a blank or empty string is passed, sets to null
     * @param clientType the clientType to set
     */
    public void setClientType(String clientType) {
        if(clientType.equals("") || clientType.equals(" ")){
            this.clientType= null;
        }else{
            this.clientType = clientType;
        }
    }

}
