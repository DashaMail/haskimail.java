package ru.haskimail.client.exception;

/**
 * Исключение: недействительный API-ключ.
 * Возникает при HTTP-статусе 401.
 */
public class InvalidAPIKeyException extends HaskimailHttpException {
    public InvalidAPIKeyException(String message, int errorCode, int statusCode) {
        super(message, errorCode, statusCode);
    }
}
