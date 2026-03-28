package ru.haskimail.unit;

import org.junit.jupiter.api.Test;
import ru.haskimail.client.HttpClientErrorHandler;
import ru.haskimail.client.data.parser.DataHandler;
import ru.haskimail.client.exception.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для обработчика ошибок HTTP.
 */
class HttpClientErrorHandlerTest {

    private final DataHandler dataHandler = new DataHandler(false);

    @Test
    void ошибка401ВозвращаетInvalidAPIKeyException() {
        HaskimailException ex = HttpClientErrorHandler.throwErrorBasedOnStatusCode(
                401, "{\"ErrorCode\":10,\"Message\":\"Неверный API-ключ\"}", dataHandler);
        assertTrue(ex instanceof InvalidAPIKeyException);
        assertEquals(10, ex.getErrorCode());
    }

    @Test
    void ошибка408ВозвращаетTimeoutException() {
        HaskimailException ex = HttpClientErrorHandler.throwErrorBasedOnStatusCode(
                408, "{\"ErrorCode\":0,\"Message\":\"Таймаут\"}", dataHandler);
        assertTrue(ex instanceof TimeoutException);
    }

    @Test
    void ошибка422ВозвращаетInvalidMessageException() {
        HaskimailException ex = HttpClientErrorHandler.throwErrorBasedOnStatusCode(
                422, "{\"ErrorCode\":300,\"Message\":\"Невалидное сообщение\"}", dataHandler);
        assertTrue(ex instanceof InvalidMessageException);
    }

    @Test
    void ошибка500ВозвращаетInternalServerException() {
        HaskimailException ex = HttpClientErrorHandler.throwErrorBasedOnStatusCode(
                500, "{\"ErrorCode\":0,\"Message\":\"Внутренняя ошибка\"}", dataHandler);
        assertTrue(ex instanceof InternalServerException);
    }

    @Test
    void неизвестнаяОшибкаВозвращаетUnknownException() {
        HaskimailException ex = HttpClientErrorHandler.throwErrorBasedOnStatusCode(
                503, "{\"ErrorCode\":0,\"Message\":\"Сервис недоступен\"}", dataHandler);
        assertTrue(ex instanceof UnknownException);
    }

    @Test
    void некорректныйJsonНеВызываетCrash() {
        HaskimailException ex = HttpClientErrorHandler.throwErrorBasedOnStatusCode(
                500, "not json", dataHandler);
        assertNotNull(ex);
    }
}
