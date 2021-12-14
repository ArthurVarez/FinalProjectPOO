package com.FinalProject.Pattern.Factory;

import com.FinalProject.Scrapper.IWebScrapper;
import com.FinalProject.WebObject.*;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

/**
 * Here is a Factory to load and Save ImageWebObjects
 */
public class ImageWebObjectFactory implements AFactory<ImageWebObject>{
    private List<ImageWebObject> _objects = new LinkedList<>();
    private IWebScrapper _scrapper;

    /**
     * Saving the images in a specific folder
     */
    @Override
    public void Download() {
        while (!_objects.isEmpty()) {
            _objects.remove(0).download("test/"+this.getClass().getSimpleName());
        }
    }

    @Override
    public void setScrapper(IWebScrapper scrapper) {_scrapper=scrapper;}

    /**
     * Method having the responsibility to create clean ImageWebObject given a specified data
     */

    @Override
    public ImageWebObject CreateObject(String data) {
        return new ImageWebObject(data);
    }

    /**
     * Loading the url with the specified scrapper and creating the concrete objects belonging to this data
     */
    @Override
    public void Load() {
        List<String> dataList = new LinkedList<>();

        _scrapper.load(dataList);
        while (!dataList.isEmpty()) {
            _objects.add(CreateObject(dataList.remove(0)));
        }
        dataList.clear();
    }
}
