package server.handler;

import server.interfaces.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {
    private final Socket socket;
    private final Server server;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private boolean connection;

    public void setNick(String nick) {
        this.nick = nick;
    }

    private String nick;
    public ExecutorService executorService;
    public String getNick(){
        return nick;
    }
    public void setConnection(boolean connection) {
        this.connection = connection;
    }
    public ClientHandler(Server server, Socket socket){


        try {
            this.executorService = Executors.newCachedThreadPool();
            this.server = server;
            this.socket = socket;
            this.dataInputStream = new DataInputStream(socket.getInputStream());
            this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
            this.nick = "";
            connection = true;
            executorService.execute(() -> {
                    try {
                        authentication();
                        readMessage();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        closeConnection();
                    }
            });

        }catch (IOException e){
            throw new RuntimeException("Troubles with create ClientHandler");
        }
    }
    private void authentication() throws IOException {
        executorService.execute(()-> {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.nick == null || this.nick.equals("")){
                sendMessage("authentication TimeOut(120 sec)");
                try {
                    server.executeCommand(this,"/exit");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                sendMessage("/exit");
                connection = false;
                return;
            }
        });
        while (connection){
                String str = null;
                str = dataInputStream.readUTF();
                if (str.startsWith("/auth") && connection){
                    String[] dataArray = str.split("\\s");
                    String nick = null;
                    try {
                        nick = server.getAuthenticationService().getNick(dataArray[1],dataArray[2]);
                    } catch (SQLException t) {
                        t.printStackTrace();
                    }
                    if (nick != null){
                        if (!server.isNickBusy(nick)){
                            sendMessage("/authOK " + nick);
                            this.nick = nick;
                            server.broadcastMessage(this.nick + " join to chat");
                            server.subscribe(this);
                            return;
                        }else{
                            sendMessage("Nick is busy");
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
        while (connection){
            try {
                String clientStr = dataInputStream.readUTF();
                System.out.println("From " + this.nick + ": " + clientStr);
                if (clientStr.startsWith("/")){
                    server.executeCommand(this, clientStr);
                }
                else if (clientStr.startsWith("/exit")){
                    connection = false;
                }
                else{
                    server.broadcastMessage(this.nick + ": " + clientStr);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
    public void closeConnection(){
        try {
            sendMessage("/exit");
            connection = false;
            server.unsubscribe(this);
            server.broadcastMessage(this.nick + " out from chat");
            socket.close();
            dataInputStream.close();
            dataOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
