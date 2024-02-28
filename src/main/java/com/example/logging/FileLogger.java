package com.example.logging;

public class FileLogger implements BaseLogger{

        @Override
        public void log(String data) {
            System.out.println("Data logged to a file: \"" + data + "\"");
        }
}