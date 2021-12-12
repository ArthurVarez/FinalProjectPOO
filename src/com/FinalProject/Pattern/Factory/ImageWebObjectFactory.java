package com.FinalProject.Pattern.Factory;
import com.FinalProject.Pattern.IPattern;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.*;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;


public class ImageWebObjectFactory implements AFactory<ImageWebObject>{
    private List<ImageWebObject> objects = new ArrayList();
    private IWebScrapper _scrapper;

    @Override
    public void Download() {
        Load();
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

    @Override
    public void Load() {
        List<String> dataList = new LinkedList<String>();

        _scrapper.load(dataList);
        for (String data: dataList) {
            objects.add(CreateObject(data));
        }

    }
}
