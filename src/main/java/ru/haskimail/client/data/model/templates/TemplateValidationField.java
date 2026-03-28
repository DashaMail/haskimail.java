package ru.haskimail.client.data.model.templates;

import java.util.List;

/**
 * Результат валидации отдельного поля шаблона.
 */
public class TemplateValidationField {
    private Boolean contentIsValid;
    private String renderedContent;
    private List<String> validationErrors;

    public Boolean getContentIsValid() { return contentIsValid; }
    public void setContentIsValid(Boolean v) { this.contentIsValid = v; }
    public String getRenderedContent() { return renderedContent; }
    public void setRenderedContent(String v) { this.renderedContent = v; }
    public List<String> getValidationErrors() { return validationErrors; }
    public void setValidationErrors(List<String> v) { this.validationErrors = v; }
}
