package controller;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import view.CustomerGUI;


public class CustomerGUIController {
    
    private CustomerGUI gui;
    private CustomerModel custModel;



    public CustomerGUIController(CustomerGUI g, CustomerModel i){
        
        setGui(g);
        setModel(i);

        gui.addSearchListener((ActionEvent e)->{

            String searchType = "";
            String searchParam = "";

            try{
                searchType = gui.getSearchType();
                searchParam = gui.getSearchParam();

                if(searchType == "lastName"){
                    custModel.setLastName(searchParam);
                    custModel.setQueryId(5);
                }

                else if(searchType == "clientId"){
                    custModel.setClientId(Integer.parseInt(searchParam));
                    custModel.setQueryId(4);
                }

                else if(searchType == "clientType"){
                    custModel.setClientType(searchParam);
                    custModel.setQueryId(6);
                }

                if(custModel.isAnswered() == true){
                    gui.setTextField(custModel.getResponse());
                }
                
                else{
                    gui.displayErrorMessage("No Results Found");
                }
                
            }
            catch(Exception er){
                gui.displayErrorMessage("Execution Error"+
                "\nPlease make sure the execute command matches action type.");
            }

        });

        gui.addClearListener((ActionEvent e)->{
            gui.setTextField("");
        });

        gui.addSaveListener((ActionEvent e)->{
            if(gui.getClientIdField().isBlank()){
                gui.displayErrorMessage("Cannot Add"+"\nNeed ClientID Field");
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
                    if(verifyAddNew()){
                        custModel.setClientId(clientId);
                        custModel.setFirstName(firstName);
                        custModel.setLastName(lastName);
                        custModel.setPostalCode(postal);
                        custModel.setAddress(addy);
                        custModel.setClientType(type);
                        custModel.setPhoneNumber(phone);
                        custModel.setQueryId(1);

                    }
                    if(custModel.isAnswered() == true){
                        gui.displayErrorMessage("Client Saved!");
                    }
                    else{
                        gui.displayErrorMessage("Client Not Saved!");
                    }
                }
                catch(Exception er){
                    gui.displayErrorMessage("Cannot Add Client"+
                    "\nPlease Make Sure All Fields Are of Proper Type");
                }
            }
            
        });


    }


    private boolean verifyAddNew()
    {
        // Ask user if they really want to add new user
        int action = JOptionPane.showConfirmDialog(null, 
        "Do you want to add a new client? A new client ID will be generated.", 
        "Confirm New Client", 
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
