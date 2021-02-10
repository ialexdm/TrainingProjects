package server.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import server.interfaces.Server;
import server.services.ServerImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {
    public static final Logger LOGGER = LogManager.getLogger(ClientHandler.class);
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
                        LOGGER.error(e.getStackTrace());
                    }finally {
                        closeConnection();
                    }
            });

        }catch (IOException e){
            LOGGER.error("Troubles with create ClientHandler");
            throw new RuntimeException("Troubles with create ClientHandler");
        }
    }
    private void authentication() throws IOException {
        executorService.execute(()-> {
            try {
                LOGGER.info("Client start authentication");
                sendMessage("Please, authenticate on Server. Send message in \"/auth login password\" format.");
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                LOGGER.error(e.getStackTrace());
            }
            if (this.nick == null || this.nick.equals("")){
                sendMessage("authentication TimeOut(120 sec)");
                LOGGER.warn("authentication TimeOut(120 sec)");
                try {
                    server.executeCommand(this,"/exit");
                } catch (SQLException throwables) {
                    LOGGER.error(throwables.getStackTrace());
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
                    LOGGER.info(str);
                    String[] dataArray = str.split("\\s");
                    String nick = null;
                    nick = server.getAuthenticationService().getNick(dataArray[1],dataArray[2]);
                    if (nick != null){
                        if (!server.isNickBusy(nick)){
                            sendMessage("/authOK " + nick);
                            LOGGER.info("authentication OK");
                            this.nick = nick;
                            server.broadcastMessage(this.nick + " join to chat");
                            server.subscribe(this);
                            return;
                        }else{
                            sendMessage("Nick is busy");
                        }
                    }else {
                        LOGGER.warn("Incorrect login or password");
                        sendMessage("Incorrect login or password");
                    }
                }
        }
    }

    public void sendMessage(String message){
        try{
            dataOutputStream.writeUTF(message);
        }catch (IOException e){
            LOGGER.error(e.getStackTrace());
        }
    }
    public void readMessage(){
        while (connection){
            try {
                String clientStr = dataInputStream.readUTF();
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
                connection = false;
                LOGGER.warn(this.getNick() + " close connection");
            } catch (SQLException trowables) {
                LOGGER.error(trowables.getStackTrace());
            }
        }
    }
    public void closeConnection(){
        try {
            sendMessage("/exit");
            LOGGER.info(this.nick + " out from chat");
            connection = false;
            server.unsubscribe(this);
            server.broadcastMessage(this.nick + " out from chat");
            socket.close();
            dataInputStream.close();
            dataOutputStream.close();

        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }

    }




}
