package controller;

/**
 * Inventory GUI Controller handles Action Events
 * and communication between the Inventory GUI and the backend.
 * @author Ken Loughery
 * @author MylesBorthwick
 * @since Novemeber 2020
 */

import java.awt.event.ActionEvent;
import server.ClientSocket;
import view.CustomerGUI;
import view.InventoryGUI;


public class InventoryGUIController {
    
    //Instance variables
    private InventoryGUI gui;
    private InventoryModel invModel;
    private ClientSocket socket;


    /**
     * Controller Constructor
     * @param g Gui being interacted with
     * @param i Model
     * @param s Client socket
     */
    public InventoryGUIController(InventoryGUI g, InventoryModel i, ClientSocket s){
        //Set variables
        socket = s;
        setGui(g);
        setModel(i);

        //Switch event for switch button
        gui.addSwitchListener((ActionEvent e)->{
            //Close current window
            gui.dispose();
            //Create customer controller with new model and gui
            CustomerGUIController cust = new CustomerGUIController(new CustomerGUI(), new CustomerModel(),socket);
        });

        //Execute event
        gui.addExecuteListener((ActionEvent e)->{

            //Initialize type and param
            String executeType = "";
            String executeParam = "";

            try{
                //Set type and param to input
                executeType = gui.getExecuteType();
                executeParam = gui.getExecuteParam();
                
                //Check Execute Type
                //For ToolName Search
                if(executeType == "toolName"){
                    invModel.setToolName(executeParam);
                    //Set query in model
                    invModel.setQueryId(2);
                    //Set Model to backend
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }
                //For ToolId Search
                else if(executeType == "toolId"){
                    invModel.setId(Integer.parseInt(executeParam));
                    invModel.setQueryId(3);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }

                //For Quantity Check Search
                else if(executeType == "checkQuant"){
                    invModel.setToolName(executeParam);
                    invModel.setQueryId(4);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }

                //For decrease Quantity
                else if(executeType == "decreaseQuant"){
                    invModel.setToolName(executeParam);
                    invModel.setQueryId(5);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }
                //If Query is Answered
                if(invModel.isAnswered() == true){
                    //Show response
                    gui.setTextField(invModel.getResponse());
                }
                
                else{
                    //Show no results found
                    gui.displayMessage("No Results Found");
                }
                
            }
            //Error message for improper type input
            catch(Exception er){
                gui.displayMessage("Execution Error"+
                "\nPlease make sure the execute command matches action type.");
            }

        });

        //Clear Button Event
        gui.addClearListener((ActionEvent e)->{
            //Set Textbox to empty
            gui.setTextField("");
        });
        //Add action event for list all button
        gui.addListListener((ActionEvent e)->{
            invModel.setQueryId(1);
            invModel = (InventoryModel)socket.pipelineRequest(invModel);
            gui.setTextField(invModel.getResponse());
        });

        //Add action event for Order Button
        gui.addOrderListener((ActionEvent e)->{
            invModel.setQueryId(6);
            invModel = (InventoryModel)socket.pipelineRequest(invModel);
            gui.setTextField(invModel.getResponse());
        });
    }


    /**
     * @return InventoryGUI return the gui
     */
    public InventoryGUI getGui() {
        return gui;
    }

    /**
     * @param gui the gui to set
     */
    public void setGui(InventoryGUI gui) {
        this.gui = gui;
    }

    /**
     * @return InventoryModel return the model
     */
    public InventoryModel getModel() {
        return invModel;
    }

    /**
     * @param model the model to set
     */
    public void setModel(InventoryModel model) {
        this.invModel = model;
    }

}
