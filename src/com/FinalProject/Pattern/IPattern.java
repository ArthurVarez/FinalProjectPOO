package com.FinalProject.Pattern;

import com.FinalProject.Scrapper.*;

import java.util.*;

public interface IPattern {
    /**
     * Start the processus of downloading
     */
    public void start();

    /**
     * Start the processus of downloading
     */
    public void setScrapper(IWebScrapper scrapper);
}