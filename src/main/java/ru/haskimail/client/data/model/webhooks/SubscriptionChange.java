package ru.haskimail.client.data.model.webhooks;

/**
 * Событие изменения подписки.
 */
public class SubscriptionChange {
    private Boolean enabled;

    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
}
