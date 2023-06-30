package ua.ithillel.bank.transaction;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
