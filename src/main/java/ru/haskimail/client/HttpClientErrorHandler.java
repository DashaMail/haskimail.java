package ru.haskimail.client;

import ru.haskimail.client.data.model.HaskimailError;
import ru.haskimail.client.data.parser.DataHandler;
import ru.haskimail.client.exception.*;

/**
 * Обработчик ошибок HTTP-ответов.
 * Преобразует HTTP-коды статуса в соответствующие исключения.
 */
public class HttpClientErrorHandler {

    /**
     * Создать исключение на основе HTTP-кода статуса.
     */
    public static HaskimailException throwErrorBasedOnStatusCode(int statusCode, String body, DataHandler dataHandler) {
        HaskimailError error = parseErrorFromBody(body, dataHandler);
        String message = error != null ? error.getMessage() : "Неизвестная ошибка";
        int errorCode = error != null ? error.getErrorCode() : 0;

        switch (statusCode) {
            case 401:
                return new InvalidAPIKeyException(message, errorCode, statusCode);
            case 408:
                return new TimeoutException(message, errorCode, statusCode);
            case 422:
                return new InvalidMessageException(message, errorCode, statusCode);
            case 500:
                return new InternalServerException(message, errorCode, statusCode);
            default:
                return new UnknownException(message, errorCode, statusCode);
        }
    }

    private static HaskimailError parseErrorFromBody(String body, DataHandler dataHandler) {
        try {
            return dataHandler.fromJson(body, HaskimailError.class);
        } catch (Exception e) {
            return null;
        }
    }
}
