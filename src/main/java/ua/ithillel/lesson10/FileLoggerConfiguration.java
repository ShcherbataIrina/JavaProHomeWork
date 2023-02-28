package ua.ithillel.lesson10;

import java.util.Objects;

public class FileLoggerConfiguration {
    private String filePath;
    private LoggingLevel level;
    private long maxSize;

    public FileLoggerConfiguration(String filePath, LoggingLevel level, long maxSize) {
        this.filePath = filePath;
        this.level = level;
        this.maxSize = maxSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public long getMaxSize() {
        return maxSize;
    }

}
