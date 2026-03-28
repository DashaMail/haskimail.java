package ru.haskimail.client.exception;

/**
 * HTTP-исключение API Haskimail.
 * Содержит код ошибки API и HTTP-код статуса.
 */
public class HaskimailHttpException extends HaskimailException {

    private int statusCode;

    public HaskimailHttpException(String message, int errorCode, int statusCode) {
        super(message, errorCode);
        this.statusCode = statusCode;
    }

    public int getStatusCode() { return statusCode; }
    public void setStatusCode(int statusCode) { this.statusCode = statusCode; }
}
