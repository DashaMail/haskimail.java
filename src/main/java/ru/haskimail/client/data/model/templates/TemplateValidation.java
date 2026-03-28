package ru.haskimail.client.data.model.templates;

/**
 * Результат валидации шаблона.
 */
public class TemplateValidation {
    private Boolean allContentIsValid;
    private TemplateValidationField htmlBody;
    private TemplateValidationField textBody;
    private TemplateValidationField subject;
    private Object suggestedTemplateModel;

    public Boolean getAllContentIsValid() { return allContentIsValid; }
    public void setAllContentIsValid(Boolean v) { this.allContentIsValid = v; }
    public TemplateValidationField getHtmlBody() { return htmlBody; }
    public void setHtmlBody(TemplateValidationField v) { this.htmlBody = v; }
    public TemplateValidationField getTextBody() { return textBody; }
    public void setTextBody(TemplateValidationField v) { this.textBody = v; }
    public TemplateValidationField getSubject() { return subject; }
    public void setSubject(TemplateValidationField v) { this.subject = v; }
    public Object getSuggestedTemplateModel() { return suggestedTemplateModel; }
    public void setSuggestedTemplateModel(Object v) { this.suggestedTemplateModel = v; }
}
