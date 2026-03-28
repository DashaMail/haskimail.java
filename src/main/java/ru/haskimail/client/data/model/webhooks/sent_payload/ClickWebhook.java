package ru.haskimail.client.data.model.webhooks.sent_payload;

import ru.haskimail.client.data.model.messages.OutboundMessageClick;
import java.util.HashMap;

/**
 * Полезная нагрузка вебхука клика.
 */
public class ClickWebhook extends OutboundMessageClick {
    private HashMap<String, String> metadata;

    public HashMap<String, String> getMetadata() { return metadata; }
    public void setMetadata(HashMap<String, String> metadata) { this.metadata = metadata; }
}
