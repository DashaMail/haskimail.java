package ru.haskimail.client.data.model.webhooks;

import java.util.List;

/**
 * Коллекция вебхуков.
 */
public class Webhooks {
    private List<Webhook> webhooks;

    public List<Webhook> getWebhooks() { return webhooks; }
    public void setWebhooks(List<Webhook> webhooks) { this.webhooks = webhooks; }
}
