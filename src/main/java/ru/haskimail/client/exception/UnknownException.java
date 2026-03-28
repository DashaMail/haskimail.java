package ru.haskimail.client.exception;

/**
 * Исключение: неизвестная ошибка.
 * Возникает при нераспознанном HTTP-коде статуса.
 */
public class UnknownException extends HaskimailHttpException {
    public UnknownException(String message, int errorCode, int statusCode) {
        super(message, errorCode, statusCode);
    }
}
