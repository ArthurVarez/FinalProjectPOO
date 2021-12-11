package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

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
