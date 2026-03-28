package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика отправок.
 */
public class OutboundSendStats {
    private List<SentStat> days;

    public List<SentStat> getDays() { return days; }
    public void setDays(List<SentStat> days) { this.days = days; }
}
