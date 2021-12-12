package com.FinalProject.Pattern.FlyWeight;

import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.*;
import com.FinalProject.Pattern.*;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.ImageWebObject;

import java.util.*;

public class ImageFlyweightFactory implements IPattern {

    public HashMap<ImageFormatType, AImageFlyweight> flyweights = new HashMap<>();
    public String base_url;
    private IWebScrapper _scrapper;

    public ImageFlyweightFactory(String base_url) {
        this.base_url = base_url;

    }
    @Override
    public void Load()
    {
        flyweights.put(ImageFormatType.PNG,new ImagePNGFlyWeight(base_url));
        flyweights.put(ImageFormatType.JPEG,new ImageJPEGFlyWeight(base_url));
        flyweights.put(ImageFormatType.GIF,new ImageGIFFlyWeight(base_url));
    }

    @Override
    public void Download() {

        List<String> urls = new ArrayList<>();
        _scrapper.load(urls);

        //_scrapper.load(urls);

        for (String url : urls) {
            //todo changer la boucle pour iterer sur les urls du scrapper
            // generer une method dans le scrapper qui retourne juste l'ID de l'image et l'enxtension
            // genre key-value pair

            ImageWebObject _temp = null;
            String[] splited_url = Helper_url(url);
            switch (splited_url[1]) {
                case "jpg":
                    _temp = new ImageWebObject(flyweights.get(ImageFormatType.JPEG).base_url
                            + "/" +splited_url[0]+flyweights.get(ImageFormatType.JPEG).getExtension());
                    _temp.download("test/" + this.getClass().getSimpleName());
                    _temp = null;
                    break;

                case "png":
                    _temp = new ImageWebObject(flyweights.get(ImageFormatType.PNG).base_url
                            + "/"+splited_url[0]+flyweights.get(ImageFormatType.PNG).getExtension());
                    _temp.download("test/" + this.getClass().getSimpleName());
                    _temp = null;
                    break;

                case "gif":
                    _temp = new ImageWebObject(flyweights.get(ImageFormatType.GIF).base_url
                            + "/"+splited_url[0]+flyweights.get(ImageFormatType.GIF).getExtension());
                    _temp.download("test/" + this.getClass().getSimpleName());
                    _temp = null;
                    break;

            }

        }
    }
    @Override
    public void setScrapper(IWebScrapper scrapper) {
        this._scrapper = scrapper;
    }
    public String[] Helper_url(String url)
    {
        return url.substring(url.lastIndexOf('/') + 1).trim().split("\\.");

    }

}
