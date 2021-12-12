package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.*;
import com.FinalProject.Performance.PerformanceCalculator;
import com.FinalProject.Pattern.FlyWeight.ImageFlyweightFactory;
import com.FinalProject.Performance.PerformanceCalculator;
import com.FinalProject.Scrapper.*;
import java.util.logging.Logger;
import com.FinalProject.Logger.*;

import java.util.*;

public class PatternManager {
    private List<IPattern> _patterns;
    private final PatternScrapperDictionnary _mapperpaterns;

    private ILogger _logger = new FileLogger("output.txt");
    private PerformanceCalculator pf = new PerformanceCalculator();

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
                pf.startTimer();
                e.getPattern().start();
                _logger.log("Pattern [" + e.getClass().getSimpleName() + "] weight " + pf.getProgramSize() + " bytes");
                pf.stopTimer();
                _logger.log("Pattern [" + e.getClass().getSimpleName() + "] lasted " + pf.getElapsedTime() + " milliseconds");
        });
    }
}