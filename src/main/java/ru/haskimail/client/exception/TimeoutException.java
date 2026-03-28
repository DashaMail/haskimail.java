package ru.haskimail.client.exception;

/**
 * Исключение: таймаут запроса.
 * Возникает при HTTP-статусе 408.
 */
public class TimeoutException extends HaskimailHttpException {
    public TimeoutException(String message, int errorCode, int statusCode) {
        super(message, errorCode, statusCode);
    }
}
