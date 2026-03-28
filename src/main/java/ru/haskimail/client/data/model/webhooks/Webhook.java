package ru.haskimail.client.data.model.webhooks;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.haskimail.client.data.model.message.Header;
import java.util.List;

/**
 * Модель вебхука.
 */
public class Webhook {
    @JsonProperty("ID")
    private Integer id;
    private String url;
    private HttpAuth httpAuth;
    private List<Header> httpHeaders;
    /** Канал сообщения */
    private String messageStream;
    private WebhookTriggers triggers;

    public Webhook() {}
    public Webhook(String url) { this.url = url; }
    public Webhook(String url, WebhookTriggers triggers) { this.url = url; this.triggers = triggers; }
    public Webhook(String url, String messageStream, HttpAuth httpAuth, List<Header> httpHeaders, WebhookTriggers triggers) {
        this.url = url;
        this.messageStream = messageStream;
        this.httpAuth = httpAuth;
        this.httpHeaders = httpHeaders;
        this.triggers = triggers;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }
    public HttpAuth getHttpAuth() { return httpAuth; }
    public void setHttpAuth(HttpAuth httpAuth) { this.httpAuth = httpAuth; }
    public List<Header> getHttpHeaders() { return httpHeaders; }
    public void setHttpHeaders(List<Header> httpHeaders) { this.httpHeaders = httpHeaders; }
    public String getMessageStream() { return messageStream; }
    public void setMessageStream(String messageStream) { this.messageStream = messageStream; }
    public WebhookTriggers getTriggers() { return triggers; }
    public void setTriggers(WebhookTriggers triggers) { this.triggers = triggers; }
}
