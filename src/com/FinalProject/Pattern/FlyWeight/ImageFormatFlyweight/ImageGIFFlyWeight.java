package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

/**
 * Flyweight used to create objects of GIF format
 */
public class ImageGIFFlyWeight extends AImageFlyweight {
    private String extension;
    public ImageGIFFlyWeight(String base_url) {
        super(base_url);
        this.extension=".gif";
    }

    public String getExtension() {
        return extension;
    }
}
