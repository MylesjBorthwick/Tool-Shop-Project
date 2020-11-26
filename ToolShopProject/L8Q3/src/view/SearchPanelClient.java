package view;

/**
 *Search Panel For Client Managment GUI. Handles View for
 *Client Searching 
 *@author Myles Borthwick
 *@author Ken Loyghery
 *@since November 2020
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

public class SearchPanelClient extends JPanel {

    //Instance Variables
	private static final long serialVersionUID = 1L;

    private JLabel type;
    private JLabel param;
	private JLabel results;
	
	private ButtonGroup searchTypeGroup;
    private JRadioButton clientId;
	private JRadioButton clientLastName;
	private JRadioButton clientType;
	
    private JTextField searchParamField;
    private JTextArea textArea;
    private JButton searchButton;
    private JButton clearSearchButton;
    private JScrollPane searchResultsPane;

    /**
     * Search Panel Constructor, Creates elements and adds them
     * to panel.
     */
	public SearchPanelClient(){

        //Set Panel Layout
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;

        //Set Dimension
        Dimension dim = getPreferredSize();
        dim.width = 500;
        setPreferredSize(dim);

        //Create GUI elemnets and handle initial settings
		type = new JLabel("Select Search Type:");
		param = new JLabel("Enter Search: ");
        results = new JLabel("Results:");
        textArea = new JTextArea("");
        textArea.setEditable(false);
		searchTypeGroup = new ButtonGroup();
        clientId = new JRadioButton("Client ID");
		clientLastName = new JRadioButton("Client Last Name");
        clientType = new JRadioButton("Client Type");
        searchParamField = new JTextField(20);
        searchButton = new JButton("Search");
        clearSearchButton = new JButton("Clear Search");
        searchResultsPane = new JScrollPane(textArea);

        //Add RadiButtons to Group
		searchTypeGroup.add(clientId);
		searchTypeGroup.add(clientLastName);
		searchTypeGroup.add(clientType);
        //Initial Settinggs for RadioButtons
		clientId.setSelected(true);
	    clientId.setActionCommand("clientId");
		clientLastName.setActionCommand("lastName");
		clientType.setActionCommand("clientType");

		//Results Pane Settings
		searchResultsPane.setPreferredSize(new Dimension(250, 80));
        //Add All Components
		addComponents(gc);

    }
    /**
     * Add listener for  Search Button
     * @param searchListen
     */
    public void addSearchListener(ActionListener searchListen){
        searchButton.addActionListener(searchListen);
    }
    /**
     * Add listener for Clear Button
     */
    public void addClearListener(ActionListener clearListen){
        clearSearchButton.addActionListener(clearListen);
    }
    /**
     * Get Search Type from RadioButton Group
     * @return type command
     */
    public String getSearchType(){
        return searchTypeGroup.getSelection().getActionCommand();
    }

    /**
     * Get Search Field input
     * @return String in Search bar
     */
    public String getSearchParam(){
        return searchParamField.getText();
    }
    /**
     * Set Text in TextArea
     * @param text to be entered
     */
    public void setTextField(String text){
        textArea.setText(text);
    }
    /**
     * Add Elements to Layout with grid position
     * and settings
     * @param gc
     */
	private void addComponents(GridBagConstraints gc)
    {
        
        gc.weightx = 1;     
        gc.weighty = 0.1;  
        gc.gridy = 0;

        gc.gridx = 0;       
        gc.anchor = GridBagConstraints.LINE_START;   
        gc.insets = new Insets(0, 0, 0, 0);        
        add(type, gc);
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clientId, gc);
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clientLastName, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clientType, gc);

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(param, gc);
        
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchParamField, gc);

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchButton, gc);

        gc.gridx = 2;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clearSearchButton, gc);

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
        gc.gridwidth = 3;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchResultsPane, gc);
	}
}
