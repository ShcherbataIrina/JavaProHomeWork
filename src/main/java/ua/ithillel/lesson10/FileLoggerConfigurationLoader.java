package ua.ithillel.lesson10;

import java.io.*;
import java.util.Properties;

public class FileLoggerConfigurationLoader {

    protected FileLoggerConfiguration load(String pathFile) {

        FileInputStream input = null;
        Properties prop = new Properties();

        try {
            input = new FileInputStream(pathFile);
            prop.load(input);

            String path = prop.getProperty("path");
            LoggingLevel level = LoggingLevel.valueOf(prop.getProperty("level"));
            long maxSize = Long.parseLong(prop.getProperty("max-size"));

            return new FileLoggerConfiguration(path, level, maxSize);

        } catch (IOException e) {
            throw new RuntimeException("Can't read properties file");
        } finally {
            try {
                if(input != null){
                    input.close();
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't close properties file");
            }
        }
    }

}
