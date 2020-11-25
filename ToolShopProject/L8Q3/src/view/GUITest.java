package view;

import controller.CustomerModel;
import controller.InventoryGUIController;
import controller.InventoryModel;

public class GUITest {
    public static void main(String[] args) {
        InventoryGUI inv = new InventoryGUI();
        InventoryModel mod = new InventoryModel();
        
        CustomerGUI cust = new CustomerGUI();
        CustomerModel cm = new CustomerModel();
        //InventoryGUIController control = new InventoryGUIController(inv, mod);

    }
}
