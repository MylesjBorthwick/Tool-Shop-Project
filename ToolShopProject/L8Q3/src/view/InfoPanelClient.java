package view;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


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

 
    public InfoPanelClient()
    {
        // Layout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;       
        
        
        Dimension dim = getPreferredSize(); 
        dim.width = 400;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Client Info");
              

        // Instantiate components
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

        // JComboBox setup
        DefaultComboBoxModel<String> clientTypeModel = new DefaultComboBoxModel<String>();
        clientTypeModel.addElement("C");
        clientTypeModel.addElement("R");
        clientTypeCombo.setModel(clientTypeModel);
        clientTypeCombo.setSelectedIndex(0);    // Sets default selection to "Residential"

        // Add components to panel
        addComponents(gc);

    }

    //================================================================================
    // Helper methods
    //================================================================================
    /**
     * Adds each component to the panel.
     * @param gc GridBagConstraints object corresponding to panel
     */
    private void addComponents(GridBagConstraints gc)
    {
        ////////////////////* First Row *////////////////////
        gc.weightx = 1;     // Ratio of space compared to other cells
        gc.weighty = 0.1;   // Making this row skinny
        gc.gridy = 0;

        gc.gridx = 0;       // Have to initialize grid components before using them
        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_END;    // Sets label to right side of cell
        gc.insets = new Insets(0, 0, 0, 0);         // Adds 5 pixel space to the right of label
        add(clientIDLabel, gc);

        gc.gridx = 1;
        gc.gridwidth = 2;   // Allows field to take up 2 grid slots
        gc.anchor = GridBagConstraints.LINE_START;  // Sets field to left side of cell
        gc.insets = new Insets(0, 0, 0, 0);
        add(clientIDField, gc);

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
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
    }


    public void setClientTypeCombo(String text)
    {
        if (text.equals("C") || text.equals("R"))
        {
            this.clientTypeCombo.setSelectedItem(text);
        }
    }






}
