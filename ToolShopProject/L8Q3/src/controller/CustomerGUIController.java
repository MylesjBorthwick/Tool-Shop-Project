package controller;

/**
 * Customer GUI Controller handles Action Events
 * and communication between the Customer GUI and the backend.
 * @author Ken Loughery
 * @author MylesBorthwick
 * @since Novemeber 2020
 */

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import server.ClientSocket;
import view.CustomerGUI;
import view.InventoryGUI;


public class CustomerGUIController {
    
    //Instance variables
    private CustomerGUI gui;
    private CustomerModel custModel;
    private ClientSocket socket;

    /**
     * Controller Constructor
     * @param g Gui being interacted with
     * @param i Model
     * @param s Client socket
     */
    public CustomerGUIController(CustomerGUI g, CustomerModel i, ClientSocket s){
        //Set variables
        socket = s;
        setGui(g);
        setModel(i);
        //Search event
        gui.addSearchListener((ActionEvent e)->{
            //Initialize type and param
            String searchType = "";
            String searchParam = "";

            try{
                //Set type and param to input
                searchType = gui.getSearchType();
                searchParam = gui.getSearchParam();

                 //Check Search Type
                //For Lastname Search
                if(searchType == "lastName"){
                    custModel.setLastName(searchParam);
                    //Set query in model
                    custModel.setQueryId(5);
                    custModel = (CustomerModel)socket.pipelineRequest(custModel);
                }
                //For CLient ID search
                else if(searchType == "clientId"){
                    custModel.setClientId(Integer.parseInt(searchParam));
                    custModel.setQueryId(4);
                    custModel = (CustomerModel)socket.pipelineRequest(custModel);
                }
                //For CLient Type Search
                else if(searchType == "clientType"){
                    custModel.setClientType(searchParam);
                    custModel.setQueryId(6);
                    custModel = (CustomerModel)socket.pipelineRequest(custModel);
                    
                }
                //If query answered
                if(custModel.isAnswered() == true){
                    gui.setTextField(custModel.getResponse());
                }
                
                else{
                    //Not found
                    gui.displayMessage("No Results Found");
                }
                
            }
            //Input error
            catch(Exception er){
                gui.displayMessage("Execution Error"+
                "\nPlease Make Sure the Execute Command Matches Action Type");
            }

        });
        //Switch button event
        gui.addSwitchListener((ActionEvent e)->{
            gui.dispose();
            InventoryGUIController inventory = new InventoryGUIController(new InventoryGUI(), new InventoryModel(), socket);

        });
        //Clear Button event
        gui.addClearListener((ActionEvent e)->{
            gui.setTextField("");
        });
        //Save button event
        gui.addSaveListener((ActionEvent e)->{
            if(gui.getClientIdField().isBlank()){
                gui.displayMessage("Cannot Add"+"\nNeed ClientID Field");
            }
            else{
                try{
                    //Get Fields
                    int clientId = Integer.parseInt(gui.getClientIdField());
                    String firstName = gui.getClientFirstNameField();
                    String lastName = gui.getLastNameField();
                    String postal = gui.getPostalField();
                    String addy = gui.getAddressField();
                    String phone = gui.getPhoneNumberField();
                    String type = gui.getClientType();
                    //Get confirmation
                    if(verifyAddNew()){
                        //Set model to input
                        custModel.setClientId(clientId);
                        custModel.setFirstName(firstName);
                        custModel.setLastName(lastName);
                        custModel.setPostalCode(postal);
                        custModel.setAddress(addy);
                        custModel.setClientType(type);
                        custModel.setPhoneNumber(phone);
                        custModel.setQueryId(1);
                        custModel = (CustomerModel)socket.pipelineRequest(custModel);
                        gui.displayMessage(custModel.getResponse());
                        

                    }
                    
                }
                //Input error
                catch(Exception er){
                    gui.displayMessage("Cannot Add Client"+
                    "\nPlease Make Sure All Fields Are of Proper Type");
                }
            }
            
        });

        //Delete button event
        gui.addDeleteListener((ActionEvent e)->{
            //Check for blank field
            if(gui.getClientIdField().isBlank()){
                gui.displayMessage("Cannot Delete"+"\nNeed ClientID Field");
            }
            else{
                try{
                    int clientId = Integer.parseInt(gui.getClientIdField());
                    if(verifyDelete()){
                        custModel.setClientId(clientId);
                        custModel.setQueryId(3);
                        custModel = (CustomerModel)socket.pipelineRequest(custModel);
                        gui.displayMessage(custModel.getResponse());

                    }
                }
                catch(Exception er){
                    gui.displayMessage("Cannot Delete Client"+
                    "\nPlease Make Sure All Fields Are of Proper Type");
                }
            }
        });

        //Add update button event
        gui.addUpdateListener((ActionEvent e)->{
            if(gui.getClientIdField().isBlank()){
                gui.displayMessage("Cannot Update"+"\nNeed ClientID Field");
            }
            else{
                try{
                    int clientId = Integer.parseInt(gui.getClientIdField());
                    String firstName = gui.getClientFirstNameField();
                    String lastName = gui.getLastNameField();
                    String postal = gui.getPostalField();
                    String addy = gui.getAddressField();
                    String phone = gui.getPhoneNumberField();
                    String type = gui.getClientType();
                    if(verifyUpdate()){
                        custModel.setClientId(clientId);
                        custModel.setQueryId(2);
                        custModel.setClientId(clientId);
                        custModel.setFirstName(firstName);
                        custModel.setLastName(lastName);
                        custModel.setPostalCode(postal);
                        custModel.setAddress(addy);
                        custModel.setClientType(type);
                        custModel.setPhoneNumber(phone);
                        custModel = (CustomerModel)socket.pipelineRequest(custModel);
                        gui.displayMessage(custModel.getResponse());

                    }
                   
                }
                catch(Exception er){
                    gui.displayMessage("Cannot Update Client"+
                    "\nPlease Make Sure All Fields Are of Proper Type");
                }
                
            }
        });
        //Clear info action
        gui.addClearInfoListener((ActionEvent e)->{
            gui.setClientIdField("");
            gui.setClientFirstNameField("");
            gui.setLastNameField("");
            gui.setPostalField("");
            gui.setAddressField("");
            gui.setPhoneNumberField("");
        });

    }

