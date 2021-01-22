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
            clients = new LinkedList<>();
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
            if (!message.startsWith(c.getNick()) && !message.startsWith("/")){
                c.sendMessage(message);
            }
        }
    }

    public void executeCommand(ClientHandler from ,String command) {
        String[] commandData = command.split("\\s");
        if (command.startsWith("/clients")){
            broadcastClientList();
            return;
        }if (command.startsWith("/exit")){
            from.setConnection(false);
            System.out.println("Client out of chat");
            return;
        }
        else if (commandData[0].equals("/w") && commandData.length > 2){
            StringBuilder message = new StringBuilder();
            for (int i = 2; i< commandData.length; i++){
                message.append(commandData[i]).append(" ");
                sendMessageToClient(from, commandData[1], "" + message);
                return;
            }
        }
        from.sendMessage("Server: Unknown command");
        System.out.println("Unknown command");
    }

    @Override
    public synchronized void sendMessageToClient(ClientHandler from, String to, String message) {
        for (ClientHandler c : clients){
            if (c.getNick().equals(to)){
                c.sendMessage("[WHISPER] from " + from.getNick() + " to you: " + message);
                from.sendMessage("[WHISPER] from you to " + c.getNick() + ": " + message );
                return;
            }
        }
    }

    @Override
    public synchronized void broadcastClientList() {
        StringBuilder clientsList = new StringBuilder("/clients");
        for (ClientHandler c : clients){
            clientsList.append(c.getNick() + " ");
        }
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
