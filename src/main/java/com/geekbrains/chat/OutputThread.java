package com.geekbrains.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class OutputThread implements Runnable {
    private Socket socket;
    private PrintWriter output;

    public OutputThread(Socket socket) throws IOException {
        this.socket = socket;
        output = new PrintWriter(socket.getOutputStream());
    }


    @Override
    public void run() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            String msg;
            while (true) {
                msg = buffer.readLine();
                if(msg.equals("exit")){
                    Connection.getInstance().disconnect();
                }else{
                    sendMsg(msg);
                }
            }
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }

    public void sendMsg(String msg){
        output.println(msg);
        output.flush();
    }
}
