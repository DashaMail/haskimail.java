package ru.haskimail.client.data.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Исходящее сообщение электронной почты.
 */
public class OutboundMessage {
    private String recipient;
    private Date receivedAt;
    private String tag;
    private String from;
    private String status;
    @JsonProperty("MessageID")
    private String messageId;
    private String subject;
    private String messageStream;

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public Date getReceivedAt() { return receivedAt; }
    public void setReceivedAt(Date receivedAt) { this.receivedAt = receivedAt; }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessageStream() { return messageStream; }
    public void setMessageStream(String messageStream) { this.messageStream = messageStream; }
}
