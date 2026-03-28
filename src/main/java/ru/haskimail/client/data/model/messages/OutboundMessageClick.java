package ru.haskimail.client.data.model.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * Клик по ссылке в исходящем сообщении.
 */
public class OutboundMessageClick {
    private String recipient;
    private Date receivedAt;
    private String tag;
    private String from;
    private String recordType;
    private String os;
    private String browser;
    private String webservice;
    private String userAgent;
    private String language;
    private String region;
    private String country;
    @JsonProperty("MessageID")
    private String messageId;
    private String subject;
    private String messageStream;
    private String originalLink;
    private String clickLocation;

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }
    public Date getReceivedAt() { return receivedAt; }
    public void setReceivedAt(Date receivedAt) { this.receivedAt = receivedAt; }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getRecordType() { return recordType; }
    public void setRecordType(String recordType) { this.recordType = recordType; }
    public String getOs() { return os; }
    public void setOs(String os) { this.os = os; }
    public String getBrowser() { return browser; }
    public void setBrowser(String browser) { this.browser = browser; }
    public String getWebservice() { return webservice; }
    public void setWebservice(String webservice) { this.webservice = webservice; }
    public String getUserAgent() { return userAgent; }
    public void setUserAgent(String userAgent) { this.userAgent = userAgent; }
    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }
    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getMessageStream() { return messageStream; }
    public void setMessageStream(String messageStream) { this.messageStream = messageStream; }
    public String getOriginalLink() { return originalLink; }
    public void setOriginalLink(String originalLink) { this.originalLink = originalLink; }
    public String getClickLocation() { return clickLocation; }
    public void setClickLocation(String clickLocation) { this.clickLocation = clickLocation; }
}
