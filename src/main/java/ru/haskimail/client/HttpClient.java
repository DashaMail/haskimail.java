package ru.haskimail.client;

import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.util.Timeout;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * HTTP-клиент для взаимодействия с API Haskimail.
 * Обёртка над Apache HttpClient 5.x.
 */
public class HttpClient {

    /** Таймаут соединения по умолчанию (секунды) */
    private static final int DEFAULT_CONNECT_TIMEOUT_SECONDS = 60;
    /** Таймаут чтения по умолчанию (секунды) */
    private static final int DEFAULT_READ_TIMEOUT_SECONDS = 60;

    private final Map<String, Object> headers;
    private int connectTimeoutSeconds;
    private int readTimeoutSeconds;

    public HttpClient(Map<String, Object> headers) {
        this(headers, DEFAULT_CONNECT_TIMEOUT_SECONDS, DEFAULT_READ_TIMEOUT_SECONDS);
    }

    public HttpClient(Map<String, Object> headers, int connectTimeoutSeconds, int readTimeoutSeconds) {
        this.headers = headers;
        this.connectTimeoutSeconds = connectTimeoutSeconds;
        this.readTimeoutSeconds = readTimeoutSeconds;
    }

    /**
     * Внутренний класс для хранения HTTP-ответа.
     */
    public static class ClientResponse {
        private final int code;
        private final String body;

        public ClientResponse(int code, String body) {
            this.code = code;
            this.body = body;
        }

        public int getCode() { return code; }
        public String getBody() { return body; }
    }

    /**
     * Выполнить HTTP-запрос без тела.
     */
    public ClientResponse execute(HttpClient.REQUEST_TYPES requestType, String url) throws IOException {
        return execute(requestType, url, null);
    }

    /**
     * Выполнить HTTP-запрос с телом.
     */
    public ClientResponse execute(HttpClient.REQUEST_TYPES requestType, String url, String data) throws IOException {
        CloseableHttpClient httpClient = getHttpClient();

        try {
            HttpUriRequestBase request = getRequest(requestType, url);
            setHeaders(request);

            if (data != null) {
                request.setEntity(new StringEntity(data, ContentType.APPLICATION_JSON));
            }

            return httpClient.execute(request, response -> {
                String body = response.getEntity() != null ? EntityUtils.toString(response.getEntity()) : "";
                return new ClientResponse(response.getCode(), body);
            });
        } finally {
            httpClient.close();
        }
    }

    /**
     * Получить настроенный экземпляр HttpClient.
     */
    private CloseableHttpClient getHttpClient() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(Timeout.of(connectTimeoutSeconds, TimeUnit.SECONDS))
                .setResponseTimeout(Timeout.of(readTimeoutSeconds, TimeUnit.SECONDS))
                .build();

        return HttpClients.custom()
                .setDefaultRequestConfig(requestConfig)
                .build();
    }

    /**
     * Установить заголовки для HTTP-запроса.
     */
    private void setHeaders(HttpUriRequestBase request) {
        for (Map.Entry<String, Object> header : headers.entrySet()) {
            request.setHeader(header.getKey(), header.getValue().toString());
        }
    }

    /**
     * Создать объект HTTP-запроса по типу.
     */
    private HttpUriRequestBase getRequest(REQUEST_TYPES requestType, String url) {
        switch (requestType) {
            case POST: return new HttpPost(url);
            case GET: return new HttpGet(url);
            case PUT: return new HttpPut(url);
            case PATCH: return new HttpPatch(url);
            case DELETE: return new HttpDelete(url);
            default: return new HttpGet(url);
        }
    }

    /**
     * Типы HTTP-запросов.
     */
    public enum REQUEST_TYPES {
        POST, GET, PUT, PATCH, DELETE
    }

    public int getConnectTimeoutSeconds() { return connectTimeoutSeconds; }
    public void setConnectTimeoutSeconds(int connectTimeoutSeconds) { this.connectTimeoutSeconds = connectTimeoutSeconds; }

    public int getReadTimeoutSeconds() { return readTimeoutSeconds; }
    public void setReadTimeoutSeconds(int readTimeoutSeconds) { this.readTimeoutSeconds = readTimeoutSeconds; }

    public Map<String, Object> getHeaders() { return headers; }
}
