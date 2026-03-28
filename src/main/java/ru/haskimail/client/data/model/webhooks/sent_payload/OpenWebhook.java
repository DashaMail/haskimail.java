package ru.haskimail.client.data.model.webhooks.sent_payload;

import ru.haskimail.client.data.model.messages.OutboundMessageOpen;
import java.util.HashMap;

/**
 * Полезная нагрузка вебхука открытия.
 */
public class OpenWebhook extends OutboundMessageOpen {
    private Boolean firstOpen;
    private HashMap<String, String> metadata;

    public Boolean getFirstOpen() { return firstOpen; }
    public void setFirstOpen(Boolean firstOpen) { this.firstOpen = firstOpen; }
    public HashMap<String, String> getMetadata() { return metadata; }
    public void setMetadata(HashMap<String, String> metadata) { this.metadata = metadata; }
}
