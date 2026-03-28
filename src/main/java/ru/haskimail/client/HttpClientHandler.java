package ru.haskimail.client;

import ru.haskimail.client.data.parser.DataHandler;
import ru.haskimail.client.exception.HaskimailException;

import java.io.IOException;
import java.util.Map;

/**
 * Обработчик HTTP-запросов.
 * Управляет HttpClient и DataHandler, предоставляет методы выполнения запросов.
 */
public class HttpClientHandler {

    private final HttpClient httpClient;
    private final DataHandler dataHandler;
    private Boolean secureConnection;

    public HttpClientHandler(Map<String, Object> headers) {
        this(headers, true);
    }

    public HttpClientHandler(Map<String, Object> headers, Boolean secureConnection) {
        this.httpClient = new HttpClient(headers);
        this.dataHandler = new DataHandler(false);
        this.secureConnection = secureConnection;
    }

    /**
     * Выполнить HTTP-запрос и десериализовать ответ.
     */
    protected <T> T execute(HttpClient.REQUEST_TYPES requestType, String url, Class<T> responseClass) throws HaskimailException, IOException {
        return execute(requestType, url, responseClass, (Object) null);
    }

    /**
     * Выполнить HTTP-запрос с объектом-телом и десериализовать ответ.
     */
    protected <T> T execute(HttpClient.REQUEST_TYPES requestType, String url, Class<T> responseClass, Object data) throws HaskimailException, IOException {
        String jsonData = data != null ? dataHandler.toJson(data) : null;
        HttpClient.ClientResponse response = httpClient.execute(requestType, url, jsonData);

        if (response.getCode() == 200) {
            return dataHandler.fromJson(response.getBody(), responseClass);
        } else {
            throw HttpClientErrorHandler.throwErrorBasedOnStatusCode(response.getCode(), response.getBody(), dataHandler);
        }
    }

    /**
     * Выполнить HTTP-запрос со строковым телом и десериализовать ответ.
     */
    protected <T> T execute(HttpClient.REQUEST_TYPES requestType, String url, Class<T> responseClass, String data) throws HaskimailException, IOException {
        HttpClient.ClientResponse response = httpClient.execute(requestType, url, data);

        if (response.getCode() == 200) {
            return dataHandler.fromJson(response.getBody(), responseClass);
        } else {
            throw HttpClientErrorHandler.throwErrorBasedOnStatusCode(response.getCode(), response.getBody(), dataHandler);
        }
    }

    public HttpClient getHttpClient() { return httpClient; }
    public DataHandler getDataHandler() { return dataHandler; }
    public Boolean getSecureConnection() { return secureConnection; }
    public void setSecureConnection(Boolean secureConnection) { this.secureConnection = secureConnection; }

    public void setReadTimeoutSeconds(int readTimeoutSeconds) {
        httpClient.setReadTimeoutSeconds(readTimeoutSeconds);
    }

    public void setConnectTimeoutSeconds(int connectTimeoutSeconds) {
        httpClient.setConnectTimeoutSeconds(connectTimeoutSeconds);
    }
}
