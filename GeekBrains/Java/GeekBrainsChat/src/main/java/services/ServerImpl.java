package services;

import handler.ClientHandler;
import interfaces.Server;

public class ServerImpl implements Server {
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
