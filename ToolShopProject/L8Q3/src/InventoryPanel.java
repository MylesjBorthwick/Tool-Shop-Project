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
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class InventoryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
    

    private JLabel searchType;
    private JLabel searchParam;
	private JLabel searchResults;
	
	private ButtonGroup searchTypeGroup;
    private JRadioButton toolId;
	private JRadioButton toolName;
	private JRadioButton checkQuant;
	private JRadioButton decreaseQuant;
	
	private JTextField searchParamField;
    private JButton searchButton;
	private JButton clearSearchButton;
    private JButton listAllTools;
    private JButton printOrder;
    private DefaultListModel<Tool> searchListModel;
    private JList<Tool> searchResultsList;
    private JScrollPane searchResultsPane;


	public InventoryPanel(){

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;

        Dimension dim = getPreferredSize();
        dim.width = 500;
        setPreferredSize(dim);
        Border innerBorder = BorderFactory.createTitledBorder("Inventory");
        Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);       // Invisible border to give inner border more space
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		searchType = new JLabel("Select Action Type:");
		searchParam = new JLabel("Enter Tool: ");
		searchResults = new JLabel("Results:");

		searchTypeGroup = new ButtonGroup();
        toolId = new JRadioButton("Search by Tool ID");
		toolName = new JRadioButton("Search by Tool Name");
		checkQuant = new JRadioButton("Check Quantity by Name");
		decreaseQuant = new JRadioButton("Decrease Tool Quantity by Name");

        searchParamField = new JTextField(20);
        searchButton = new JButton("Execute");
		clearSearchButton = new JButton("Clear");
        listAllTools = new JButton("All Tools");
        printOrder = new JButton("Show Order");
        searchListModel = new DefaultListModel<Tool>();
        searchResultsList = new JList<Tool>(searchListModel);
        searchResultsPane = new JScrollPane(searchResultsList);


		searchTypeGroup.add(toolId);
		searchTypeGroup.add(toolName);
		searchTypeGroup.add(checkQuant);
		searchTypeGroup.add(decreaseQuant);
		

		toolId.setSelected(true);
		toolId.setActionCommand("toolId");
		toolName.setActionCommand("toolName");
		checkQuant.setActionCommand("checkQuant");
		decreaseQuant.setActionCommand("decreaseQuant");

		searchResultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchResultsList.setLayoutOrientation(JList.VERTICAL);
		searchResultsList.setVisibleRowCount(-1);
		
		searchResultsPane.setPreferredSize(new Dimension(150, 80));

		addComponents(gc);


	}

	public String getSearchType(){
        return searchTypeGroup.getSelection().getActionCommand();
    }
    
    public String getSearchParam(){
        return searchParamField.getText();
    }
    
    public Tool getListSelection(){
        return searchResultsList.getSelectedValue();
	}
	
	public void addSearchListener(ActionListener listenerForSearchButton){
        searchButton.addActionListener(listenerForSearchButton);
    }

    public void addClearSearchListener(ActionListener clearSearchListener){
        clearSearchButton.addActionListener(clearSearchListener);
	}
	
	public void addListAllListener(ActionListener listAllListener){
        listAllTools.addActionListener(listAllListener);
    }

    public void addShowOrderListener(ActionListener show){
        printOrder.addActionListener(show);
    }

    public void addSelectionListener(ListSelectionListener selectionListener){
        searchResultsList.addListSelectionListener(selectionListener);
    }

	private void addComponents(GridBagConstraints gc){
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
        add(searchResults, gc);

        ////////////////////* Next Row *////////////////////
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridy++;

        gc.gridx = 0;
        gc.gridwidth = 5;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.fill = GridBagConstraints.BOTH;
        gc.insets = new Insets(0, 0, 0, 0);         
        add(searchResultsPane, gc);
	}

	public void setSearchResultsList(ArrayList<Tool> tools){
        // Create and populate new JList Model
        searchListModel = new DefaultListModel<Tool>();
        for (Tool t : tools)
        {
            searchListModel.addElement(t);
        }
        // Refresh JList by switching to new model
        searchResultsList.setModel(searchListModel);
    }
	


}
