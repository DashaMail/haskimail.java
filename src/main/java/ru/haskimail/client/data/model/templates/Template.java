package ru.haskimail.client.data.model.templates;

/**
 * Шаблон электронного письма.
 */
public class Template extends BaseTemplate {
    private String subject;
    private String htmlBody;
    private String textBody;
    private Integer associatedServerId;

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getHtmlBody() { return htmlBody; }
    public void setHtmlBody(String htmlBody) { this.htmlBody = htmlBody; }
    public String getTextBody() { return textBody; }
    public void setTextBody(String textBody) { this.textBody = textBody; }
    public Integer getAssociatedServerId() { return associatedServerId; }
    public void setAssociatedServerId(Integer associatedServerId) { this.associatedServerId = associatedServerId; }
}
