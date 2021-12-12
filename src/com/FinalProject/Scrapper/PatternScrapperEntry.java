package com.FinalProject.Scrapper;

import com.FinalProject.Constants;
import com.FinalProject.Logger.FileLogger;
import com.FinalProject.Pattern.*;

/**
 * Class to map a pattern to a scrapper
 */

public class PatternScrapperEntry {

    private IWebScrapper scrapper;
    private IPattern pattern;
    FileLogger _logger ;

    public PatternScrapperEntry(IPattern pattern) {
        _logger = new FileLogger("output.txt");
        this.pattern = pattern;
        this.scrapper = new ImgurScrapper(Constants.DataKind, Constants.DataNumber, _logger);
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
