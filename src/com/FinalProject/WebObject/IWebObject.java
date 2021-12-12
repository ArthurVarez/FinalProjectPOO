package com.FinalProject.WebObject;


/**
 * Interface defining what Concrete web objects should implement
 */

public interface IWebObject {
    /**
     * Download the IWebObject in the *directory* and will have *fileName* as name
     */
    void download(String directory, String fileName);

    /**
     * Download the IWebObject in the *directory* with a generated name
     */
    void download(String directory);
}