package ua.ithillel.lesson10;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger {
    private final String TXT_FILE_EXTENSION = ".txt";
    private FileLoggerConfiguration config;
    private File currentFile;
    private FileWriter currentWriterFile;
    private long nowSize = 0;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
        this.currentFile = new File(config.getFilePath() + TXT_FILE_EXTENSION);
        try {
            this.currentWriterFile = new FileWriter(currentFile, true);
        } catch (IOException e) {
            throw new RuntimeException("Error by create currentWriterFile! " + e);
        }
    }

    public void debug(String message) {
        log(message, LoggingLevel.DEBUG);
    }

    public void info(String message) {
        log(message, LoggingLevel.INFO);
    }

    private void log(String message, LoggingLevel level) throws FileMaxSizeReachedException {
        if (level == LoggingLevel.DEBUG && config.getLevel() != LoggingLevel.DEBUG) {
            return;
             }

        try {
            if (!currentFile.exists()) {
                currentFile.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        nowSize = currentFile.length() + message.getBytes().length;
        if (nowSize > config.getMaxSize()) {
            createNewFile();
            //throw new FileMaxSizeReachedException(config, nowSize);
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH.mm");
        String timeWriteMessage = dateFormat.format(new Date());
        String formatMessage = String.format("[%s][%s] Message: %s\n", timeWriteMessage, level, message);

        try {
            // currentWriterFile = new FileWriter(currentFile, true);
            currentWriterFile.write(formatMessage);
            currentWriterFile.flush();

        } catch (IOException e) {
            throw new RuntimeException("Can't write message in file!");
        }

    }

    private void createNewFile() {
        if (currentWriterFile != null) {
            try {
                currentWriterFile.close();

            } catch (IOException e) {
                throw new RuntimeException("Can't close file!");
            }
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH.mm");
        String timeNameFile = dateFormat.format(new Date());
        String newNameForFile = config.getFilePath() + "_" + timeNameFile + TXT_FILE_EXTENSION;
        currentFile = new File(newNameForFile);
        try {
            currentWriterFile = new FileWriter(currentFile, true);
        } catch (IOException e) {
            throw new RuntimeException("Can't create new currentWriterFile!" + e);
        }

    }

}
