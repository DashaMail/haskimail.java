package ru.haskimail.client.data.model.webhooks.sent_payload;

import ru.haskimail.client.data.model.bounces.Bounce;
import java.util.HashMap;

/**
 * Полезная нагрузка вебхука возврата.
 */
public class BounceWebhook extends Bounce {
    private HashMap<String, String> metadata;

    public HashMap<String, String> getMetadata() { return metadata; }
    public void setMetadata(HashMap<String, String> metadata) { this.metadata = metadata; }
}
