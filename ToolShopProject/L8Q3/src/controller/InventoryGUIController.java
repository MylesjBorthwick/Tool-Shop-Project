package controller;

import java.awt.event.ActionEvent;

import server.ClientSocket;
import view.CustomerGUI;
import view.InventoryGUI;


public class InventoryGUIController {
    
    private InventoryGUI gui;
    private InventoryModel invModel;
    private ClientSocket socket;



    public InventoryGUIController(InventoryGUI g, InventoryModel i, ClientSocket s){
        socket = s;
        setGui(g);
        setModel(i);


        gui.addSwitchListener((ActionEvent e)->{
            gui.dispose();
            CustomerGUIController cust = new CustomerGUIController(new CustomerGUI(), new CustomerModel(),socket);
        });

        gui.addExecuteListener((ActionEvent e)->{

            String executeType = "";
            String executeParam = "";

            try{
                executeType = gui.getExecuteType();
                executeParam = gui.getExecuteParam();

                if(executeType == "toolName"){
                    invModel.setToolName(executeParam);
                    invModel.setQueryId(2);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }

                else if(executeType == "toolId"){
                    invModel.setId(Integer.parseInt(executeParam));
                    invModel.setQueryId(3);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }

                else if(executeType == "checkQuant"){
                    invModel.setToolName(executeParam);
                    invModel.setQueryId(4);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }

                else if(executeType == "decreaseQuant"){
                    invModel.setToolName(executeParam);
                    invModel.setQueryId(5);
                    invModel = (InventoryModel)socket.pipelineRequest(invModel);
                }

                if(invModel.isAnswered() == true){
                    gui.setTextField(invModel.getResponse());
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

        gui.addListListener((ActionEvent e)->{
            invModel.setQueryId(1);
            invModel = (InventoryModel)socket.pipelineRequest(invModel);
            gui.setTextField(invModel.getResponse());
        });

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
