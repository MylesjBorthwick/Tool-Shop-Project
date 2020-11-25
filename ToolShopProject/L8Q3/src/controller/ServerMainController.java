package controller;

import server.Server;

public class ServerMainController 
{
    private Server server;
    
    

    public ServerMainController(){
        server = new Server(8099, this);
        server.runServer();
        server.disconnect();
    }



    public static void main(String[] args) throws Exception 
    {
        ServerMainController controlServer = new ServerMainController();
    }
}