package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

public class ImageGIFFlyWeight extends AImageFlyweight {
    public ImageGIFFlyWeight(String base_url) {
        super(base_url);
    }

    public String getExtension() {
        return ".gif";
    }
}
