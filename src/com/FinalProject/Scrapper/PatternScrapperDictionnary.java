package com.FinalProject.Scrapper;

import com.FinalProject.Pattern.IPattern;

import java.util.ArrayList;
import java.util.List;

public class PatternScrapperDictionnary {
    private List<PatternScapperEntry> entries = new ArrayList<>();

    public PatternScrapperDictionnary(List<IPattern> entries) {
        entries.forEach(this::AddEntry);
    }
    public void AddEntry(IPattern pattern){
        entries.add(new PatternScapperEntry(pattern));

    }

    public List<PatternScapperEntry> getEntries() {
        return entries;
    }
}
