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

import model.Tool;

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

        switchToClient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                CustomerGUI cgui = new CustomerGUI();

            }
        });

    }

   

}
