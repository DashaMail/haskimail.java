package ru.haskimail.unit;

import org.junit.jupiter.api.Test;
import ru.haskimail.Haskimail;
import ru.haskimail.client.ApiClient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для базового API-клиента.
 */
class BaseApiClientTest {

    @Test
    void httpsПоУмолчанию() {
        ApiClient client = Haskimail.getApiClient("test-token");
        assertTrue(client.getSecureConnection());
    }

    @Test
    void httpСоединение() {
        ApiClient client = Haskimail.getApiClient("test-token", false);
        assertFalse(client.getSecureConnection());
    }

    @Test
    void пользовательскийUrl() {
        ApiClient client = Haskimail.getApiClient("test-token", true, "custom.api.ru");
        assertEquals("custom.api.ru", client.getBaseUrl());
    }

    @Test
    void настройкаТаймаутов() {
        ApiClient client = Haskimail.getApiClient("test-token");
        client.setConnectTimeoutSeconds(30);
        client.setReadTimeoutSeconds(30);
        // Проверяем, что настройка не вызывает ошибок
        assertNotNull(client);
    }
}
