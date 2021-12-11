package com.FinalProject.Pattern;

import com.FinalProject.Scrapper.*;
import com.FinalProject.WebObject.*;

import java.util.*;

public class OneTimePattern implements IPattern {

    private IWebScrapper _scrapper = null;

    /**
     * Start the processus of downloading
     */
    public void start() {
        if (_scrapper != null) {
            List<IWebObject> objects = new LinkedList<IWebObject>();

            while (_scrapper.load(objects, 27)) {
                for (IWebObject obj: objects) {
                    obj.download("test/"+this.getClass().getSimpleName());
                }
                objects.clear();
            }
        }
    }

    /**
     * Start the processus of downloading
     */
    public void setScrapper(IWebScrapper scrapper) {
        _scrapper = scrapper;
    }
}