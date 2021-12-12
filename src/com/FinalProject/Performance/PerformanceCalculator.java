package com.FinalProject.Performance;

public class PerformanceCalculator {
    private static final long MEGABYTE = 1024L * 1024L;
    Runtime _runtime = Runtime.getRuntime();
    long _startTime = System.currentTimeMillis();
    long _stopTime = System.currentTimeMillis();

    public PerformanceCalculator() {

    }

    public long getProgramSize() {
        _runtime.gc();
        return _runtime.totalMemory() - _runtime.freeMemory();
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
        return bytes / MEGABYTE;
    }
}
