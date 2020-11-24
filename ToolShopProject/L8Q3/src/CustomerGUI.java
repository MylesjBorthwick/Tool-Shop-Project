import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

public class CustomerGUI extends JFrame {


    private static final long serialVersionUID = 1L;
    
    private SearchPanelInventory search;



    public CustomerGUI(){
        super("Customer Manager");
        setLayout(new BorderLayout());

        search = new SearchPanelInventory();

        add(search, BorderLayout.CENTER);

        setMinimumSize(new Dimension(900, 500)); // Set minimum size
        pack();
        //setSize(900, 600); // Set size if pack() isn't used
        setVisible(true); // Make frame visible
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

    }

    public void addSearchListener(ActionListener searchListener)
    {
        search.addSearchListener(searchListener);
    }

    public void addClearSearchListener(ActionListener clearSearchListener)
    {
        search.addClearSearchListener(clearSearchListener);
    }

    public void addSelectionListener(ListSelectionListener selectionListener)
    {
        search.addSelectionListener(selectionListener);
    }

    public void displayErrorMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public String getSearchType()
    {
        return search.getSearchType();
    }

    public String getSearchParam()
    {   
        return search.getSearchParam();
    }

    public Tool getListSelection()
    {
        return search.getListSelection();
    }

    public void setSearchResultsList(ArrayList<Tool> tools)
    {
        search.setSearchResultsList(tools);
    }


}

