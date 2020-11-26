package view;

/**
 *Info Panel For Client Managment GUI. Handles View for
 *Client Adding, deleting and updating 
 *@author Myles Borthwick
 *@author Ken Loyghery
 *@since November 2020
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InfoPanelClient extends JPanel
{
    private static final long serialVersionUID = 1L;

    private JLabel clientIDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JLabel postalCodeLabel;
    private JLabel phoneNumberLabel;
    private JLabel clientTypeLabel;
    private JTextField clientIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField addressField;
    private JTextField postalCodeField;
    private JTextField phoneNumberField;
    private JComboBox<String> clientTypeCombo;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton updateButton;

    /**
    * Information Panel Constructor. Creates GUI for information panel
    */
    public InfoPanelClient()
    {
        //Setup Layout
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;       
        
        //Set Dimensions
        Dimension dim = getPreferredSize(); 
        dim.width = 400;
        setPreferredSize(dim);

        //Construct Components
        clientIDLabel = new JLabel("Client ID: ");
        firstNameLabel = new JLabel("First Name: "); 
        lastNameLabel = new JLabel("Last Name: ");
        addressLabel = new JLabel("Address: ");
        postalCodeLabel = new JLabel("Postal Code: ");
        phoneNumberLabel = new JLabel("Phone Number: ");
        clientTypeLabel = new JLabel("Client Type: ");
        clientIDField = new JTextField(15);
        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        addressField = new JTextField(15);
        postalCodeField = new JTextField(15);
        phoneNumberField = new JTextField(15);
        clientTypeCombo = new JComboBox<String>();
        saveButton = new JButton("Save");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        updateButton = new JButton("Update");

        //SetUp ComboBox
        DefaultComboBoxModel<String> clientTypeModel = new DefaultComboBoxModel<String>();
        clientTypeModel.addElement("C");
        clientTypeModel.addElement("R");
        clientTypeCombo.setModel(clientTypeModel);
        //Set Default for Combobox
        clientTypeCombo.setSelectedIndex(0);

        //Add All COmponents
        addComponents(gc);

    }

    /**
     * Add Listeners for info panel
     */

    public void addSaveListener(ActionListener saveListen){
        saveButton.addActionListener(saveListen);
    }

    public void addClearListener(ActionListener clearListen){
        clearButton.addActionListener(clearListen);
    }

    public void addDeleteListener(ActionListener deleteListen){
        deleteButton.addActionListener(deleteListen);
    }

    public void addUpdateListener(ActionListener updateListen){
        updateButton.addActionListener(updateListen);
    }

    /**
     * Getters for info panel fields
     */

    public String getClientIdField(){
        return clientIDField.getText();
    }

    public String getClientFirstNameField(){
        return firstNameField.getText();
    }

    public String getLastNameField(){
        return lastNameField.getText();
    }

    public String getAddressField(){
        return addressField.getText();
    }

    public String getPostalField(){
        return postalCodeField.getText();
    }

    public String getPhoneNumberField(){
        return phoneNumberField.getText();
    }

    public String getClientType(){
        return (String)clientTypeCombo.getSelectedItem();
    }

    /**
     * Setters for ClientINFO panels gui fields
     */

    public void setClientIdField(String t){
        clientIDField.setText(t);
    }

    public void setClientFirstNameField(String t){
        firstNameField.setText(t);
    }

    public void setLastNameField(String t){
        lastNameField.setText(t);
    }

    public void setAddressField(String t){
        addressField.setText(t);
    }

    public void setPostalField(String t){
        postalCodeField.setText(t);
    }

    public void setPhoneNumberField(String t){
        phoneNumberField.setText(t);
    }

    /**
     * Add components to panel, with positions in layout
     * @param gc
     */
    private void addComponents(GridBagConstraints gc)
    {
        
        gc.weightx = 1;     
        gc.weighty = 0.1;   
        gc.gridy = 0;

        gc.gridx = 0;       
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;   
        gc.insets = new Insets(0, 0, 0, 0);        
        add(clientIDLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;  
        gc.anchor = GridBagConstraints.LINE_START;  
        gc.insets = new Insets(0, 0, 0, 0);
        add(clientIDField, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(firstNameLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(firstNameField, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(lastNameLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(lastNameField, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(addressLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(addressField, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(postalCodeLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(postalCodeField, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(phoneNumberLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(phoneNumberField, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(clientTypeLabel, gc);

        gc.gridx = 1; 
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(clientTypeCombo, gc);

        gc.weightx = 1;
        gc.weighty = 0.2;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);         
        add(saveButton, gc);

        gc.gridx = 1;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);
        add(deleteButton, gc);
        
        gc.gridx = 2;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(clearButton, gc);

        gc.gridx = 3;
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);
        add(updateButton, gc);


    }


}
