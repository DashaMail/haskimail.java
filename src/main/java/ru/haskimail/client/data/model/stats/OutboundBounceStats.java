package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика возвратов.
 */
public class OutboundBounceStats {
    private List<BounceStat> days;

    public List<BounceStat> getDays() { return days; }
    public void setDays(List<BounceStat> days) { this.days = days; }
}
