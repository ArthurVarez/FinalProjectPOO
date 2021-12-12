package com.FinalProject.Scrapper;

import com.FinalProject.WebObject.*;
import com.FinalProject.Logger.*;

import java.util.*;

/**
 * Interface to specify what scrapper should use
 */
public interface IWebScrapper {

    /**
     * Load the *count* next IScrapped in *list*
     * Return true if there is still IWebObject to load
     */
    boolean load(List<String> list, long count);

    /**
     * Load all IWebObject in *list*
     */
    boolean load(List<String> list);


    /**
     * Set the logger
     */
    //todo the following methods need to be deleted ?
    void setLogger(ILogger logger);

    /**
     * Set max count of IWebObject to load
     */
    boolean setMaxCount(long maxCount);

    /**
     * Set count
     * Return false if *count* is under zero or superior to maxCount
     */
    boolean setCount(long count);

    /**
     * Return max count
     */
    long getMaxCount();

    /**
     * Return count
     */
    long getCount();
}