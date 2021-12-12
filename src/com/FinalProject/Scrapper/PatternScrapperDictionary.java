package com.FinalProject.Scrapper;

import com.FinalProject.Pattern.IPattern;
import java.util.ArrayList;
import java.util.List;
/**
 * Class storing that collections of patterns mapped to theirs scrapper
 */
public class PatternScrapperDictionary {
    private final List<PatternScrapperEntry> entries = new ArrayList<>();
    public PatternScrapperDictionary(List<IPattern> entries) {
        entries.forEach(this::AddEntry);
    }
    public void AddEntry(IPattern pattern){
        entries.add(new PatternScrapperEntry(pattern));

    }

    public List<PatternScrapperEntry> getEntries() {
        return entries;
    }

}
