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

import model.Client;

public class CustomerGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JButton switchToInv;
    private SearchPanelClient search;
    private InfoPanelClient info;

    public CustomerGUI() {
        super("Customer Manager");
        setLayout(new BorderLayout());
        switchToInv = new JButton("Customer Manager");
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

    public void addSwitchListener(ActionListener e){
        switchToInv.addActionListener(e);
    }

    public void displayErrorMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    public void addSearchListener(ActionListener searchListener){
        search.addSearchListener(searchListener);
    }
    public void addClearListener(ActionListener clearListen){
        search.addClearListener(clearListen);
    }
    
    public String getSearchType(){
        return search.getSearchType();
    }

    public String getSearchParam(){
        return search.getSearchParam();
    }
    public void setTextField(String text){
        search.setTextField(text);
    }
    public void addSaveListener(ActionListener saveListen){
        info.addSaveListener(saveListen);
    }

    public void addClearInfoListener(ActionListener clearListen){
        info.addClearListener(clearListen);
    }

    public void addDeleteListener(ActionListener deleteListen){
        info.addDeleteListener(deleteListen);
    }

    public void addUpdateListener(ActionListener updateListen){
        info.addUpdateListener(updateListen);
    }

    public String getClientIdField(){
        return info.getClientIdField();
    }

    public String getClientFirstNameField(){
        return info.getClientFirstNameField();
    }

    public String getLastNameField(){
        return info.getLastNameField();
    }

    public String getAddressField(){
        return info.getAddressField();
    }

    public String getPostalField(){
        return info.getPostalField();
    }

    public String getPhoneNumberField(){
        return info.getPhoneNumberField();
    }

    public String getClientType(){
        return info.getClientType();
    }

        




    }









