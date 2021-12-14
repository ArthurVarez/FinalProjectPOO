package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

/**
 * Flyweight used to create objects of JPEG format
 */
public class ImageJPEGFlyWeight extends AImageFlyweight {
    public ImageJPEGFlyWeight(String base_url) {
        super(base_url);
    }

    public String getExtension() {
        return ".jpg";
    }
}