    /**
     * Confirmation window for add
     * @return t/f
     */
    private boolean verifyAddNew()
    {
        //Ask For user confirmation
        int action = JOptionPane.showConfirmDialog(null,  
        "Confirm New Client?"+"\nAll Empty Fields Will be Set as NULL",
        "Confirm Add", 
        JOptionPane.OK_CANCEL_OPTION);
        if (action == JOptionPane.OK_OPTION)
        {
            return true;
        }
        return false;
    }
   
    /**
     * Confirmation Window for update
     * @return t/f
     */
    private boolean verifyUpdate()
    {
        // Ask for user confirmation
        int action = JOptionPane.showConfirmDialog(null, 
        "Do You Want to Update This Client? ", 
        "Update Confirmation", 
        JOptionPane.OK_CANCEL_OPTION);
        // Return true if user confirms
        if (action == JOptionPane.OK_OPTION)
        {
            return true;
        }
        return false;
    }

    /**
     * Confirmation Window for delete
     * @return t/f
     */
    private boolean verifyDelete()
    {
        // Ask user if they really want to add new user
        int action = JOptionPane.showConfirmDialog(null, 
        "Do you want delete this client?", 
        "Confirm Deletion", 
        JOptionPane.OK_CANCEL_OPTION);
        // Return true if user confirms
        if (action == JOptionPane.OK_OPTION)
        {
            return true;
        }
        return false;
    }


    /**
     * @return CustomerGUI return the gui
     */
    public CustomerGUI getGui() {
        return gui;
    }

    /**
     * @param gui the gui to set
     */
    public void setGui(CustomerGUI gui) {
        this.gui = gui;
    }

    /**
     * @return InventoryModel return the model
     */
    public CustomerModel getModel() {
        return custModel;
    }

    /**
     * @param model the model to set
     */
    public void setModel(CustomerModel model) {
        this.custModel = model;
    }

}
