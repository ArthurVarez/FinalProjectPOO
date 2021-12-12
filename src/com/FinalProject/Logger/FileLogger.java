package com.FinalProject.Logger;

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Logger to edit a text file
 * The logger to write in the text file the elapsed time for a design pattern to process and
 * the resources used
 */
public class FileLogger implements ILogger {
    public FileLogger(String filePath) {
        try {
            _logger = new PrintWriter(new FileWriter(filePath));
        } catch (IOException e) {
            _logger = null;
        }
    }

    /**
     * Log the message given in parameter
     */
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