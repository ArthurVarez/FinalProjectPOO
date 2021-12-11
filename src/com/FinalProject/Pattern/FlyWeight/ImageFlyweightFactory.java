package com.FinalProject.Pattern.FlyWeight;

import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.ImageFormatType;
import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.ImageGIFFlyWeight;
import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.ImageJPEGFlyWeight;
import com.FinalProject.Pattern.FlyWeight.ImageFormatFlyweight.ImagePNGFlyWeight;
import com.FinalProject.Pattern.IPattern;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.ImageWebObject;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.*;

public class ImageFlyweightFactory implements IPattern {

    public HashMap<ImageFormatType,AImageFlyweight> flyweights = new HashMap<>();
    public String base_url;
    private IWebScrapper _scrapper;




    @Override
    public void start() {
        for(int i =0;i<30;i++) {
            //todo changer la boucle pour iterer sur les urls du scrapper
            // generer une method dans le scrapper qui retourne juste l'ID de l'image et l'enxtension
            // genre key-value pair
            String middle_url = "XOl8wKM";
            String _extend = "jpg";
            ImageWebObject _temp = null;
            switch (_extend)
            {

                case "jpg":
                    _temp = new ImageWebObject(flyweights.get(ImageFormatType.JPEG).base_url
                            + "/" + middle_url + flyweights.get(ImageFormatType.JPEG).getExtension());
                    _temp.download("test/"+this.getClass().getSimpleName());
                    _temp=null;

                case "png":
                    _temp = new ImageWebObject(flyweights.get(ImageFormatType.PNG).base_url
                            + "/" + middle_url + flyweights.get(ImageFormatType.PNG).getExtension());
                    _temp.download("test/"+this.getClass().getSimpleName());
                    _temp=null;

                case "gif":
                    _temp = new ImageWebObject(flyweights.get(ImageFormatType.GIF).base_url
                            + "/" + middle_url + flyweights.get(ImageFormatType.GIF).getExtension());
                    _temp.download("test/"+this.getClass().getSimpleName());
                    _temp=null;
            }

        }
    }


    @Override
    public void setScrapper(IWebScrapper scrapper) {
        this._scrapper=scrapper;
        this.base_url = "https://i.imgur.com/";
        flyweights.put(ImageFormatType.PNG,new ImagePNGFlyWeight(base_url));
        flyweights.put(ImageFormatType.JPEG,new ImageJPEGFlyWeight(base_url));
        flyweights.put(ImageFormatType.GIF,new ImageGIFFlyWeight(base_url));

    }
}
