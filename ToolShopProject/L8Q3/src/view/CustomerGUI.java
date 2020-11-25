package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

import model.Client;

public class CustomerGUI extends JFrame {


    private static final long serialVersionUID = 1L;
    
    private JButton switchToInv;
    private SearchPanelClient search;
    private InfoPanelClient info;



    public CustomerGUI(){
        super("Customer Manager");
        setLayout(new BorderLayout());
        switchToInv = new JButton ("Customer Manager");
        search = new SearchPanelClient();
        info = new InfoPanelClient();

        add(switchToInv, BorderLayout.NORTH);
        add(search, BorderLayout.CENTER);
        add(info, BorderLayout.EAST);

        setMinimumSize(new Dimension(900, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }



}




