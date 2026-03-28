package ru.haskimail.client.data.model.webhooks.triggers;

/**
 * Триггер вебхука для жалоб на спам.
 */
public class SpamWebhookTrigger extends BounceWebhookTrigger {
    public SpamWebhookTrigger() {}
    public SpamWebhookTrigger(Boolean enabled, Boolean includeContent) {
        super(enabled, includeContent);
    }
}
