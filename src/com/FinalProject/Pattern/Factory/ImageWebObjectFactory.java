package com.FinalProject.Pattern.Factory;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.*;


import java.util.ArrayList;
import java.util.List;


public class ImageWebObjectFactory implements AFactory<ImageWebObject> {

    private List<ImageWebObject> objects = new ArrayList();
    private IWebScrapper _scrapper;

    @Override
    public void start(){
        Load(30);
        for (IWebObject obj: objects) {
            obj.download("test/"+this.getClass().getSimpleName());
        }
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
