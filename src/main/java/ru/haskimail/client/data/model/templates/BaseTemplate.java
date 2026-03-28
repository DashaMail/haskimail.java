package ru.haskimail.client.data.model.templates;

/**
 * Базовая модель шаблона.
 */
public class BaseTemplate {
    private String alias;
    private Boolean active;
    private String name;
    private Integer templateId;
    private String templateType;
    private String layoutTemplate;

    public String getAlias() { return alias; }
    public void setAlias(String alias) { this.alias = alias; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getTemplateId() { return templateId; }
    public void setTemplateId(Integer templateId) { this.templateId = templateId; }
    public String getTemplateType() { return templateType; }
    public void setTemplateType(String templateType) { this.templateType = templateType; }
    public String getLayoutTemplate() { return layoutTemplate; }
    public void setLayoutTemplate(String layoutTemplate) { this.layoutTemplate = layoutTemplate; }
}
