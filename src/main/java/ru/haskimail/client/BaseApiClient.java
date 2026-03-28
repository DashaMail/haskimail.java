package ru.haskimail.client;

import java.util.Map;

/**
 * Базовый класс API-клиента.
 * Управляет базовым URL и протоколом соединения.
 */
public class BaseApiClient extends HttpClientHandler {

    private final String baseUrl;

    public BaseApiClient(String baseUrl, Map<String, Object> headers) {
        super(headers);
        this.baseUrl = baseUrl;
    }

    public BaseApiClient(String baseUrl, Map<String, Object> headers, Boolean secureConnection) {
        super(headers, secureConnection);
        this.baseUrl = baseUrl;
    }

    /**
     * Получить полный URL для эндпоинта API.
     *
     * @param endpoint относительный путь эндпоинта
     * @return полный URL
     */
    protected String getEndpointUrl(String endpoint) {
        String protocol = getSecureConnection() ? "https" : "http";
        return protocol + "://" + baseUrl + endpoint;
    }

    public String getBaseUrl() { return baseUrl; }
}
