package ru.haskimail.client.exception;

/**
 * Исключение: некорректное сообщение.
 * Возникает при HTTP-статусе 422.
 */
public class InvalidMessageException extends HaskimailHttpException {
    public InvalidMessageException(String message, int errorCode, int statusCode) {
        super(message, errorCode, statusCode);
    }
}
