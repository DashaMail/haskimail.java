package ru.haskimail.client.exception;

/**
 * Базовое исключение API Haskimail.
 */
public class HaskimailException extends Exception {

    private int errorCode;

    public HaskimailException(String message) {
        super(message);
    }

    public HaskimailException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() { return errorCode; }
    public void setErrorCode(int errorCode) { this.errorCode = errorCode; }
}
