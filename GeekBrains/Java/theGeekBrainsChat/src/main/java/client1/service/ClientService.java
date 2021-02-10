package client1.service;

import client.window.ChatWindow;

import java.io.*;
import java.net.Socket;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

public class ClientService extends ChatWindow {

    private Socket socket;
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private File log;


    public ClientService(){

        super();
        try{
            log = new File("log1.txt");
            logWrite("...starting Client App");
            logRead();
            socket = new Socket("localhost",8189);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String str;

            Thread t1 = new Thread(() -> {
                try{
                    while (true){
                        String strMsg = dataInputStream.readUTF();
                        if (strMsg.startsWith("/authOk")){
                            break;
                        }
                        else if (strMsg.startsWith("/exit")){
                            super.chatArea.append("Close connection. You out of chat\n");
                            logWrite("Close connection. You out of chat\n");
                            return;
                        }
                        super.chatArea.append(strMsg + "\n");
                        logWrite(strMsg + "\n");
                    }
                    while (true){
                        String strMsg = dataInputStream.readUTF();
                        if (strMsg.startsWith("/exit")){
                            super.chatArea.append("Close connection. You out of chat\n");
                            logWrite("Close connection. You out of chat\n");
                            return;
                        }
                        super.chatArea.append(strMsg + "\n");
                        logWrite(strMsg + "\n");
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
    @Override
    protected synchronized void sendMessage(){
        if (!messageField.getText().isEmpty()){
            try {
                dataOutputStream.writeUTF(messageField.getText());

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                logWrite("I am: " + messageField.getText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            super.sendMessage();

        }

    }
    private synchronized void logWrite(String str) throws IOException {
        try (BufferedWriter logWriter = new BufferedWriter(new FileWriter(log, true))) {
                logWriter.write(str+"\n");
        }
    }
    private synchronized void logRead() throws IOException {
        final int QTY_LOG_STRINGS = 100;
        String str;
        int count = 0;
        List<String> logs = new ArrayList<>();

        try(BufferedReader logReader = new BufferedReader(new FileReader(log))){
            while ((str = logReader.readLine()) != null) {
              if (count > QTY_LOG_STRINGS) {
                  logs.remove(0);
              }
                logs.add(str);
                count++;

            }
        }
        for (int i = 0; i < logs.size(); i++) {
            super.chatArea.append(logs.get(i)+"\n");
        }

    }

}
