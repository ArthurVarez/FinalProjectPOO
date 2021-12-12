package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

/**
 * Flyweight used to create objects of PNG format
 */
public class ImagePNGFlyWeight extends AImageFlyweight {
    private String extension;
    public ImagePNGFlyWeight(String base_url) {
        super(base_url);
        this.extension=".png";
    }

    public String getExtension() {
        return extension;
    }
}
