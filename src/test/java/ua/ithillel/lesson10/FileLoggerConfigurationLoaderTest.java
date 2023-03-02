package ua.ithillel.lesson10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileLoggerConfigurationLoaderTest {
    @Test
    void shouldLoadProperties() {
        FileLoggerConfigurationLoader props = new FileLoggerConfigurationLoader();
        FileLoggerConfiguration result = props.load("/logs-config.properties");

        assertEquals("logs-config.properties", result.getFilePath());
        assertEquals(LoggingLevel.INFO, result.getLevel());
        assertEquals(2598637, result.getMaxSize());
    }
}