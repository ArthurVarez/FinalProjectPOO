package com.FinalProject.Scrapper;

import com.FinalProject.WebObject.*;
import com.FinalProject.Logger.*;

import java.util.*;

public class ImgurScrapper extends AWebScrapper {
    private String _data = null;
    public ImgurScrapper(String data, long maxCount, ILogger logger) {
        super(maxCount, logger);

        _data="https://i.imgur.com/XOl8wKM.jpg";
    }

    public String get_data() {
        return _data;
    }

    /**
     * Load the *count* next IScrapped in *list*
     * Return true if there is still IWebObject to load
     */
    public boolean load(List<IWebObject> list, long count) {
        boolean ret = !(_count >= _maxCount);
        count = updateCount(count);
        for (long i = 0; i < count; ++i)
            list.add(new ImageWebObject(_data));
            //todo changer 0 par l'index de lindex de la liste _data
        return ret;
    }
}