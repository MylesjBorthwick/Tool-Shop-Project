package controller;

import managers.InventoryManager;
import model.Tool;
import view.InventoryGUI;


public class InventoryGUIController {
    
    private InventoryGUI gui;
    private InventoryModel model;



    public InventoryGUIController(InventoryGUI g, InventoryManager i){
        
        setGui(g);
        setModel(i);

        


        
    }



    public Tool searchToolName(String name){
        
        
        
        
        
        return null;
    }

    public Tool searchToolId(int id){



        return null;
    }

    public int checkToolQuant(String name){



        return 0;
    }

    public void decreaseToolQuant(String name){

    }

    public void listAllTools(){

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
    public InventoryManager getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(InventoryManager model) {
        this.model = model;
    }

}
