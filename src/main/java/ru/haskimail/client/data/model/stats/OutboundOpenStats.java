package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика открытий.
 */
public class OutboundOpenStats {
    private List<OpenStat> days;

    public List<OpenStat> getDays() { return days; }
    public void setDays(List<OpenStat> days) { this.days = days; }
}
