package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.*;
import com.FinalProject.Performance.PerformanceCalculator;
import com.FinalProject.Pattern.FlyWeight.ImageFlyweightFactory;
import com.FinalProject.Scrapper.*;
import com.FinalProject.Logger.*;

import java.util.*;

public class PatternManager {
    private List<IPattern> _patterns;
    private final PatternScrapperDictionnary _mapperpaterns;

    private ILogger _logger = new FileLogger("output.txt");
    private PerformanceCalculator pf = new PerformanceCalculator();

    public PatternManager() {
        _patterns = Arrays.asList(
                new ImageFlyweightFactory("https://i.imgur.com"),
                new OneTimePattern(),
                new ImageWebObjectFactory()
        );
        _mapperpaterns = new PatternScrapperDictionnary(_patterns);
    }

    public void start() {
        _mapperpaterns.getEntries().forEach(e->
            {
                e.getScrapper().setCount(0);
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] Started ");
                pf.startTimer();
                e.getPattern().Load();
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] weight " + pf.getProgramSize() + " bytes");
                e.getPattern().Download();
                pf.stopTimer();
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] lasted " + pf.getElapsedTime() + " milliseconds");
                e=null;

        });
    }
}