package ua.ithillel.lesson10;

import java.util.Objects;

public class FileLoggerConfiguration {
    private String filePath;
    private  LoggingLevel level;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileLoggerConfiguration that = (FileLoggerConfiguration) o;
        return maxSize == that.maxSize && filePath.equals(that.filePath) && level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filePath, level, maxSize);
    }
}
