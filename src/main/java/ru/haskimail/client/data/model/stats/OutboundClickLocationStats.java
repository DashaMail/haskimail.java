package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика кликов по расположению.
 */
public class OutboundClickLocationStats {
    private List<ClickLocationStat> days;

    public List<ClickLocationStat> getDays() { return days; }
    public void setDays(List<ClickLocationStat> days) { this.days = days; }
}
