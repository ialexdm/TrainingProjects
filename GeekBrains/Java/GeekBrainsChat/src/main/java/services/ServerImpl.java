package services;

import handler.ClientHandler;
import interfaces.AuthenticationService;
import interfaces.Server;

import java.util.List;

public class ServerImpl implements Server {

    private List<ClientHandler> clients;
    private AuthenticationService authenticationService;

    public boolean isNickBusy(String nick) {
        return false;
    }

    public synchronized void broadcastMessage(String message) {

    }

    public synchronized void subscribe(ClientHandler clientHandler) {

    }

    public synchronized void unsubscribe(ClientHandler clientHandler) {

    }
}
