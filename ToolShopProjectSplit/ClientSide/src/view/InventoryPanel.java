package view;
/**
 * InventoryPanel Class Creates and Organizes Elements
 * For Iventory management and searching. Gets user input from element
 * interaction. GridBagLayout used for GUI layout
 * 
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since November 2020
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class InventoryPanel extends JPanel {

    //Instance Variables
	private static final long serialVersionUID = 1L;
    
    private JLabel executeType;
    private JLabel executeParam;
	private JLabel results;
	
	private ButtonGroup actionTypeGroup;
    private JRadioButton toolId;
	private JRadioButton toolName;
	private JRadioButton checkQuant;
	private JRadioButton decreaseQuant;
	
    private JTextField executeParamField;
    
    private JButton searchButton;
	private JButton clearSearchButton;
    private JButton listAllTools;
    private JButton printOrder;

    private JScrollPane resultsPane;
    private JTextArea textArea;

    /**
     * Panel Constructor
     */
	public InventoryPanel(){

        //Set Panel Layout
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;

        //Create GUI Elements with required Settings
        //Labels
		executeType = new JLabel("Select Action Type:");
		executeParam = new JLabel("Enter Tool: ");
        results = new JLabel("Results:");
        //TextArea for Printing
        textArea = new JTextArea("");
        textArea.setEditable(false);
        //Radio Button For type selection
		actionTypeGroup = new ButtonGroup();
        toolId = new JRadioButton("Search by Tool ID");
		toolName = new JRadioButton("Search by Tool Name");
		checkQuant = new JRadioButton("Check Quantity by Name");
		decreaseQuant = new JRadioButton("Decrease Tool Quantity by Name");
        //Textfield for input
        executeParamField = new JTextField(20);
        //Buttons
        searchButton = new JButton("Execute");
		clearSearchButton = new JButton("Clear");
        listAllTools = new JButton("All Tools");
        printOrder = new JButton("Show Order");
        //Scroll pane for TextArea
        resultsPane = new JScrollPane(textArea);

        //Add Radio Buttons to group
		actionTypeGroup.add(toolId);
		actionTypeGroup.add(toolName);
		actionTypeGroup.add(checkQuant);
		actionTypeGroup.add(decreaseQuant);
		
        //Settings for radio buttons
		toolId.setSelected(true);
		toolId.setActionCommand("toolId");
		toolName.setActionCommand("toolName");
		checkQuant.setActionCommand("checkQuant");
		decreaseQuant.setActionCommand("decreaseQuant");
        
        //Results Box Settings
		resultsPane.setPreferredSize(new Dimension(150, 80));

        //Add components to window
		addComponents(gc);

    }

    /**
     * Add Listener for Execute Button
     * @param executeListener
     */
    public void addExecuteListener(ActionListener executeListener){
        searchButton.addActionListener(executeListener);
    }

    /**
     * Add Listener for CLear Button
     */
    public void addClearListener(ActionListener clearListen){
        clearSearchButton.addActionListener(clearListen);
    }

     /**
     * Add Listener for List all Button
     */
    public void addListListener(ActionListener listListener){
        listAllTools.addActionListener(listListener);
    }

     /**
     * Add Listener for Order Button
     */
    public void addOrderListener(ActionListener orderListener){
        printOrder.addActionListener(orderListener);
    }

    /**
     * Getter for Type Selection
     * @return Action Command string
     */
    public String getExecuteType(){
        return actionTypeGroup.getSelection().getActionCommand();
    }

    /**
     * Getter for Search Field
     */
    public String getExecuteParam(){
        return executeParamField.getText();
    }

    /**
     * Setter For TextArea
     */
    public void setTextField(String text){
        textArea.setText(text);
    }

    /**
     * Adds/Organizes components to Window 
     * Sets layout of Panel Elements
     * @param GridBagConstraints gc
     */
	private void addComponents(GridBagConstraints gc){
       
        //Add All Elements with Position to gridlayout

        gc.weightx = 1;     
        gc.weighty = 0.1;  
        gc.gridy = 0;

        gc.gridx = 0;       
        gc.anchor = GridBagConstraints.LINE_START;    
        gc.insets = new Insets(0, 0, 0, 0);         
        add(executeType, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(toolId, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(toolName, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
		add(checkQuant, gc);
		
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(decreaseQuant, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(executeParam, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(executeParamField, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchButton, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
		add(clearSearchButton, gc);

		gc.gridx = 3;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(listAllTools, gc);

        gc.gridx = 4;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(printOrder, gc);
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(results, gc);

        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(resultsPane, gc);
	}

	
}
