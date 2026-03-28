package ru.haskimail.client.data.model.templates;

/**
 * Содержимое шаблона для предварительного просмотра.
 */
public class TemplateContent {
    private String htmlBody;
    private String textBody;
    private String subject;

    public String getHtmlBody() { return htmlBody; }
    public void setHtmlBody(String htmlBody) { this.htmlBody = htmlBody; }
    public String getTextBody() { return textBody; }
    public void setTextBody(String textBody) { this.textBody = textBody; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
}
