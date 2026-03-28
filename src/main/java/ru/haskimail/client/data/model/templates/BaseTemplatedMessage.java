package ru.haskimail.client.data.model.templates;

import ru.haskimail.client.data.model.message.Header;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Базовое шаблонное сообщение.
 */
public class BaseTemplatedMessage {
    private Integer templateId;
    private String templateAlias;
    private Object templateModel;
    private Boolean inlineCss;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String replyTo;
    private String tag;
    private List<Header> headers;
    private List<Map<String, String>> attachments;
    /** Канал сообщения */
    private String messageStream;

    public BaseTemplatedMessage() { this.attachments = new ArrayList<>(); }

    public Integer getTemplateId() { return templateId; }
    public void setTemplateId(Integer v) { this.templateId = v; }
    public String getTemplateAlias() { return templateAlias; }
    public void setTemplateAlias(String v) { this.templateAlias = v; }
    public Object getTemplateModel() { return templateModel; }
    public void setTemplateModel(Object v) { this.templateModel = v; }
    public Boolean getInlineCss() { return inlineCss; }
    public void setInlineCss(Boolean v) { this.inlineCss = v; }
    public String getFrom() { return from; }
    public void setFrom(String v) { this.from = v; }
    public String getTo() { return to; }
    public void setTo(String v) { this.to = v; }
    public String getCc() { return cc; }
    public void setCc(String v) { this.cc = v; }
    public String getBcc() { return bcc; }
    public void setBcc(String v) { this.bcc = v; }
    public String getReplyTo() { return replyTo; }
    public void setReplyTo(String v) { this.replyTo = v; }
    public String getTag() { return tag; }
    public void setTag(String v) { this.tag = v; }
    public List<Header> getHeaders() { return headers; }
    public void setHeaders(List<Header> v) { this.headers = v; }
    public List<Map<String, String>> getAttachments() { return attachments; }
    public void setAttachments(List<Map<String, String>> v) { this.attachments = v; }
    public String getMessageStream() { return messageStream; }
    public void setMessageStream(String v) { this.messageStream = v; }
}
