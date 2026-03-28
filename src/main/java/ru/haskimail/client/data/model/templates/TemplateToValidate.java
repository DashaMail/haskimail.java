package ru.haskimail.client.data.model.templates;

/**
 * Шаблон для валидации.
 */
public class TemplateToValidate {
    private String subject;
    private String htmlBody;
    private String textBody;
    private Object testRenderModel;
    private Boolean inlineCssForHtmlTestRender;
    private String templateType;
    private String layoutTemplate;

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getHtmlBody() { return htmlBody; }
    public void setHtmlBody(String htmlBody) { this.htmlBody = htmlBody; }
    public String getTextBody() { return textBody; }
    public void setTextBody(String textBody) { this.textBody = textBody; }
    public Object getTestRenderModel() { return testRenderModel; }
    public void setTestRenderModel(Object testRenderModel) { this.testRenderModel = testRenderModel; }
    public Boolean getInlineCssForHtmlTestRender() { return inlineCssForHtmlTestRender; }
    public void setInlineCssForHtmlTestRender(Boolean v) { this.inlineCssForHtmlTestRender = v; }
    public String getTemplateType() { return templateType; }
    public void setTemplateType(String templateType) { this.templateType = templateType; }
    public String getLayoutTemplate() { return layoutTemplate; }
    public void setLayoutTemplate(String layoutTemplate) { this.layoutTemplate = layoutTemplate; }
}
