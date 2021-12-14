package com.FinalProject.Pattern;

import com.FinalProject.Scrapper.*;

/**
 * Interface for the design patterns that create objects
 */
public interface IPattern {
    /**
     * Load the data and construct Design Pattern behaviour
     */
    void Load();
    /**
     * Save the object (images) in the folder designed
     */
    void Download();

    /**
     * Set the scrapper the pattern used
     */
    void setScrapper(IWebScrapper scrapper);

}