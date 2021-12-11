package com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight;

import com.FinalProject.Pattern.FlyWeight.AImageFlyweight;

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
