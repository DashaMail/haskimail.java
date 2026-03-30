package ru.haskimail.client.data.model.message;

import ru.haskimail.client.data.model.FileDetails;

import java.io.IOException;
import java.util.*;

/**
 * Базовое сообщение электронной почты.
 * Содержит основные поля для отправки email.
 */
public class BaseMessage {

    /** Канал сообщения */
    private String messageStream;
    private String from;
    private String to;
    private String cc;
    private String bcc;
    private String replyTo;
    private String subject;
    private String htmlBody;
    private String textBody;
    private String tag;
    private List<Header> headers;
    private List<Map<String, String>> attachments;

    public BaseMessage() { }
    public BaseMessage(String from, String to) { this(); this.from = from; this.to = to; }
    public BaseMessage(String from, String to, String subject) { this(from, to); this.subject = subject; }
    public BaseMessage(String from, String to, String subject, String htmlBody) { this(from, to, subject); this.htmlBody = htmlBody; }
    public BaseMessage(String from, String to, String subject, String htmlBody, String textBody) { this(from, to, subject, htmlBody); this.textBody = textBody; }

    public String getMessageStream() { return messageStream; }
    public void setMessageStream(String messageStream) { this.messageStream = messageStream; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getTo() { return to; }
    public void setTo(String to) { this.to = to; }
    public void setTo(Map<String, String> to) { this.to = convertRecipients(to); }
    public String getCc() { return cc; }
    public void setCc(String cc) { this.cc = cc; }
    public void setCc(Map<String, String> cc) { this.cc = convertRecipients(cc); }
    public String getBcc() { return bcc; }
    public void setBcc(String bcc) { this.bcc = bcc; }
    public void setBcc(Map<String, String> bcc) { this.bcc = convertRecipients(bcc); }
    public String getReplyTo() { return replyTo; }
    public void setReplyTo(String replyTo) { this.replyTo = replyTo; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getHtmlBody() { return htmlBody; }
    public void setHtmlBody(String htmlBody) { this.htmlBody = htmlBody; }
    public String getTextBody() { return textBody; }
    public void setTextBody(String textBody) { this.textBody = textBody; }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public List<Header> getHeaders() { return headers; }
    public void setHeaders(List<Header> headers) { this.headers = headers; }

    public void addHeader(String name, String value) {
        if (this.headers == null) { setHeaders(new ArrayList<>()); }
        this.headers.add(new Header(name, value));
    }

    public void clearHeaders() { if (this.headers != null) { this.headers.clear(); } }

    public List<Map<String, String>> getAttachments() { return attachments; }
    public void setAttachments(List<Map<String, String>> attachments) { this.attachments = attachments; }

    public void addAttachment(String path) throws IOException {
        addAttachment(FileDetails.getFileName(path), FileDetails.getFileContent(path), FileDetails.getFileContentType(path));
    }

    public void addAttachment(String path, String contentId) throws IOException {
        addAttachment(FileDetails.getFileName(path), FileDetails.getFileContent(path), FileDetails.getFileContentType(path), contentId);
    }

    public void addAttachment(String filename, String content, String contentType, String contentId) {
        addAttachment(filename, content.getBytes(), contentType, contentId);
    }

    public void addAttachment(String filename, String content, String contentType) {
        addAttachment(filename, content.getBytes(), contentType);
    }

    public void addAttachment(String name, byte[] content, String contentType) {
        Map<String, String> attachment = new HashMap<>();
        attachment.put("Name", name);
        attachment.put("Content", Base64.getEncoder().encodeToString(content));
        attachment.put("ContentType", contentType);
        addAttachment(attachment);
    }

    public void addAttachment(String name, byte[] content, String contentType, String contentId) {
        Map<String, String> attachment = new HashMap<>();
        attachment.put("Name", name);
        attachment.put("Content", Base64.getEncoder().encodeToString(content));
        attachment.put("ContentType", contentType);
        attachment.put("ContentId", contentId);
        addAttachment(attachment);
    }

    public void addAttachment(Map<String, String> attachment) {
        if (this.attachments == null) { this.attachments = new ArrayList<>(); }
        attachments.add(attachment);
    }

    public void addAttachments(List<Map<String, String>> attachments) {
        attachments.forEach(this::addAttachment);
    }

    private String convertRecipients(Map<String, String> recipients) {
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> entries = recipients.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            sb.append("\"").append(entry.getKey()).append("\"").append("<").append(entry.getValue()).append(">");
            if (entries.hasNext()) { sb.append(","); }
        }
        return sb.toString();
    }
}
