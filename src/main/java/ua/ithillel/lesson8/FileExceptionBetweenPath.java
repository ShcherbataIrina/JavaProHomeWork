package ua.ithillel.lesson8;

public class FileExceptionBetweenPath extends RuntimeException {

    public FileExceptionBetweenPath() {
        super("The specified path and the file path do not match !");
    }
}
