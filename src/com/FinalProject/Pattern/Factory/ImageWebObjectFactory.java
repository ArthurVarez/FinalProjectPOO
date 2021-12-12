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
    private final List<ImageWebObject> objects = new ArrayList<>();
    private IWebScrapper _scrapper;

    /**
     * Saving the images in a specific folder
     */
    @Override
    public void Download() {
        Load();
        for (IWebObject obj: objects) {
            obj.download("test/"+this.getClass().getSimpleName());
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
        for (String data: dataList) {
            objects.add(CreateObject(data));
        }

    }
}
