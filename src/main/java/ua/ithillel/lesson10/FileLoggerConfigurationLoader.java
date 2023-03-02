package ua.ithillel.lesson10;

import java.io.*;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    protected FileLoggerConfiguration load(String pathFile) {

        Properties prop = new Properties();

        try (var input = this.getClass().getResourceAsStream(pathFile)) {

            prop.load(input);

            String path = prop.getProperty("path");
            LoggingLevel level = LoggingLevel.valueOf(prop.getProperty("level"));
            long maxSize = Long.parseLong(prop.getProperty("max-size"));

            return new FileLoggerConfiguration(path, level, maxSize);

        } catch (IOException e) {
            throw new RuntimeException("Can't read properties file");
        }
    }

}
