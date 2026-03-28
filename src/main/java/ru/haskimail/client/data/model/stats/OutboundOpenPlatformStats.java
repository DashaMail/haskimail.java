package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика открытий по платформам.
 */
public class OutboundOpenPlatformStats {
    private List<OpenPlatformStat> days;

    public List<OpenPlatformStat> getDays() { return days; }
    public void setDays(List<OpenPlatformStat> days) { this.days = days; }
}
