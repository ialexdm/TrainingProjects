package server.services;

import server.handler.ClientHandler;
import server.interfaces.AuthenticationService;
import server.interfaces.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class ServerImpl implements Server {

    private List<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public ServerImpl(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            authenticationService = new AuthenticationServiceImpl();
            authenticationService.start();
            clients = new LinkedList();
            while (true){
                System.out.println("Wait join clients");
                Socket socket = serverSocket.accept();
                System.out.println("Client join");
                new ClientHandler(this, socket);
            }
        }catch (IOException e){
            System.out.println("Troubles in server");
        }
        finally {
            if (authenticationService != null){
                authenticationService.stop();
            }
        }

    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler c : clients){
            if(c.getNick().equals(nick) && c.getNick() != null){
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients){
            c.sendMessage(message);
        }
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }
}
