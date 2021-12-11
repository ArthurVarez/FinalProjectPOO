package com.FinalProject.Scrapper;

import com.FinalProject.WebObject.*;
import com.FinalProject.Logger.*;

import java.util.*;

public abstract class AWebScrapper implements IWebScrapper {
    public AWebScrapper(long maxCount, ILogger logger) {
        _maxCount = maxCount;
        _logger = logger;
    }

    protected long _count = 0;
    protected long _maxCount = 0;
    protected ILogger _logger = null;

    /**
     * Update and return the remaining count
     */
    protected long updateCount(long count) {
        if (count + _count > _maxCount)
            count = _maxCount - _count;
        _count += count;
        return count;
    }

    /**
     * Load all remaining IWebObject in *list*
     */
    public boolean load(List<String> list) {
        return load(list, _maxCount - _count);
    }

    /**
     * Set the logger
     */
    public void setLogger(ILogger logger) {
        _logger = logger;
    }

    /**
     * Set max count of IWebObject to load
     * Return false if the *maxCount* is under zero or *maxCount* is lower than _count
     */
    public boolean setMaxCount(long maxCount) {
        if (maxCount < 0 || _count > maxCount )
            return false;
        _maxCount = maxCount;
        return true;
    }

    /**
     * Set max count
     * Return false if *count* is under zero or superior than maxCount
     */
    public boolean setCount(long count) {
        if (count < 0 || count > _maxCount )
            return false;
        _count = count;
        return true;
    }

    /**
     * Return max count
     */
    public long getMaxCount() {
        return _maxCount;
    }

    /**
     * Return count
     */
    public long getCount() {
        return _count;
    }
}