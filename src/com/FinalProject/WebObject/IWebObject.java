package com.FinalProject.WebObject;

import java.util.*;

public interface IWebObject {
    /**
     * Download the IWebObject in the *directory* and will have *fileName* as name
     */
    public void download(String directory, String fileName);

    /**
     * Download the IWebObject in the *directory* with a generated name
     */
    public void download(String directory);
}