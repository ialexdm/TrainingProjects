package server.interfaces;

import server.handler.ClientHandler;

import java.sql.SQLException;

public interface Server {
    int PORT = 8189;

    boolean isNickBusy(String nick);

    void broadcastMessage(String message);

    void subscribe(ClientHandler clientHandler);

    void unsubscribe(ClientHandler clientHandler);

    AuthenticationService getAuthenticationService();

    void sendMessageToClient(ClientHandler from, String to, String message);

    void broadcastClientList();

    void executeCommand(ClientHandler from, String command) throws SQLException;
}
