package view;

/**
 * InventoryGUI class for Inventory Managment GUI Window.
 * Creates window + adds Search panel and gui switch button
 * 
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since November 2020
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class InventoryGUI extends JFrame {

    //Instance Variables
    private static final long serialVersionUID = 1L;
    private InventoryPanel search;
    private JButton switchToClient;

    /**
     * Inventory GUI constructor. Sets window settings,
     * adds gui elements to frame
     */
    public InventoryGUI() {
        //Window Name
        super("Inventory Manager");

        //Window Layout
        setLayout(new BorderLayout());

        //Construct Elements
        search = new InventoryPanel();
        switchToClient = new JButton("Inventory Manager");
        
        //Add GUI elements
        add(switchToClient, BorderLayout.NORTH);
        add(search, BorderLayout.CENTER);

        //Window Settings
        setMinimumSize(new Dimension(700, 500)); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Add Switch Button Listener
     * @param switchListen
     */
    public void addSwitchListener(ActionListener switchListen){
        switchToClient.addActionListener(switchListen);
    }

    /**
     * Display message
     */
    public void displayMessage(String message)
    {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * Add Execute button Listener
     * @param executeListener
     */
    public void addExecuteListener(ActionListener executeListener)
    {
        search.addExecuteListener(executeListener);
    }

    /**
     * Add Clear button Listener
     * @param clearListener
     */
    public void addClearListener(ActionListener clearListener)
    {
        search.addClearListener(clearListener);
    }

    /**
     * Add Listener for list all button
     */
    public void addListListener(ActionListener listListener)
    {
        search.addListListener(listListener);
    }

    /**
     * Adds Listener for order button
     * @param orderListener
     */
    public void addOrderListener(ActionListener orderListener)
    {
        search.addOrderListener(orderListener);
    }

    /**
     * Set Text in TextField
     * @param text
     */
    public void setTextField(String text){
        search.setTextField(text);
    }

    /**
     * Gets execute type in window
     * @return execute command string
     */
    public String getExecuteType(){
        return search.getExecuteType();
    }

    /**
     * Gets Text in Search Box
     * @return text in search box
     */
    public String getExecuteParam(){
        return search.getExecuteParam();
    }
   

}
