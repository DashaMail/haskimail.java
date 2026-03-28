package ru.haskimail.client.data.model.templates;

import java.util.List;

/**
 * Коллекция шаблонов.
 */
public class Templates {
    private Integer totalCount;
    private List<BaseTemplate> templates;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public List<BaseTemplate> getTemplates() { return templates; }
    public void setTemplates(List<BaseTemplate> templates) { this.templates = templates; }
}
