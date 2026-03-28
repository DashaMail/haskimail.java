package ru.haskimail.client.exception;

/**
 * Исключение: внутренняя ошибка сервера.
 * Возникает при HTTP-статусе 500.
 */
public class InternalServerException extends HaskimailHttpException {
    public InternalServerException(String message, int errorCode, int statusCode) {
        super(message, errorCode, statusCode);
    }
}
