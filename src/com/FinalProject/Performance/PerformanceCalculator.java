package com.FinalProject.Performance;

/**
 * Class to calculate the performances of our patterns (time+memory usage)
 */
public class PerformanceCalculator {
    private static final long _megaByte = 1024L * 1024L;
    long _startTime = System.currentTimeMillis();
    long _stopTime = System.currentTimeMillis();

    public PerformanceCalculator() {

    }

    /**
     * Return the size of the program in bytes
     */
    public long getProgramSize() {
        System.gc();
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    /**
     * Start a timer
     */
    public void startTimer() {
        _startTime = System.currentTimeMillis();
    }

    /**
     * Stop the timer
     */
    public void stopTimer() {
        _stopTime = System.currentTimeMillis();
    }

    /**
     * Return the computed time
     */
    public long getElapsedTime() {
        return _stopTime - _startTime;
    }

    /**
     * Convert a byte value in megabyte
     */
    public static long bytesToMegabytes(long bytes) {
        return bytes / _megaByte;
    }
}
