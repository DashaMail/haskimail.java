package ru.haskimail.client.data.model.message;

import java.util.HashMap;
import java.util.Map;

/**
 * Сообщение электронной почты с расширенными параметрами.
 * Поддерживает отслеживание открытий, ссылок и метаданные.
 */
public class Message extends BaseMessage {

    public enum TRACK_LINKS {
        Html("Html"), HtmlAndText("HtmlAndText"), Text("Text");
        public final String value;
        TRACK_LINKS(String value) { this.value = value; }
    }

    private Boolean trackOpens;
    private String trackLinks;
    private Map<String, String> metadata;

    public Message() { super(); }
    public Message(String from, String to) { super(from, to); }
    public Message(String from, String to, String subject) { super(from, to, subject); }
    public Message(String from, String to, String subject, String htmlBody) { super(from, to, subject, htmlBody); }
    public Message(String from, String to, String subject, String htmlBody, String textBody) { super(from, to, subject, htmlBody, textBody); }

    public Boolean getTrackOpens() { return trackOpens; }
    public void setTrackOpens(Boolean trackOpens) { this.trackOpens = trackOpens; }
    public String getTrackLinks() { return trackLinks; }
    public void setTrackLinks(String trackLinks) { this.trackLinks = trackLinks; }
    public Map<String, String> getMetadata() { return metadata; }
    public void setMetadata(Map<String, String> metadata) { this.metadata = metadata; }

    public void addMetadata(String key, String value) {
        if (metadata == null) { metadata = new HashMap<>(); }
        metadata.put(key, value);
    }
}
