package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика отслеживаемых сообщений.
 */
public class OutboundTrackedStats {
    private List<TrackedStat> days;

    public List<TrackedStat> getDays() { return days; }
    public void setDays(List<TrackedStat> days) { this.days = days; }
}
