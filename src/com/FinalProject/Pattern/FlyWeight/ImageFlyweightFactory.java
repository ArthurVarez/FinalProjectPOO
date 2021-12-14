package com.FinalProject.Pattern.FlyWeight;

import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.*;
import com.FinalProject.Pattern.*;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.IWebObject;
import com.FinalProject.WebObject.ImageWebObject;
import java.util.*;

/**
 * Factory to create Flyweight in order to instantiate concrete object and then to save the images
 * Here the goal is to share similar data in order to reduce memory usage
 */

public class ImageFlyweightFactory implements IPattern {

    public List<AImageFlyweight> _flyweights = new LinkedList<>();
    public String _baseUrl;
    private IWebScrapper _scrapper;

    public ImageFlyweightFactory(String baseUrl) {
        this._baseUrl = baseUrl;
    }
    /**
     * Creating to different flyweight for processing the web data
     */
    @Override
    public void Load()
    {
        List<String> urls = new LinkedList<>();
        _scrapper.load(urls);

        while (!urls.isEmpty()) {
            AImageFlyweight image = getLightImage(urls.remove(0));
            if (image != null)
                _flyweights.add(image);
        }
        urls = null;
    }

    /**
     * Method to create concrete object depending on the format founded
     */
    @Override
    public void Download() {
        while (!_flyweights.isEmpty()) {
            AImageFlyweight lightImage = _flyweights.remove(0);
            String url = lightImage.getImageUrl(_baseUrl);
            IWebObject image = new ImageWebObject(url);

            image.download("test/" + this.getClass().getSimpleName());
        }
        _flyweights = null;
    }
    @Override
    public void setScrapper(IWebScrapper scrapper) {
        this._scrapper = scrapper;
    }

    /**
     * Create an AImageFlyweight by the url of the image
     */
    public AImageFlyweight getLightImage(String url)
    {
        String[] splitedUrl = url.substring(url.lastIndexOf('/') + 1).trim().split("\\.");
        switch (splitedUrl[1]) {
            case "jpg":
                return new ImageJPEGFlyWeight(splitedUrl[0]);
            case "png":
                return new ImagePNGFlyWeight(splitedUrl[0]);
            case "gif":
                return new ImageGIFFlyWeight(splitedUrl[0]);
        }
        return null;
    }

}
