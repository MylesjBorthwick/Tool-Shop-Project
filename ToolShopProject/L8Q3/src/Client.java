import java.util.regex.Pattern;

import javax.swing.JOptionPane;


public class Client
{
    
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String postalCode;
    private String phoneNumber;
    private String clientType;

    public Client(  int id, String firstName, String lastName, String address, 
                    String postalCode, String phoneNumber, String clientType)
    {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setPostalCode(postalCode);
        setPhoneNumber(phoneNumber);
        setClientType(clientType);
    }


    public int getId() 
    {
        return id;
    }

    public String getStringId()
    {
        return Integer.toString(id);
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getFirstName() 
    {
        return firstName;
    }

    public boolean setFirstName(String firstName) 
    {
        // Check first name format
        if (firstName.length() > 0 && firstName.length() <= 20)
        {
            // Set first name
            this.firstName = firstName;
            return true;
        }
        // If wrong format, prompt user
        JOptionPane.showMessageDialog(null, "Invalid first name format. Expected: 1-20 char length");
        return false;
    }

    public String getLastName() 
    {
        return lastName;
    }

    public boolean setLastName(String lastName)
    {
        // Check last name format
        if (lastName.length() > 0 && lastName.length() <= 20)
        {
            // Set last name
            this.lastName = lastName;
            return true;
        }
        // If wrong format, prompt user
        JOptionPane.showMessageDialog(null, "Invalid last name format. Expected: 1-20 char length");
        return false;
    }

    public String getAddress() 
    {
        return address;
    }

    public boolean setAddress(String address) 
    {
        // Check address format
        if (address.length() > 0 && address.length() <= 50)
        {
            // Set address
            this.address = address;
            return true;
        }
        // If wrong format, prompt user
        JOptionPane.showMessageDialog(null, "Invalid address format. Expected: 1-50 char length");
        return false;
    }

    public String getPostalCode() 
    {
        return postalCode;
    }

    public boolean setPostalCode(String postalCode) 
    {
        // Check postal code format
        if (Pattern.matches("^[A-Z]\\d[A-Z]\\s\\d[A-Z]\\d", postalCode))
        {
            // Convert letters to uppercase
            postalCode = postalCode.toUpperCase();
            // Set postalCode
            this.postalCode = postalCode;
            return true;
        }
        // If wrong format, prompt user
        JOptionPane.showMessageDialog(null, "Invalid postal code format. Expected: A1A 1A1");
        return false;
    }

    public String getPhoneNumber() 
    {
        return phoneNumber;
    }

    public boolean setPhoneNumber(String phoneNumber) 
    {
        // Check phone number format
        if (Pattern.matches("^\\d{3}[-]\\d{3}[-]\\d{4}", phoneNumber))
        {
            // Set phone number
            this.phoneNumber = phoneNumber;
            return true;
        }
        // If wrong format, prompt user
        JOptionPane.showMessageDialog(null, "Invalid phone number format. Expected: 111-111-1111");
        return false;
    }

    public String getClientType() 
    {
        return clientType;
    }


    public boolean setClientType(String clientType) 
    {
        // Check client type format
        if (clientType.equals("R") || clientType.equals("C"))
        {
            // Set client type
            this.clientType = clientType;
            return true;
        }
        // If wrong format, prompt user
        JOptionPane.showMessageDialog(null, "Invalid client type. Expected: Residential or Commercial");
        return false;
        
    }

    public String toString()
    {
        return id + " " + firstName + " " + lastName + " " + clientType;
    }

    



}