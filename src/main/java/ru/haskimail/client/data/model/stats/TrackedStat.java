package ru.haskimail.client.data.model.stats;

/**
 * Статистика отслеживаемых сообщений по дням.
 */
public class TrackedStat extends BaseStat {
    private Integer tracked;

    public Integer getTracked() { return tracked; }
    public void setTracked(Integer tracked) { this.tracked = tracked; }
}
