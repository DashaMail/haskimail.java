package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.data.model.message.Message;
import ru.haskimail.client.data.model.message.MessageResponse;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты отправки сообщений.
 * Запускаются только при наличии переменной окружения HASKIMAIL_SERVER_TOKEN.
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class MessageTest extends BaseTest {

    @Test
    void отправкаПростогоСообщения() throws Exception {
        ApiClient client = getApiClient();

        Message message = new Message(SENDER_EMAIL, RECIPIENT_EMAIL,
                "Тестовое сообщение от Haskimail Java",
                "<h1>Привет!</h1><p>Это тестовое сообщение от библиотеки Haskimail Java.</p>",
                "Привет! Это тестовое сообщение от библиотеки Haskimail Java.");
        message.setTag("integration-test");

        MessageResponse response = client.deliverMessage(message);

        assertNotNull(response);
        assertEquals(0, response.getErrorCode());
        assertNotNull(response.getMessageId());
    }

    @Test
    void отправкаСообщенияСОтслеживанием() throws Exception {
        ApiClient client = getApiClient();

        Message message = new Message(SENDER_EMAIL, RECIPIENT_EMAIL,
                "Тест с отслеживанием - Haskimail Java",
                "<h1>Тест отслеживания</h1><p>Проверка отслеживания открытий и ссылок.</p>");
        message.setTrackOpens(true);
        message.setTrackLinks(Message.TRACK_LINKS.HtmlAndText.value);
        message.addMetadata("test-key", "test-value");

        MessageResponse response = client.deliverMessage(message);

        assertNotNull(response);
        assertEquals(0, response.getErrorCode());
    }

    @Test
    void отправкаСообщенияСЗаголовками() throws Exception {
        ApiClient client = getApiClient();

        Message message = new Message(SENDER_EMAIL, RECIPIENT_EMAIL,
                "Тест с заголовками - Haskimail Java",
                "<p>Тестовое сообщение с пользовательскими заголовками.</p>");
        message.addHeader("X-Custom-Header", "test-value");
        message.setTag("header-test");

        MessageResponse response = client.deliverMessage(message);

        assertNotNull(response);
        assertEquals(0, response.getErrorCode());
    }
}
