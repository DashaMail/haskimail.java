package ru.haskimail.client.data.model.webhooks.triggers;

/**
 * Триггер вебхука для открытий.
 */
public class OpenWebhookTrigger extends WebhookTrigger {
    private Boolean postFirstOpenOnly;

    public OpenWebhookTrigger() {}
    public OpenWebhookTrigger(Boolean enabled, Boolean postFirstOpenOnly) {
        super(enabled);
        this.postFirstOpenOnly = postFirstOpenOnly;
    }

    public Boolean getPostFirstOpenOnly() { return postFirstOpenOnly; }
    public void setPostFirstOpenOnly(Boolean postFirstOpenOnly) { this.postFirstOpenOnly = postFirstOpenOnly; }
}
