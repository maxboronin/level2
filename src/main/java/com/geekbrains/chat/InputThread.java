package com.geekbrains.chat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class InputThread implements Runnable {
    private Socket socket;

    public InputThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner input = new Scanner(socket.getInputStream());
            String msg = "";
            while (true){
                if(input.hasNext()){
                    msg = input.nextLine();
                    if(msg.equals("exit")){
                        Connection.getInstance().disconnect();
                    }
                    System.out.println(msg);
                }
            }
        } catch (IOException exception){
            System.out.println(exception);
        }
    }
}
