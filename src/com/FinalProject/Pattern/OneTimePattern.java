package com.FinalProject.Pattern;


import com.FinalProject.Scrapper.*;
import com.FinalProject.WebObject.*;
import java.util.*;

/**
 * This pattern is not a pattern, it's just a lazy loading and downloading implementation to show the impacts
 * of the other patterns
 */
public class OneTimePattern implements IPattern {
    private IWebScrapper _scrapper = null;


    @Override
    public void Load() {

    }

    @Override
    public void Download() {

    }

    /**
     * Start the processes of downloading
     */
    public void setScrapper(IWebScrapper scrapper) {
        _scrapper = scrapper;
    }
}