package com.geekbrains.chat;

public class Config {
    private static final int port = 7071;
    private static final String host = "localhost";

    public static int getPort() {
        return port;
    }

    public static String getHost() {
        return host;
    }
}
