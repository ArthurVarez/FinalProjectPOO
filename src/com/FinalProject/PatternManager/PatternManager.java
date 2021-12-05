package com.FinalProject.PatternManager;

import com.FinalProject.Pattern.*;
import com.FinalProject.Scrapper.*;
import com.FinalProject.Logger.*;

import java.util.*;
import java.io.File;
import java.io.IOException;

public class PatternManager {
    public PatternManager() {
        _logger = new FileLogger("output.txt");
        _scrapper = new ImgurScrapper("Super la data", 15, _logger);
        _patterns = Arrays.asList(
            new OneTimePattern()
        );
    }

    public void start() {
        for (IPattern pattern: _patterns) {
            _scrapper.setCount(0);
            pattern.setScrapper(_scrapper);
            pattern.start();
        }
    }

    private IWebScrapper _scrapper;
    private ILogger _logger;
    private List<IPattern> _patterns;
}