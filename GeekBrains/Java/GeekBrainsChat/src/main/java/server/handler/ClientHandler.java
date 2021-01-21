package server.handler;

import server.interfaces.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;

    private String nick;

    public String getNick(){
        return nick;
    }
    public ClientHandler(Server server, Socket socket){


        try {
            this.server = server;
            this.socket = socket;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.nick = "";
            new Thread(() -> {
                    try {
                        authentication();
                        readMessage();
                    }catch (IOException e){
                        e.printStackTrace();
                    }finally {
                        closeConnection();
                    }
            }).start();

        }catch (IOException e){
            throw new RuntimeException("Troubles with create ClientHandler");
        }
    }

    private void authentication() throws IOException {
        while (true){
            String str = dataInputStream.readUTF();
            if (str.startsWith("/auth")){
                String[] dataArray = str.split("\\s");
                String nick = server.getAuthenticationService().getNick(dataArray[1],dataArray[2]);
                if (nick != null){
                    if (!server.isNickBusy(nick)){
                        sendMessage("/authOK" + nick);
                        this.nick = nick;
                        server.broadcastMessage(this.nick + " join to chat");
                        server.subscribe(this);
                        return;
                    }else{
                        sendMessage("You already have been authenticate");
                        return;
                    }
                }else {
                    sendMessage("Incorrect login or password");
                }
            }
        }
    }

    public void sendMessage(String message){
        try{
            dataOutputStream.writeUTF(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readMessage(){
        while (true){
            try {
                String clientStr = dataInputStream.readUTF();
                System.out.println("From " + this.nick + ": " + clientStr);

                if (clientStr.startsWith("/")){
                    server.executeCommand(this.nick + " " + clientStr);
                    if (clientStr.equals("/exit)"))
                    {
                        return;
                    }
                }else{
                    server.broadcastMessage(this.nick + ": " + clientStr);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void closeConnection(){
        try {
            server.unsubscribe(this);
            server.broadcastMessage(this.nick + " out from chat");
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
