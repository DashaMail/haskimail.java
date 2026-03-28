package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика кликов.
 */
public class OutboundClickStats {
    private List<ClickStat> days;

    public List<ClickStat> getDays() { return days; }
    public void setDays(List<ClickStat> days) { this.days = days; }
}
