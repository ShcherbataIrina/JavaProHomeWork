package ua.ithillel.lesson10;

public class FileMaxSizeReachedException extends RuntimeException {

    public FileMaxSizeReachedException(FileLoggerConfiguration config, long nowSize) {
        super("maxSize =" + config.getMaxSize() + " at the moment size of file = " + nowSize + ". Path to file: " + config.getFilePath() + ".Therefore created new writerFile!");
    }
}
