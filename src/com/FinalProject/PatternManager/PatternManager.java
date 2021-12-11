package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.ImageWebObjectFactory;
import com.FinalProject.Scrapper.*;
import com.FinalProject.Logger.*;
import com.FinalProject.WebObject.ImageWebObject;

import java.util.*;

public class PatternManager {
    private List<IPattern> _patterns;
    private final PatternScrapperDictionnary _mapperpaterns;

    public PatternManager() {
        _patterns = Arrays.asList(
               new ImageWebObjectFactory()
                , new OneTimePattern()
        
        );
        _mapperpaterns = new PatternScrapperDictionnary(_patterns);
    }

    public void start() {
        for (PatternScapperEntry entry : _mapperpaterns.getEntries()) {
            entry.getScrapper().setCount(0);
            entry.getPattern().start();
        }
    }
}