package ru.haskimail.client.data.model.webhooks.triggers;

/**
 * Триггер вебхука для возвратов.
 */
public class BounceWebhookTrigger extends WebhookTrigger {
    private Boolean includeContent;

    public BounceWebhookTrigger() {}
    public BounceWebhookTrigger(Boolean enabled, Boolean includeContent) {
        super(enabled);
        this.includeContent = includeContent;
    }

    public Boolean getIncludeContent() { return includeContent; }
    public void setIncludeContent(Boolean includeContent) { this.includeContent = includeContent; }
}
