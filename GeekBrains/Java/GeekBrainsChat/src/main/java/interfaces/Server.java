package interfaces;

import handler.ClientHandler;

public interface Server {
    int PORT = 8189;

    boolean isNickBusy(String nick);

    void broadcastMessage(String message);

    void subscribe(ClientHandler clientHandler);

    void unsubscribe(ClientHandler clientHandler);

    public AuthenticationService getAuthenticationService();
}
