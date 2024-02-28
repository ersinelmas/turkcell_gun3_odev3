package com.example.logging;

public class ConsoleLogger implements BaseLogger{
    @Override
    public void log(String data) {
        System.out.println("Data logged to console: \"" + data + "\"");
    }
}