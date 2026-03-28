package ru.haskimail.client.data.model.stats;

/**
 * Статистика кликов по дням.
 */
public class ClickStat extends BaseStat {
    private Integer clicks;
    private Integer unique;

    public Integer getClicks() { return clicks; }
    public void setClicks(Integer clicks) { this.clicks = clicks; }
    public Integer getUnique() { return unique; }
    public void setUnique(Integer unique) { this.unique = unique; }
}
