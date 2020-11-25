package controller;

import java.io.Serializable;

import server.Server;

public class ServerMainController 
{
    private Server server;
    private ClientMainController customerControl;
    private InventoryMainController inventoryControl;
    
    

    public ServerMainController(){
        customerControl = new ClientMainController();
        inventoryControl = new InventoryMainController();
        server = new Server(8099, this);
        server.runServer();
        server.disconnect();
    }

    public Object passSerial(Object input){
        if(input.getClass() == CustomerModel.class){
            System.out.println("Customer");
            
        }
        else{
            System.out.println("Tool");
        }
        return input;
    }



    public static void main(String[] args) throws Exception 
    {
        ServerMainController controlServer = new ServerMainController();
    }
}