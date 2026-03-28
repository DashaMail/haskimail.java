package ru.haskimail.integration;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.webhooks.Webhook;
import ru.haskimail.client.data.model.webhooks.Webhooks;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для работы с вебхуками.
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class WebhookTest extends BaseTest {

    @Test
    void получениеСпискаВебхуков() throws Exception {
        ApiClient client = getApiClient();
        Webhooks webhooks = client.getWebhooks(new Parameters());
        assertNotNull(webhooks);
    }

    @Test
    void созданиеИУдалениеВебхука() throws Exception {
        ApiClient client = getApiClient();

        Webhook webhook = new Webhook("https://example.com/webhook-test-" + System.currentTimeMillis());
        Webhook created = client.createWebhook(webhook);
        assertNotNull(created);
        assertNotNull(created.getId());

        Webhook fetched = client.getWebhook(created.getId());
        assertNotNull(fetched);
        assertEquals(created.getId(), fetched.getId());

        client.deleteWebhook(created.getId());
    }
}
