package ru.haskimail.client.data.model.templates;

import java.util.HashMap;
import java.util.Map;

/**
 * Шаблонное сообщение с поддержкой отслеживания.
 */
public class TemplatedMessage extends BaseTemplatedMessage {
    private Boolean trackOpens;
    private String trackLinks;
    private Map<String, String> metadata;

    public Boolean getTrackOpens() { return trackOpens; }
    public void setTrackOpens(Boolean v) { this.trackOpens = v; }
    public String getTrackLinks() { return trackLinks; }
    public void setTrackLinks(String v) { this.trackLinks = v; }
    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> v) { this.metadata = v; }

    public void addMetadata(String key, String value) {
        if (metadata == null) { metadata = new HashMap<>(); }
        metadata.put(key, value);
    }
}
