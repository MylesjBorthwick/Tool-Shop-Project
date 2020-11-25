package controller;


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
            return customerControl.receiveQuery((CustomerModel)input);
        }
        else if(input.getClass() == InventoryModel.class) {
            System.out.println("Tool");
            return inventoryControl.receiveQuery((InventoryModel)input);
        }
        return input;
    }



    public static void main(String[] args) throws Exception 
    {
        ServerMainController controlServer = new ServerMainController();
    }
}