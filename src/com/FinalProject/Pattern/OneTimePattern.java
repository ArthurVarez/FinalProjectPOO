package com.FinalProject.Pattern;

import com.FinalProject.Pattern.Factory.ImageWebObjectFactory;
import com.FinalProject.Scrapper.*;
import com.FinalProject.WebObject.*;

import java.util.*;
import java.util.logging.Logger;

public class OneTimePattern implements IPattern {
    private IWebScrapper _scrapper = null;

    /**
     * Start the processus of downloading
     */
    public void start() {
        }

    /**
     * Start the processus of downloading
     */
    public void setScrapper(IWebScrapper scrapper) {
        _scrapper = scrapper;
    }
}