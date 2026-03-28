package ru.haskimail.integration;

import ru.haskimail.Haskimail;
import ru.haskimail.client.AccountApiClient;
import ru.haskimail.client.ApiClient;

/**
 * Базовый класс для интеграционных тестов.
 *
 * Для запуска интеграционных тестов необходимо задать переменные окружения:
 * - HASKIMAIL_SERVER_TOKEN — серверный API-токен
 * - HASKIMAIL_ACCOUNT_TOKEN — аккаунт API-токен (для тестов аккаунта)
 * - HASKIMAIL_SENDER_EMAIL — email отправителя
 * - HASKIMAIL_RECIPIENT_EMAIL — email получателя
 */
public class BaseTest {

    protected static final String SERVER_TOKEN = System.getenv("HASKIMAIL_SERVER_TOKEN");
    protected static final String ACCOUNT_TOKEN = System.getenv("HASKIMAIL_ACCOUNT_TOKEN");
    protected static final String SENDER_EMAIL = System.getenv("HASKIMAIL_SENDER_EMAIL");
    protected static final String RECIPIENT_EMAIL = System.getenv("HASKIMAIL_RECIPIENT_EMAIL");
    protected static final String SERVER_ID = System.getenv("HASKIMAIL_SERVER_ID");

    protected ApiClient getApiClient() {
        return Haskimail.getApiClient(SERVER_TOKEN);
    }

    protected AccountApiClient getAccountApiClient() {
        return Haskimail.getAccountApiClient(ACCOUNT_TOKEN);
    }

    protected boolean isConfigured() {
        return SERVER_TOKEN != null && !SERVER_TOKEN.isEmpty();
    }
}
