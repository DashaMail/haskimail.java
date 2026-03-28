package ru.haskimail;

import ru.haskimail.client.AccountApiClient;
import ru.haskimail.client.ApiClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Главная точка входа для работы с API Haskimail.
 *
 * Предоставляет фабричные методы для создания клиентов API.
 *
 * Пример использования:
 * <pre>
 *   ApiClient client = Haskimail.getApiClient("ваш-токен-сервера");
 *   client.deliverMessage(new Message("от@домен.ru", "кому@домен.ru", "Тема", "Тело"));
 * </pre>
 */
public class Haskimail {

    /** URL API по умолчанию */
    public static final String DEFAULT_API_URL = "api.haskimail.ru";

    /** Заголовок для серверного токена */
    public static final String SERVER_TOKEN_HEADER = "X-Haski-Server-Token";

    /** Заголовок для аккаунт-токена */
    public static final String ACCOUNT_TOKEN_HEADER = "X-Haski-Account-Token";

    private static final String CONTENT_TYPE_VALUE = "application/json";
    private static final String ACCEPT_VALUE = "application/json";

    /**
     * Получить User-Agent библиотеки.
     */
    private static String getUserAgent() {
        return "Haskimail-Java (version: unknown)";
    }

    /**
     * Получить заголовки по умолчанию для API-запросов.
     */
    private static Map<String, Object> getDefaultHeaders(String authHeader, String apiToken) {
        Map<String, Object> headers = new HashMap<>();
        headers.put(authHeader, apiToken);
        headers.put("User-Agent", getUserAgent());
        headers.put("Accept", ACCEPT_VALUE);
        headers.put("Content-Type", CONTENT_TYPE_VALUE);
        return headers;
    }

    /**
     * Создать клиент API сервера.
     *
     * @param apiToken серверный API-токен
     * @return экземпляр {@link ApiClient}
     */
    public static ApiClient getApiClient(String apiToken) {
        return getApiClient(apiToken, true);
    }

    /**
     * Создать клиент API сервера с выбором протокола.
     *
     * @param apiToken серверный API-токен
     * @param secureConnection true для HTTPS, false для HTTP
     * @return экземпляр {@link ApiClient}
     */
    public static ApiClient getApiClient(String apiToken, Boolean secureConnection) {
        return getApiClient(apiToken, secureConnection, DEFAULT_API_URL);
    }

    /**
     * Создать клиент API сервера с пользовательским URL.
     *
     * @param apiToken серверный API-токен
     * @param secureConnection true для HTTPS, false для HTTP
     * @param customApiUrl пользовательский URL API
     * @return экземпляр {@link ApiClient}
     */
    public static ApiClient getApiClient(String apiToken, Boolean secureConnection, String customApiUrl) {
        return new ApiClient(customApiUrl, getDefaultHeaders(SERVER_TOKEN_HEADER, apiToken), secureConnection);
    }

    /**
     * Создать клиент API аккаунта.
     *
     * @param apiToken аккаунт API-токен
     * @return экземпляр {@link AccountApiClient}
     */
    public static AccountApiClient getAccountApiClient(String apiToken) {
        return getAccountApiClient(apiToken, true);
    }

    /**
     * Создать клиент API аккаунта с выбором протокола.
     *
     * @param apiToken аккаунт API-токен
     * @param secureConnection true для HTTPS, false для HTTP
     * @return экземпляр {@link AccountApiClient}
     */
    public static AccountApiClient getAccountApiClient(String apiToken, Boolean secureConnection) {
        return getAccountApiClient(apiToken, secureConnection, DEFAULT_API_URL);
    }

    /**
     * Создать клиент API аккаунта с пользовательским URL.
     *
     * @param apiToken аккаунт API-токен
     * @param secureConnection true для HTTPS, false для HTTP
     * @param customApiUrl пользовательский URL API
     * @return экземпляр {@link AccountApiClient}
     */
    public static AccountApiClient getAccountApiClient(String apiToken, Boolean secureConnection, String customApiUrl) {
        return new AccountApiClient(customApiUrl, getDefaultHeaders(ACCOUNT_TOKEN_HEADER, apiToken), secureConnection);
    }
}
