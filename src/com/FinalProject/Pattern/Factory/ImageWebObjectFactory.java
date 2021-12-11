package com.FinalProject.Pattern.Factory;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.*;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class ImageWebObjectFactory implements AFactory<ImageWebObject> {
    private static final Logger LOGGER = Logger.getLogger(ImageWebObjectFactory.class.getPackage().getName());
    private List<ImageWebObject> objects = new ArrayList();
    private IWebScrapper _scrapper;

    @Override
    public void start(){
        long startTime = System.currentTimeMillis();
        LOGGER.info(this
                    .getClass().getSimpleName()+" Started ");
        Load(30);
        for (IWebObject obj: objects) {
            obj.download("test/"+this.getClass().getSimpleName());
        }
        long endTime = System.currentTimeMillis();
        LOGGER.info(this
                .getClass().getSimpleName()+" took " + (endTime-startTime)+" milliseconds");
    }

    @Override
    public void setScrapper(IWebScrapper scrapper) {_scrapper=scrapper;}


    @Override
    public ImageWebObject CreateObject(String data) {
        return new ImageWebObject(data);
    }
    public void Load(int n) {
        for(int i =0;i<n;i++)
        {
            objects.add(CreateObject(_scrapper.get_data()));
        }

    }
}
