package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.data.model.streams.MessageStreams;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для работы с каналами (message streams).
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class MessageStreamTest extends BaseTest {

    @Test
    void получениеСпискаКаналов() throws Exception {
        ApiClient client = getApiClient();
        MessageStreams streams = client.getMessageStreams();
        assertNotNull(streams);
        assertNotNull(streams.getTotalCount());
    }
}
