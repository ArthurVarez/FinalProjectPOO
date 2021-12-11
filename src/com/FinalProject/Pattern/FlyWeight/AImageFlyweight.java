package com.FinalProject.Pattern.FlyWeight;

public abstract class AImageFlyweight {
    protected String base_url;

    public AImageFlyweight(String base_url) {
        this.base_url = base_url;
    }
    public abstract String getExtension();

}
