package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import model.Tool;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class InventoryPanel extends JPanel {

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


	public InventoryPanel(){

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;


		executeType = new JLabel("Select Action Type:");
		executeParam = new JLabel("Enter Tool: ");
        results = new JLabel("Results:");
        textArea = new JTextArea("");
        textArea.setEditable(false);

		actionTypeGroup = new ButtonGroup();
        toolId = new JRadioButton("Search by Tool ID");
		toolName = new JRadioButton("Search by Tool Name");
		checkQuant = new JRadioButton("Check Quantity by Name");
		decreaseQuant = new JRadioButton("Decrease Tool Quantity by Name");

        executeParamField = new JTextField(20);
        searchButton = new JButton("Execute");
		clearSearchButton = new JButton("Clear");
        listAllTools = new JButton("All Tools");
        printOrder = new JButton("Show Order");
        resultsPane = new JScrollPane(textArea);


		actionTypeGroup.add(toolId);
		actionTypeGroup.add(toolName);
		actionTypeGroup.add(checkQuant);
		actionTypeGroup.add(decreaseQuant);
		

		toolId.setSelected(true);
		toolId.setActionCommand("toolId");
		toolName.setActionCommand("toolName");
		checkQuant.setActionCommand("checkQuant");
		decreaseQuant.setActionCommand("decreaseQuant");
		
		resultsPane.setPreferredSize(new Dimension(150, 80));

		addComponents(gc);

    }

    public void addExecuteListener(ActionListener executeListener){
        searchButton.addActionListener(executeListener);
    }

    public void addClearListener(ActionListener clearListen){
        clearSearchButton.addActionListener(clearListen);
    }

    public void addListListener(ActionListener listListener){
        listAllTools.addActionListener(listListener);
    }

    public void addOrderListener(ActionListener orderListener){
        printOrder.addActionListener(orderListener);
    }

    
    public String getExecuteType(){
        return actionTypeGroup.getSelection().getActionCommand();
    }

    public String getExecuteParam(){
        return executeParamField.getText();
    }

    public void setTextField(String text){
        textArea.setText(text);
    }





	private void addComponents(GridBagConstraints gc){
        ////////////////////* First Row *////////////////////
        gc.weightx = 1;     // Ratio of space compared to other cells
        gc.weighty = 0.1;   // Making this row skinny
        gc.gridy = 0;

        gc.gridx = 0;       // Have to initialize grid components before using them
        gc.anchor = GridBagConstraints.LINE_START;    // Sets label to right side of cell
        gc.insets = new Insets(0, 0, 0, 0);         // Adds 5 pixel space to the right of label
        add(executeType, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(toolId, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(toolName, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
		add(checkQuant, gc);
		
		////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(decreaseQuant, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(executeParam, gc);

        ////////////////////* Next Row *////////////////////
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
        
        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(results, gc);

        ////////////////////* Next Row *////////////////////
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
