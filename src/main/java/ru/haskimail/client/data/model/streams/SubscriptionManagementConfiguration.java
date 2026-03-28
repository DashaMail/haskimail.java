package ru.haskimail.client.data.model.streams;

/**
 * Конфигурация управления подписками канала.
 */
public class SubscriptionManagementConfiguration {
    private String unsubscribeHandlingType;

    public SubscriptionManagementConfiguration() {
        this.unsubscribeHandlingType = "Haskimail";
    }

    public String getUnsubscribeHandlingType() { return unsubscribeHandlingType; }
    public void setUnsubscribeHandlingType(String unsubscribeHandlingType) { this.unsubscribeHandlingType = unsubscribeHandlingType; }
}
