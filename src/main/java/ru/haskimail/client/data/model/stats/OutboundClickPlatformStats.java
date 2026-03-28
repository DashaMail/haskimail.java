package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика кликов по платформам.
 */
public class OutboundClickPlatformStats {
    private List<ClickPlatformStat> days;

    public List<ClickPlatformStat> getDays() { return days; }
    public void setDays(List<ClickPlatformStat> days) { this.days = days; }
}
