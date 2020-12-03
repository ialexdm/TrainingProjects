package client.service;

import client.window.ChatWindow;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientService extends ChatWindow {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;

    public ClientService(){
        super();
        try{
            socket = new Socket("localhost",8189);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            setAutorized(false);
            Thread t1 = new Thread(() -> {
                try{
                    while (true){
                        String strMsg = dataInputStream.readUTF();
                        if (strMsg.equals("/authOk")){
                            setAutorized(true);
                            break;
                        }
                        super.chatArea.append(strMsg + "\n");
                    }
                    while (true){
                        String strMsg = dataInputStream.readUTF();
                        if (strMsg.equals("/exit"){
                            break;
                        }
                        super.chatArea.append(strMsg + "\n");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            });
            t1.setDaemon(true);
            t1.start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
