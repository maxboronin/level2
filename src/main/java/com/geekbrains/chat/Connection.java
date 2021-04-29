package com.geekbrains.chat;

import java.io.IOException;
import java.net.Socket;

public class Connection {
    private Thread input;
    private Thread output;
    private OutputThread out;
    private Socket socket;

    private static Connection instance;

    private Connection(){}

    public static Connection getInstance(){
        if(instance == null){
            instance = new Connection();
        }
        return instance;
    }

    public void connect(Socket socket) throws IOException {
        instance.socket = socket;

        instance.input = new Thread(new InputThread(socket));
        instance.input.start();

        instance.out = new OutputThread(socket);
        instance.output = new Thread(out);
        instance.output.start();
    }

    public void sendMsg(String msg){
        instance.out.sendMsg(msg);
    }

    public void disconnect() throws IOException {
        System.out.println("Disconnected");
        instance.out.sendMsg("exit");
        instance.socket.close();
        System.exit(1);
    }
}
