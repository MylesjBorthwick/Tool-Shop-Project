package controller;
import server.Server;

/**
 * This class starts the server and backend functions. It will receives server objects and 
 * sorts them to the proper backend controller (between CustomerModel and InventoryModel)
 * @author Myles Borthwick
 * @author Ken Loughery
 * @since Nov, 2020
 */


public class ServerMainController 
{
    private Server server;
    private ClientMainController customerControl;
    private InventoryMainController inventoryControl;
    
    
    /**
     * constructor that initializes a new server, the two backend controllers, and begins the 
     * server operations
     */
    public ServerMainController(){
        customerControl = new ClientMainController();
        inventoryControl = new InventoryMainController();
        server = new Server(8099, this);
        server.runServer();
        server.disconnect();
    }

    /**
     * Passes the serial object from the server socket to the appropriate backend controller, 
     * if the input object is not of type customerModel nor inventoryModel it returns the object back 
     * to the client socket
     * @param input object that will be sent to the appropriate backend, this object contains the query for the backend to interpret
     * @return the object that has had its query answered by the backend controllers
     */
    public synchronized Object passSerial(Object input){
        if(input.getClass() == CustomerModel.class){
            return customerControl.receiveQuery((CustomerModel)input);
        }
        else if(input.getClass() == InventoryModel.class) {
            return inventoryControl.receiveQuery((InventoryModel)input);
        }
        return input;
    }



    public static void main(String[] args) throws Exception 
    {
        ServerMainController controlServer = new ServerMainController();
    }
}