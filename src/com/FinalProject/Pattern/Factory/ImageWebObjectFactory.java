package com.FinalProject.Pattern.Factory;
import com.FinalProject.Pattern.IPattern;
import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.*;

import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;


public class ImageWebObjectFactory implements AFactory<ImageWebObject>{
    private List<ImageWebObject> _objects = new LinkedList<>();
    private IWebScrapper _scrapper;

    @Override
    public void Download() {
        while (!_objects.isEmpty()) {
            _objects.remove(0).download("test/"+this.getClass().getSimpleName());
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
        while (!dataList.isEmpty()) {
            _objects.add(CreateObject(dataList.remove(0)));
        }
        dataList.clear();
    }
}
