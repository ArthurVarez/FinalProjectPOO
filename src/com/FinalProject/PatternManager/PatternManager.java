package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.*;
import com.FinalProject.Scrapper.*;

import java.util.*;

public class PatternManager {
    private List<IPattern> _patterns;
    private final PatternScrapperDictionnary _mapperpaterns;

    public PatternManager() {
        _patterns = Arrays.asList(
               new ImageWebObjectFactory(),
                new OneTimePattern()

        );
        _mapperpaterns = new PatternScrapperDictionnary(_patterns);
    }

    public void start() {
        _mapperpaterns.getEntries().forEach(e->
            {e.getScrapper().setCount(0);e.getPattern().start();
        });
    }
}