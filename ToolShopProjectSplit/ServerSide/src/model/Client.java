package model;
/**
 * Client Class, Represents clients in database. This class includes a constructor + getters
 * setters, and toString
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov 2020
 */
public class Client{
    
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private String clientType;

    /**
     * COnstructor, sets client info
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param postalCode
     * @param phoneNumber
     * @param clientType
     */
    public Client(int id, String firstName, String lastName, String address, 
                    String postalCode, String phoneNumber, String clientType){
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPostalCode(postalCode);
        setPhoneNumber(phoneNumber);
        setClientType(clientType);
    }

    
    /**
     * Getters and Setters for Client
     */

    public int getId() {
        return id;
    }

    public String getStringId(){
        return Integer.toString(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        // Set Client first name
        this.firstName = firstName;
      
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        // Set Client last name
        this.lastName = lastName;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        // Set Client address
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        // Set client postalCode
        this.postalCode = postalCode;
    
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) {
        // Set client phone number
        this.phoneNumber = phoneNumber;
        return true;
      
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        // Set client type
        this.clientType = clientType;
    }
    /**
     * ToString for Client Object
     */
    public String toString(){
        return id + "; " + firstName + "; " + lastName + "; " + address + "; "+ postalCode + "; " + phoneNumber + "; " + clientType+"\n";
    }


}