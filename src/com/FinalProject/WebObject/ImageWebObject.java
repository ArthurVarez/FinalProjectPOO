package com.FinalProject.WebObject;

import java.util.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class ImageWebObject implements IWebObject {
    public ImageWebObject(String data) {
        _data = data;
        _extension = _data.substring(_data.lastIndexOf('.') + 1).trim();
    }

    static long _count = 0;
    private String _data;
    private String _extension;

    /**
     * Download the IWebObject in the *directory* and will have *fileName* as name
     */
    public void download(String directory, String fileName) {
        String filePath = directory + '/' + fileName;
        BufferedImage image = null;

        File file = new File(filePath);
        try {
            if (!file.createNewFile()) {
                System.out.println("File [" + file.getAbsolutePath() + "] already exists");
                return;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating file [" + file.getAbsolutePath() + ']');
            e.printStackTrace();
        }
        try {
            URL url = new URL(_data);

            image = ImageIO.read(url);
            ImageIO.write(image, _extension, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Download the IWebObject in the *directory* with a generated name
     */
    public void download(String directory) {
        download(directory, "image_" + (++_count) + '.' + _extension);
    }
}