package com.geekbrains.chat.server;

import com.geekbrains.chat.Config;
import com.geekbrains.chat.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ServerApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(Config.getPort());
        System.out.println("Messages server started at port " + Config.getPort());
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        Connection conn = Connection.getInstance();
        conn.connect(socket);
        conn.sendMsg("Server allow connection");
    }
}
