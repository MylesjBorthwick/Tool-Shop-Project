package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;


public class InventoryGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private InventoryPanel search;
    private JButton switchToClient;

    public InventoryGUI() {
        super("Inventory Manager");
        setLayout(new BorderLayout());

        search = new InventoryPanel();
        switchToClient = new JButton("Inventory Manager");
        add(switchToClient, BorderLayout.NORTH);
        add(search, BorderLayout.CENTER);

        setMinimumSize(new Dimension(700, 500)); // Set minimum size
        pack();
        //setSize(900, 600); // Set size if pack() isn't used
        setVisible(true); // Make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
    public void addSwitchListener(ActionListener switchListen){
        switchToClient.addActionListener(switchListen);
    }

    public void displayErrorMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void addExecuteListener(ActionListener executeListener)
    {
        search.addExecuteListener(executeListener);
    }

    public void addClearListener(ActionListener clearListener)
    {
        search.addClearListener(clearListener);
    }

    public void addListListener(ActionListener listListener)
    {
        search.addListListener(listListener);
    }

    public void addOrderListener(ActionListener orderListener)
    {
        search.addOrderListener(orderListener);
    }

    public void setTextField(String text){
        search.setTextField(text);
    }


    public String getExecuteType(){
        return search.getExecuteType();
    }

    public String getExecuteParam(){
        return search.getExecuteParam();
    }
   

}
