package com.FinalProject;

import com.FinalProject.PatternManager.*;
import com.FinalProject.Performance.PerformanceCalculator;

import java.util.logging.Logger;

public class Main {
    private static PerformanceCalculator pf = new PerformanceCalculator();
    private static final Logger LOGGER = Logger.getLogger(Main.class.getSimpleName());

    public static void main(String[] args){
        LOGGER.info(Long.toString(pf.getProgramSize()));
        PatternManager manager = new PatternManager();
        manager.start();




    }
}
