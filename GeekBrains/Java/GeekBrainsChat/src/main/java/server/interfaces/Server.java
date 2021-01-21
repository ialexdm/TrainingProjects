package server.interfaces;

import server.handler.ClientHandler;

public interface Server {
    int PORT = 8189;

    boolean isNickBusy(String nick);

    void broadcastMessage(String message);

    void subscribe(ClientHandler clientHandler);

    void unsubscribe(ClientHandler clientHandler);

    AuthenticationService getAuthenticationService();

    void executeCommand(String s);
}
