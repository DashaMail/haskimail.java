package ru.haskimail.client.data.model.domains;

import java.util.List;

/**
 * Коллекция доменов.
 */
public class Domains {
    private Integer totalCount;
    private List<Domain> domains;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public List<Domain> getDomains() { return domains; }
    public void setDomains(List<Domain> domains) { this.domains = domains; }
}
