package com.FinalProject.Performance;

public class PerformanceCalculator {
    private static final long _megaByte = 1024L * 1024L;
    long _startTime = System.currentTimeMillis();
    long _stopTime = System.currentTimeMillis();

    public PerformanceCalculator() {

    }

    public long getProgramSize() {
        System.gc();
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }

    public void startTimer() {
        _startTime = System.currentTimeMillis();
    }

    public void stopTimer() {
        _stopTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return _stopTime - _startTime;
    }

    public static long bytesToMegabytes(long bytes) {
        return bytes / _megaByte;
    }
}
