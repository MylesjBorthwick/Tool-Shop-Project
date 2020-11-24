public class InventoryGUIController {
    
    private InventoryGUI gui;
    private InventoryModel model;

    public InventoryGUIController(InventoryGUI g, InventoryModel m){
        setGui(g);
        setModel(m);

        
    }


    

    public Tool searchToolName(String name){

    }

    public Tool searchToolId(int id){

    }

    public int checkToolQuant(String name){

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
    public InventoryModel getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(InventoryModel model) {
        this.model = model;
    }

}
