import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;

public class CustomerGUI extends JFrame {


    private static final long serialVersionUID = 1L;
    
    private SearchPanelClient search;
    private InfoPanelClient info;



    public CustomerGUI(){
        super("Customer Manager");
        setLayout(new BorderLayout());
        search = new SearchPanelClient();
        info = new InfoPanelClient();

        add(search, BorderLayout.CENTER);
        add(info, BorderLayout.EAST);

        setMinimumSize(new Dimension(900, 500));
        pack();
        setVisible(true);
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

    public Client getListSelection()
    {
        return search.getListSelection();
    }

    public void setSearchResultsList(ArrayList<Client> clients)
    {
        search.setSearchResultsList(clients);
    }

    public String getClientIDField() 
    {
        return info.getClientIDField();
    }

    public void setClientIDField(String text) 
    {
        info.setClientIDField(text);
    }

    public String getFirstNameField() 
    {
        return info.getFirstNameField();
    }

    public void setFirstNameField(String text) 
    {
        info.setFirstNameField(text);
    }

    public String getLastNameField() 
    {
        return info.getLastNameField();
    }

    public void setLastNameField(String text) 
    {
        info.setLastNameField(text);
    }

    public String getAddressField() 
    {
        return info.getAddressField();
    }

    public void setAddressField(String text) 
    {
        info.setAddressField(text);
    }

    public String getPostalCodeField() 
    {
        return info.getPostalCodeField();
    }

    public void setPostalCodeField(String text) 
    {
        info.setPostalCodeField(text);
    }

    public String getPhoneNumberField() 
    {
        return info.getPhoneNumberField();
    }

    public void setPhoneNumberField(String text) 
    {
        info.setPhoneNumberField(text);
    }

    public String getClientTypeCombo() 
    {
        return info.getClientTypeCombo();
    }

    public void setClientTypeCombo(String text) 
    {
        info.setClientTypeCombo(text);
    }

}




