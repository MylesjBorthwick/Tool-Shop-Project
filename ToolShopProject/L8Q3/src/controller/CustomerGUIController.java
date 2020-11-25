package controller;

import java.awt.event.ActionEvent;
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
                    custModel.setQuery(5);
                }

                else if(searchType == "clientId"){
                    custModel.setClientId(Integer.parseInt(searchParam));
                    custModel.setQuery(4);
                }

                else if(searchType == "clientType"){
                    custModel.setClientType(searchParam);
                    custModel.setQuery(6);
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
