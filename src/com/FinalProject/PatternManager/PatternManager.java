package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Pattern.Factory.*;
import com.FinalProject.Performance.PerformanceCalculator;
import com.FinalProject.Pattern.FlyWeight.ImageFlyweightFactory;
import com.FinalProject.Scrapper.*;
import com.FinalProject.Logger.*;

import java.util.*;
/**
 * Class managing the patterns and logging theirs performances in the output.txt file
 */

public class PatternManager {

    // Here is a collection mapping the patterns to a scrapper
    private final PatternScrapperDictionary _mapperpaterns;
    private final ILogger _logger = new FileLogger("output.txt");
    private final PerformanceCalculator pf = new PerformanceCalculator();

    public PatternManager() {
        List<IPattern> _patterns = Arrays.asList(
                new ImageFlyweightFactory("https://i.imgur.com"),
                new OneTimePattern(),
                new ImageWebObjectFactory()
        );
        _mapperpaterns = new PatternScrapperDictionary(_patterns);
    }

    /**
     * Method to start the patterns and to log performances
     */
    public void start() {
        _mapperpaterns.getEntries().forEach(e->
            {
                e.getScrapper().setCount(0);
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] Started ");
                pf.startTimer();
                e.getPattern().Load();
                e.getPattern().Download();
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] weight " + pf.getProgramSize() + " bytes");
                pf.stopTimer();
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] lasted " + pf.getElapsedTime() + " milliseconds");
                e=null;

        });
    }
}