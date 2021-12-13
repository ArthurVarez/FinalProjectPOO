package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

public class ImagePNGFlyWeight extends AImageFlyweight {
    public ImagePNGFlyWeight(String base_url) {
        super(base_url);
    }

    public String getExtension() {
        return ".png";
    }
}
