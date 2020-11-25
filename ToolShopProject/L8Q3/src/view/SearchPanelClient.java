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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import model.Client;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class SearchPanelClient extends JPanel {

	private static final long serialVersionUID = 1L;
    

    private JLabel searchType;
    private JLabel searchParam;
	private JLabel searchResults;
	
	private ButtonGroup searchTypeGroup;
    private JRadioButton clientId;
	private JRadioButton clientLastName;
	private JRadioButton clientType;
	
	private JTextField searchParamField;
    private JButton searchButton;
    private JButton clearSearchButton;
    private DefaultListModel<Client> searchListModel;
    private JList<Client> searchResultsList;
    private JScrollPane searchResultsPane;


	public SearchPanelClient(){

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;

        Dimension dim = getPreferredSize();
        dim.width = 500;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Search Clients");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);       // Invisible border to give inner border more space
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        

		searchType = new JLabel("Select Search Type:");
		searchParam = new JLabel("Enter Search: ");
		searchResults = new JLabel("Results:");

		searchTypeGroup = new ButtonGroup();
        clientId = new JRadioButton("Client ID");
		clientLastName = new JRadioButton("Client Last Name");
        clientType = new JRadioButton("Client Type");
        searchParamField = new JTextField(20);
        searchButton = new JButton("Search");
        clearSearchButton = new JButton("Clear Search");
        searchListModel = new DefaultListModel<Client>();
        searchResultsList = new JList<Client>(searchListModel);
        searchResultsPane = new JScrollPane(searchResultsList);


		searchTypeGroup.add(clientId);
		searchTypeGroup.add(clientLastName);
		searchTypeGroup.add(clientType);

		clientId.setSelected(true);
	    clientId.setActionCommand("clientId");
		clientLastName.setActionCommand("lastName");
		clientType.setActionCommand("clientType");

		searchResultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchResultsList.setLayoutOrientation(JList.VERTICAL);
		searchResultsList.setVisibleRowCount(-1);
		
		searchResultsPane.setPreferredSize(new Dimension(250, 80));

		addComponents(gc);


	}


	private void addComponents(GridBagConstraints gc)
    {
        ////////////////////* First Row *////////////////////
        gc.weightx = 1;     // Ratio of space compared to other cells
        gc.weighty = 0.1;   // Making this row skinny
        gc.gridy = 0;

        gc.gridx = 0;       // Have to initialize grid components before using them
        gc.anchor = GridBagConstraints.LINE_START;    // Sets label to right side of cell
        gc.insets = new Insets(0, 0, 0, 0);         // Adds 5 pixel space to the right of label
        add(searchType, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clientId, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clientLastName, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(clientType, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchParam, gc);

        ////////////////////* Next Row *////////////////////
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

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridy++;

        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchResults, gc);

        ////////////////////* Next Row *////////////////////
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

	public void setSearchResultsList(ArrayList<Client> clients)
    {
        // Create and populate new JList Model
        searchListModel = new DefaultListModel<Client>();
        for (Client c : clients)
        {
            searchListModel.addElement(c);
        }
        // Refresh JList by switching to new model
        searchResultsList.setModel(searchListModel);
    }
	


}
