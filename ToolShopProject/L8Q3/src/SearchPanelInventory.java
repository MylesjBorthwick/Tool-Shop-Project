import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
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
import javax.swing.border.Border;
import javax.swing.event.ListSelectionListener;

public class SearchPanelInventory extends JPanel {

	private static final long serialVersionUID = 1L;
    

    private JLabel searchType;
    private JLabel searchParam;
	private JLabel searchResults;
	
	private ButtonGroup searchTypeGroup;
    private JRadioButton toolId;
	private JRadioButton toolName;
	private JRadioButton toolType;
    private JRadioButton supplierId;
	
	private JTextField searchParamField;
    private JButton searchButton;
    private JButton clearSearchButton;
    private DefaultListModel<Tool> searchListModel;
    private JList<Tool> searchResultsList;
    private JScrollPane searchResultsPane;


	public SearchPanelInventory(){

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;


		searchType = new JLabel("Select Search Type:");
		searchParam = new JLabel("Enter Search: ");
		searchResults = new JLabel("Results:");

		searchTypeGroup = new ButtonGroup();
        toolId = new JRadioButton("Tool ID");
		toolName = new JRadioButton("Tool Name");
		supplierId = new JRadioButton("Supplier ID");
        toolType = new JRadioButton("Power Type");
        searchParamField = new JTextField(20);
        searchButton = new JButton("Search");
        clearSearchButton = new JButton("Clear Search");
        searchListModel = new DefaultListModel<Tool>();
        searchResultsList = new JList<Tool>(searchListModel);
        searchResultsPane = new JScrollPane(searchResultsList);


		searchTypeGroup.add(toolId);
		searchTypeGroup.add(toolName);
		searchTypeGroup.add(toolType);
		searchTypeGroup.add(supplierId);

		toolId.setSelected(true);
		toolId.setActionCommand("toolId");
		toolName.setActionCommand("toolName");
		toolType.setActionCommand("toolType");

		searchResultsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        searchResultsList.setLayoutOrientation(JList.VERTICAL);
		searchResultsList.setVisibleRowCount(-1);
		
		searchResultsPane.setPreferredSize(new Dimension(250, 80));

		addComponents(gc);


	}

	public String getSearchType()
    {
        return searchTypeGroup.getSelection().getActionCommand();
    }
    
    public String getSearchParam()
    {
        return searchParamField.getText();
    }
    
    public Tool getListSelection()
    {
        return searchResultsList.getSelectedValue();
	}
	
	public void addSearchListener(ActionListener listenerForSearchButton)
    {
        searchButton.addActionListener(listenerForSearchButton);
    }

    public void addClearSearchListener(ActionListener clearSearchListener)
    {
        clearSearchButton.addActionListener(clearSearchListener);
    }

    public void addSelectionListener(ListSelectionListener selectionListener)
    {
        searchResultsList.addListSelectionListener(selectionListener);
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
        add(toolType, gc);

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

	public void setSearchResultsList(ArrayList<Tool> tools)
    {
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
