package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.messages.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для работы с исходящими сообщениями.
 * Тесты для эндпоинтов /messages, /messages/opens, /messages/clicks.
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class OutboundMessagesTest extends BaseTest {

    @Test
    void получениеСпискаИсходящихСообщений() throws Exception {
        ApiClient client = getApiClient();
        Parameters params = new Parameters().build("count", 10).build("offset", 0);
        OutboundMessages messages = client.getMessages(params);
        assertNotNull(messages);
        assertNotNull(messages.getTotalCount());
    }

    @Test
    void получениеОткрытийСообщений() throws Exception {
        ApiClient client = getApiClient();
        OutboundMessageOpens opens = client.getMessageOpens(new Parameters().build("count", 10).build("offset", 0));
        assertNotNull(opens);
        assertNotNull(opens.getTotalCount());
    }

    @Test
    void получениеКликовСообщений() throws Exception {
        ApiClient client = getApiClient();
        OutboundMessageClicks clicks = client.getMessageClicks(new Parameters().build("count", 10).build("offset", 0));
        assertNotNull(clicks);
        assertNotNull(clicks.getTotalCount());
    }
}
