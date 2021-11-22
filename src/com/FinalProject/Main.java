package com.FinalProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        FileInputStream ip = new FileInputStream("config.properties");
        properties.load(ip);
	    System.out.println(properties.getProperty("Client_id"));
        System.out.println(properties.getProperty("Client_secret"));


    }
}
