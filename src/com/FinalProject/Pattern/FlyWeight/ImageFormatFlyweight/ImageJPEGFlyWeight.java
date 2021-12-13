package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

public class ImageJPEGFlyWeight extends AImageFlyweight {
    public ImageJPEGFlyWeight(String base_url) {
        super(base_url);
    }

    public String getExtension() {
        return ".jpg";
    }
}
