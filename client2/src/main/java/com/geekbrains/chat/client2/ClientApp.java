package com.geekbrains.chat.client2;

import com.geekbrains.chat.Config;
import com.geekbrains.chat.Connection;

import java.io.IOException;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) throws IOException {
        Connection.getInstance().connect(new Socket(Config.getHost(), Config.getPort()));
    }
}
