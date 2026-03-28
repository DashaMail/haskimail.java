package ru.haskimail.client.data.model.templates;

import java.util.List;

/**
 * Результат пуш-операции шаблонов.
 */
public class TemplatesPush {
    private Integer totalCount;
    private List<TemplatesPushAction> templates;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer v) { this.totalCount = v; }
    public List<TemplatesPushAction> getTemplates() { return templates; }
    public void setTemplates(List<TemplatesPushAction> v) { this.templates = v; }
}
