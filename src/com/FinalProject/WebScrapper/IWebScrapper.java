package com.FinalProject.Scrapper;

import com.FinalProject.WebObject.*;
import com.FinalProject.Logger.*;

import java.util.*;

public interface IWebScrapper {

    /**
     * Load the *count* next IScrapped in *list*
     * Return true if there is still IWebObject to load
     */
    public boolean load(List<IWebObject> list, long count);

    /**
     * Load all IWebObject in *list*
     */
    public boolean load(List<IWebObject> list);

    /**
     * Set the logger
     */
    public void setLogger(ILogger logger);

    /**
     * Set max count of IWebObject to load
     */
    public boolean setMaxCount(long maxCount);

    /**
     * Set count
     * Return false if *count* is under zero or superior than maxCount
     */
    public boolean setCount(long count);

    /**
     * Return max count
     */
    public long getMaxCount();

    /**
     * Return count
     */
    public long getCount();
}