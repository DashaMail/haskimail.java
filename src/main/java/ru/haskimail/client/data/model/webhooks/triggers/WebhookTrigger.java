package ru.haskimail.client.data.model.webhooks.triggers;

/**
 * Базовый триггер вебхука.
 */
public class WebhookTrigger {
    private Boolean enabled;

    public WebhookTrigger() {}
    public WebhookTrigger(Boolean enabled) { this.enabled = enabled; }

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
}
