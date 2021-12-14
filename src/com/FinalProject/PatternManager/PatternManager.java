package com.FinalProject.PatternManager;

import com.FinalProject.Constants;
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
    private final PatternScrapperDictionary _mapperPaterns;
    private final ILogger _logger = new FileLogger(Constants.OutputFile);
    private final PerformanceCalculator pf = new PerformanceCalculator();

    public PatternManager() {
        List<IPattern> patterns = Arrays.asList(
                new ImageFlyweightFactory("https://i.imgur.com/"),
                new ImageWebObjectFactory());
        _mapperPaterns = new PatternScrapperDictionary(patterns);
    }

    /**
     * Method to start the patterns and to log performances
     */
    public void start() {
        _mapperPaterns.getEntries().forEach(e->
            {
                e.getScrapper().setCount(0);
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] Started ");
                pf.startTimer();
                e.getPattern().Load();
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] weight " + pf.getProgramSize() + " bytes");
                e.getPattern().Download();
                pf.stopTimer();
                _logger.log("Pattern [" + e.getPattern().getClass().getSimpleName() + "] lasted " + pf.getElapsedTime() + " milliseconds");
        });
    }
}