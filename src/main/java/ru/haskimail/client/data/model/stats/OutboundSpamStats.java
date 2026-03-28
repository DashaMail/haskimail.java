package ru.haskimail.client.data.model.stats;

import java.util.List;

/**
 * Агрегированная статистика жалоб на спам.
 */
public class OutboundSpamStats {
    private List<SpamStat> days;

    public List<SpamStat> getDays() { return days; }
    public void setDays(List<SpamStat> days) { this.days = days; }
}
