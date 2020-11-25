package controller;
import java.io.Serializable;

/**
 *   
 *
 */
public class CustomerModel implements Serializable
	{

		private static final long serialVersionUID = 1L;
		private int queryId = 0;
		private String response = null;
		private boolean answered = false;
		private String firstName = null;
		private String lastName = null;
		private String address = null;
		private String postalCode = null;
		private int clientId;
		private String phoneNumber = null;
		private boolean clientType; //positive is C
		
		/**
         * A default constructor that builds a record with blank data
         */
		public CustomerModel(int queryId, String firstName, String lastName, String address, String postalCode, int clientId, int phoneNumber, boolean clientType) {
			this.queryId = queryId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.address = address;
			this.postalCode = postalCode;
			this.clientId = clientId;
			this.phoneNumber = phoneNumber;
			this.clientType = clientType;
		} 
	  
        /**
         * A default constructor that builds a record with blank data
         */
		public CustomerModel(int queryId) {
			this.queryId = queryId;
		} 

		
	
    /**
     * @return String return the query
     */
    public int getQueryId() {
        return queryId;
    }

    /**
     * @param query the query to set
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
     * @param response the response to set
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
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return String return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return boolean return the clientType
     */
    public boolean isClientType() {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(boolean clientType) {
        this.clientType = clientType;
    }

}
