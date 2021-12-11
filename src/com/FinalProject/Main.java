package com.FinalProject;

import com.FinalProject.PatternManager.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
/*
        Properties properties = new Properties();
        FileInputStream ip = new FileInputStream("config.properties");
        properties.load(ip);
	    System.out.println(properties.getProperty("Client_id"));
        System.out.println(properties.getProperty("Client_secret"));

 */

        PatternManager manager = new PatternManager();

        manager.start();




    }
}
