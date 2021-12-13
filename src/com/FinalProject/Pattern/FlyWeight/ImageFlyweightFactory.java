package com.FinalProject.Pattern.FlyWeight;

import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.*;
import com.FinalProject.Pattern.*;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.IWebObject;
import com.FinalProject.WebObject.ImageWebObject;

import java.util.*;

public class ImageFlyweightFactory implements IPattern {

    public List<AImageFlyweight> _flyweights = new LinkedList<>();
    public String _baseUrl;
    private IWebScrapper _scrapper;

    public ImageFlyweightFactory(String baseUrl) {
        this._baseUrl = baseUrl;

    }
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

    @Override
    public void Download() {

        //_scrapper.load(urls);
        while (!_flyweights.isEmpty()) {
            AImageFlyweight lightImage = _flyweights.remove(0);
            String url = lightImage.getImageUrl(_baseUrl);
            IWebObject image = new ImageWebObject(url);

            image.download("test/" + this.getClass().getSimpleName());
        }
/*        for (String url : _urls) {
            //todo changer la boucle pour iterer sur les urls du scrapper
            // generer une method dans le scrapper qui retourne juste l'ID de l'image et l'enxtension
            // genre key-value pair

            ImageWebObject _temp = null;
            String[] splited_url = Helper_url(url);
            switch (splited_url[1]) {
                case "jpg":
                    _temp = new ImageWebObject(_flyweights.get(ImageFormatType.JPEG).base_url
                            + "/" +splited_url[0]+_flyweights.get(ImageFormatType.JPEG).getExtension());
                    _temp.download("test/" + this.getClass().getSimpleName());
                    _temp = null;
                    break;

                case "png":
                    _temp = new ImageWebObject(_flyweights.get(ImageFormatType.PNG).base_url
                            + "/"+splited_url[0]+_flyweights.get(ImageFormatType.PNG).getExtension());
                    _temp.download("test/" + this.getClass().getSimpleName());
                    _temp = null;
                    break;

                case "gif":
                    _temp = new ImageWebObject(_flyweights.get(ImageFormatType.GIF).base_url
                            + "/"+splited_url[0]+_flyweights.get(ImageFormatType.GIF).getExtension());
                    _temp.download("test/" + this.getClass().getSimpleName());
                    _temp = null;
                    break;

            }

        }*/
        _flyweights = null;
    }
    @Override
    public void setScrapper(IWebScrapper scrapper) {
        this._scrapper = scrapper;
    }
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
