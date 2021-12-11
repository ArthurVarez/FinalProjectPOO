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
                new OneTimePattern()
                ,new ImageWebObjectFactory()
        );
        _mapperpaterns = new PatternScrapperDictionnary(_patterns);
    }

    public void start() throws NoSuchFieldException, IllegalAccessException {
        for (PatternScapperEntry entry : _mapperpaterns.getEntries()) {
            entry.getScrapper().setCount(0);
            entry.getPattern().start();
        }
    }
}