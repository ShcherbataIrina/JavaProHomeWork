package ua.ithillel.lesson10;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements Logger{
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

    @Override
    public void debug(String message) {
        log(message, LoggingLevel.DEBUG);
    }

    @Override
    public void info(String message) {
        log(message, LoggingLevel.INFO);
    }

    private void log(String message, LoggingLevel level) {
        if (level == LoggingLevel.DEBUG && config.getLevel() != LoggingLevel.DEBUG) {
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy-HH.mm");
        String timeWriteMessage = dateFormat.format(new Date());
        String formatMessage = String.format("[%s][%s] Message: %s\n", timeWriteMessage, level, message);

        nowSize = currentFile.length() + formatMessage.getBytes().length;
        if (nowSize > config.getMaxSize()) {
            createNewFile();
        }

        try {
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
