package ru.haskimail.client.data.model.templates;

/**
 * Действие пуш-операции шаблона.
 */
public class TemplatesPushAction {
    private String action;
    private Integer templateId;
    private String alias;
    private String name;

    public String getAction() { return action; }
    public void setAction(String v) { this.action = v; }
    public Integer getTemplateId() { return templateId; }
    public void setTemplateId(Integer v) { this.templateId = v; }
    public String getAlias() { return alias; }
    public void setAlias(String v) { this.alias = v; }
    public String getName() { return name; }
    public void setName(String v) { this.name = v; }
}
