package ru.haskimail.client.data.model.stats;

/**
 * Статистика открытий по дням.
 */
public class OpenStat extends BaseStat {
    private Integer opens;
    private Integer unique;

    public Integer getOpens() { return opens; }
    public void setOpens(Integer opens) { this.opens = opens; }
    public Integer getUnique() { return unique; }
    public void setUnique(Integer unique) { this.unique = unique; }
}
