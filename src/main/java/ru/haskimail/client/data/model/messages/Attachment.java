package ru.haskimail.client.data.model.messages;

/**
 * Модель вложения электронного письма.
 */
public class Attachment {
    private String name;
    private String content;
    private String contentType;
    private Integer contentLength;
    private String contentId;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }
    public Integer getContentLength() { return contentLength; }
    public void setContentLength(Integer contentLength) { this.contentLength = contentLength; }
    public String getContentId() { return contentId; }
    public void setContentId(String contentId) { this.contentId = contentId; }
}
