package view;

import controller.InventoryGUIController;
import controller.InventoryModel;

public class GUITest {
    public static void main(String[] args) {
        InventoryGUI inv = new InventoryGUI();
        InventoryModel mod = new InventoryModel();

        InventoryGUIController control = new InventoryGUIController(inv, mod);
    }
}
