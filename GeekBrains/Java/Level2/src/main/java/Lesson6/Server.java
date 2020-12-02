package Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    static Scanner scanner = new Scanner(System.in);
    static DataOutputStream out;
    static DataInputStream in;
        public static void main(String[] args) {
            Socket socket = null;
            try {
                ServerSocket serverSocket = new ServerSocket(8189);
                System.out.println("Сервер запущен, ожидаем подключения...");
                socket = serverSocket.accept();
                System.out.println("Клиент подключился");
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            sendMessage();
                        }
                    }).start();
                    String str = in.readUTF();
                    if (str.equals("/end")) {
                        break;
                    }
                    out.writeUTF("Клиент: " + str);
                    System.out.println("Клиент: " + str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

public static synchronized void  sendMessage() {
    while (true) {
        String msg = scanner.nextLine();
        if (!msg.isEmpty()) {
            try {
                System.out.println("Сервер: "+ msg);
                out.writeUTF("Сервер: "+ msg);
                msg = "";
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Ошибка отправки сообщения");
            }
        }
    }
}
}

