package com.FinalProject.Logger;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileLogger implements ILogger {
    public FileLogger(String filePath) {
        try {
            _logger = new PrintWriter(new FileWriter(filePath));
        } catch (IOException e) {
            _logger = null;
        }
    }

    public void log(String message) {
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        String log = "[" + now + "] " + message;

        if (_logger != null) {
            _logger.println(log);
            _logger.flush();
        }
    }

    private PrintWriter _logger;
}