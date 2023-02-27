package ua.ithillel.lesson10;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        FileLoggerConfiguration config1 = new FileLoggerConfiguration("output", LoggingLevel.DEBUG, 200);
        FileLoggerConfiguration config2 = new FileLoggerConfiguration("output", LoggingLevel.INFO, 200);

        FileLogger logger1 = new FileLogger(config1);
        FileLogger logger2 = new FileLogger(config2);

            logger1.debug("Logging level =  Debug, method = debug \n");
            logger1.info("Logging level =  Debug, method = info\n");
            logger2.debug("Logging level =  Info, method = debug\n");
            logger2.info("Logging level =  Info, method = info\n");

        FileLoggerConfigurationLoader loader = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration config_props = loader.load("src/main/resources/logs-config.properties");

        System.out.println("Path: " + config_props.getFilePath());
        System.out.println("Level: " + config_props.getLevel());
        System.out.println("Max size: " + config_props.getMaxSize());
    }

}
