package ru.haskimail.unit;

import org.junit.jupiter.api.Test;
import ru.haskimail.Haskimail;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.AccountApiClient;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для класса Haskimail (точка входа).
 */
class HaskimailTest {

    private static final String TEST_TOKEN = "test-token-123";

    @Test
    void создатьApiClientСТокеном() {
        ApiClient client = Haskimail.getApiClient(TEST_TOKEN);
        assertNotNull(client);
        assertEquals(Haskimail.DEFAULT_API_URL, client.getBaseUrl());
    }

    @Test
    void создатьApiClientСНебезопаснымСоединением() {
        ApiClient client = Haskimail.getApiClient(TEST_TOKEN, false);
        assertNotNull(client);
        assertFalse(client.getSecureConnection());
    }

    @Test
    void создатьApiClientСПользовательскимUrl() {
        String customUrl = "custom.api.haskimail.ru";
        ApiClient client = Haskimail.getApiClient(TEST_TOKEN, true, customUrl);
        assertNotNull(client);
        assertEquals(customUrl, client.getBaseUrl());
    }

    @Test
    void создатьAccountApiClientСТокеном() {
        AccountApiClient client = Haskimail.getAccountApiClient(TEST_TOKEN);
        assertNotNull(client);
        assertEquals(Haskimail.DEFAULT_API_URL, client.getBaseUrl());
    }

    @Test
    void создатьAccountApiClientСПользовательскимUrl() {
        String customUrl = "custom.api.haskimail.ru";
        AccountApiClient client = Haskimail.getAccountApiClient(TEST_TOKEN, true, customUrl);
        assertNotNull(client);
        assertEquals(customUrl, client.getBaseUrl());
    }

    @Test
    void проверитьЗначенияПоУмолчанию() {
        assertEquals("api.haskimail.ru", Haskimail.DEFAULT_API_URL);
        assertEquals("X-Haski-Server-Token", Haskimail.SERVER_TOKEN_HEADER);
        assertEquals("X-Haski-Account-Token", Haskimail.ACCOUNT_TOKEN_HEADER);
    }
}
