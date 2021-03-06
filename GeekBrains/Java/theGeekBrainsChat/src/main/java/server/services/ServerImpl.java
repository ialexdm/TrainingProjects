package server.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.handler.ClientHandler;
import server.interfaces.AuthenticationService;
import server.interfaces.Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ServerImpl implements Server {


    private List<ClientHandler> clients;
    private AuthenticationService authenticationService;
    public static final Logger LOGGER = LogManager.getLogger(ServerImpl.class);

    public ServerImpl(){
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            authenticationService = new AuthenticationServiceImpl();
            authenticationService.start();
            clients = new LinkedList<>();
            while (true){
                LOGGER.info("Wait join clients");
                Socket socket = serverSocket.accept();
                LOGGER.info("Client join");
                new ClientHandler(this, socket);
            }
        }catch (IOException e){

            LOGGER.error("Troubles in server");
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
        LOGGER.info("From " + message);
        for (ClientHandler c : clients){
            if (!message.startsWith(c.getNick()) && !message.startsWith("/")){
                c.sendMessage(message);
            }
        }
    }

    public void executeCommand(ClientHandler from ,String command) throws SQLException {
        LOGGER.info("command from " + from.getNick() + " " + command );
        String[] commandData = command.split("\\s");
        if (command.startsWith("/clients")) {
            broadcastClientList();
            return;
        }
        if (command.startsWith("/exit")) {
            from.setConnection(false);
            LOGGER.info("Client out of chat");
            return;
        } else if (commandData[0].equals("/w") && commandData.length > 2) {
            StringBuilder message = new StringBuilder();
            for (int i = 2; i < commandData.length; i++) {
                message.append(commandData[i]).append(" ");
            }
            sendMessageToClient(from, commandData[1], "" + message);
            return;
        } else if (commandData[0].equals("/cnick") && commandData.length > 1) {
            changeNick(from, commandData);
            return;

            }
            from.sendMessage("Server: Unknown command");
            LOGGER.warn("Unknown command from " + from.getNick());
        }

    public synchronized void changeNick(ClientHandler from, String[] commandData) throws SQLException {
        broadcastMessage("User " + from.getNick() + " change Nick "+ " to " + commandData[1]);
        LOGGER.info("User " + from.getNick() + " change Nick "+ " to " + commandData[1]);
        authenticationService.changeNick(from.getNick(), commandData[1]);
        from.setNick(commandData[1]);
    }

    @Override
    public synchronized void sendMessageToClient(ClientHandler from, String to, String message) {
        for (ClientHandler c : clients){
            if (c.getNick().equals(to)){
                c.sendMessage("[WHISPER] from " + from.getNick() + " to you: " + message);
                from.sendMessage("[WHISPER] from you to " + c.getNick() + ": " + message );
                LOGGER.info("Sending whisper message from " + from.getNick() + " to " + to);
                return;
            }
        }from.sendMessage("Server: invalid nick");
        LOGGER.warn("invalid nick");
    }

    @Override
    public synchronized void broadcastClientList() {
        StringBuilder clientsList = new StringBuilder("/clients");
        for (ClientHandler c : clients){
            clientsList.append(c.getNick() + " ");
        }
        LOGGER.info("broadcast client list...");
        broadcastMessage(clientsList.toString());
    }
//new method is sendMessageToClient
    private void sendWhisperMessage(String[] commandData){
        StringBuilder whisperMessage = new StringBuilder();
        for (int i = 3; i<commandData.length; i++){
            whisperMessage.append(commandData[i]).append(" ");
        }
        for (ClientHandler c : clients) {
            if (commandData[2].equals(c.getNick())) {
                c.sendMessage("[WHISPER] " + commandData[0] + " " + "to you: " + whisperMessage);
            }
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
