package com.FinalProject.Scrapper;

import com.FinalProject.Logger.FileLogger;
import com.FinalProject.Pattern.*;

import java.util.logging.Logger;

public class PatternScapperEntry {
    private IWebScrapper scrapper;
    private IPattern pattern;
    FileLogger _logger ;

    public PatternScapperEntry(IPattern pattern) {
        _logger = new FileLogger("output.txt");
        this.pattern = pattern;
        this.scrapper = new ImgurScrapper("Super la data", 15, _logger);
        this.pattern.setScrapper(this.scrapper);
    }

    public void setScrapper(IWebScrapper scrapper) {
        this.scrapper = scrapper;
    }

    public void setPattern(IPattern pattern) {
        this.pattern = pattern;
    }

    public IWebScrapper getScrapper() {
        return scrapper;
    }

    public IPattern getPattern() {
        return pattern;
    }
}
