package view;

/**
 * CustomerGUI class for Customer Managment GUI Window.
 * Creates window + adds Search panel, info panel and gui switch button
 * 
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since November 2020
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class CustomerGUI extends JFrame {
    //Instance Variables
    private static final long serialVersionUID = 1L;
    private JButton switchToInv;
    private SearchPanelClient search;
    private InfoPanelClient info;

    /**
     * Customer GUI constructor. Sets window settings,
     * adds gui elements to frame
     */
    public CustomerGUI() {
        //Window Name
        super("Customer Manager");
        //Window Layout
        setLayout(new BorderLayout());
        //Construct Elements
        switchToInv = new JButton("Customer Manager");
        search = new SearchPanelClient();
        info = new InfoPanelClient();
        //Add GUI elements
        add(switchToInv, BorderLayout.NORTH);
        add(search, BorderLayout.CENTER);
        add(info, BorderLayout.EAST);
        //Window Settings
        setMinimumSize(new Dimension(900, 500));
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Add switch button listener
     * @param e listener
     */
    public void addSwitchListener(ActionListener e){
        switchToInv.addActionListener(e);
    }

    /**
     * Display message
     */
    public void displayMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    /**
     * Add search button listener
     */
    public void addSearchListener(ActionListener searchListener){
        search.addSearchListener(searchListener);
    }

    /**
     * Add Clear button listener
     * @param clearListen
     */
    public void addClearListener(ActionListener clearListen){
        search.addClearListener(clearListen);
    }
    
    /**
     * Add searchtype listener
     * @return searchtype
     */
    public String getSearchType(){
        return search.getSearchType();
    }

    /**
     * get Search param
     * @return search field text
     */
    public String getSearchParam(){
        return search.getSearchParam();
    }

    /**
     * Set textfield
     * @param text
     */
    public void setTextField(String text){
        search.setTextField(text);
    }

    /**
     * Add save listener
     * @param saveListen
     */
    public void addSaveListener(ActionListener saveListen){
        info.addSaveListener(saveListen);
    }

    /**
     * Add clear listener
     * @param clearListen
     */
    public void addClearInfoListener(ActionListener clearListen){
        info.addClearListener(clearListen);
    }

    /**
     * Add delete listener
     * @param deleteListen
     */
    public void addDeleteListener(ActionListener deleteListen){
        info.addDeleteListener(deleteListen);
    }

    /**
     * update button listener
     */
    public void addUpdateListener(ActionListener updateListen){
        info.addUpdateListener(updateListen);
    }

    /**
     * Getters for Gui fields
     * 
     */

    public String getClientIdField(){
        return info.getClientIdField();
    }

    public String getClientFirstNameField(){
        return info.getClientFirstNameField();
    }

    public String getLastNameField(){
        return info.getLastNameField();
    }

    public String getAddressField(){
        return info.getAddressField();
    }

    public String getPostalField(){
        return info.getPostalField();
    }

    public String getPhoneNumberField(){
        return info.getPhoneNumberField();
    }

    public String getClientType(){
        return info.getClientType();
    }

    /**
     * Setters for gui Fields
     */

    public void setClientIdField(String t){
        info.setClientIdField(t);
    }

    public void setClientFirstNameField(String t){
        info.setClientFirstNameField(t);
    }

    public void setLastNameField(String t){
        info.setLastNameField(t);
    }

    public void setAddressField(String t){
        info.setAddressField(t);
    }

    public void setPostalField(String t){
        info.setPostalField(t);
    }

    public void setPhoneNumberField(String t){
        info.setPhoneNumberField(t);
    }

    }









