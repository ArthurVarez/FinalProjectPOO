package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

/**
 * Flyweight used to create objects of JPEG format
 */
public class ImageJPEGFlyWeight extends AImageFlyweight {
    private String extension;
    public ImageJPEGFlyWeight(String base_url) {
        super(base_url);
        this.extension=".jpg";
    }

    public String getExtension() {
        return extension;
    }
}
