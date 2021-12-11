package com.FinalProject.Pattern;

import com.FinalProject.Pattern.Factory.ImageWebObjectFactory;
import com.FinalProject.Scrapper.*;
import com.FinalProject.WebObject.*;

import java.util.*;
import java.util.logging.Logger;

public class OneTimePattern implements IPattern {
    private static final Logger LOGGER = Logger.getLogger(ImageWebObjectFactory.class.getPackage().getName());
    private IWebScrapper _scrapper = null;

    /**
     * Start the processus of downloading
     */
    public void start() {
        long startTime = System.currentTimeMillis();
        LOGGER.info(this
                .getClass().getSimpleName()+" Started ");
        if (_scrapper != null) {
            List<IWebObject> objects = new LinkedList<IWebObject>();

            while (_scrapper.load(objects, 150)) {
                for (IWebObject obj: objects) {
                    obj.download("test/"+this.getClass().getSimpleName());
                }
                objects.clear();
            }
            long endTime = System.currentTimeMillis();
            LOGGER.info(this
                    .getClass().getSimpleName()+" took " + (endTime-startTime)+" milliseconds");
        }
    }

    /**
     * Start the processus of downloading
     */
    public void setScrapper(IWebScrapper scrapper) {
        _scrapper = scrapper;
    }
}