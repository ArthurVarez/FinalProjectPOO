package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.*;
import com.FinalProject.Pattern.FlyWeight.ImageFlyweightFactory;
import com.FinalProject.Scrapper.*;
import java.util.logging.Logger;
import com.FinalProject.Logger.*;

import java.util.*;

public class PatternManager {
    private List<IPattern> _patterns;
    private final PatternScrapperDictionnary _mapperpaterns;
//    private static final Logger _logger = Logger.getLogger(PatternManager.class.getPackage().getName());
    private ILogger _logger = new FileLogger("output.txt");

    public PatternManager() {
        _patterns = Arrays.asList(
                new ImageWebObjectFactory(),
                new OneTimePattern(),
                new ImageFlyweightFactory("https://i.imgur.com")
        );
        _mapperpaterns = new PatternScrapperDictionnary(_patterns);
    }

    public void start() {
        _mapperpaterns.getEntries().forEach(e->
            {
                e.getScrapper().setCount(0);
                _logger.log("Pattern [" + e.getClass().getSimpleName() + "] Started ");
                long startTime = System.currentTimeMillis();
                e.getPattern().start();
                long endTime = System.currentTimeMillis();
                _logger.log("Pattern [" + e.getClass().getSimpleName() + "] lasted " + (endTime-startTime) + " milliseconds");
        });
    }
}