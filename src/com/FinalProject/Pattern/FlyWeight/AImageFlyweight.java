package com.FinalProject.Pattern.FlyWeight;

/**
 * Abstract Flyweight class that stores the base_url shared to create Flyweights and the concrete objects
 */
public abstract class AImageFlyweight {
    protected String base_url;

    public AImageFlyweight(String base_url) {
        this.base_url = base_url;
    }
    public String getImageUrl(String imageUrl) {
        return imageUrl.concat(base_url).concat(getExtension());
    }
    public abstract String getExtension();

}
