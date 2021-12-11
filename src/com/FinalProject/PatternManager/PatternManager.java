package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.*;
import com.FinalProject.Scrapper.*;
import java.util.logging.Logger;

import java.util.*;

public class PatternManager {
    private List<IPattern> _patterns;
    private final PatternScrapperDictionnary _mapperpaterns;
    private static final Logger _logger = Logger.getLogger(PatternManager.class.getPackage().getName());

    public PatternManager() {
        _patterns = Arrays.asList(
                new ImageWebObjectFactory(),
                new OneTimePattern()
        );
        _mapperpaterns = new PatternScrapperDictionnary(_patterns);
    }

    public void start() {
        _mapperpaterns.getEntries().forEach(e->
            {
                e.getScrapper().setCount(0);
                long startTime = System.currentTimeMillis();
                _logger.info(this.getClass().getSimpleName() + " Started ");
                e.getPattern().start();
                long endTime = System.currentTimeMillis();
                _logger.info(e.getClass().getSimpleName()+" took " + (endTime-startTime) + " milliseconds");
        });
    }
}