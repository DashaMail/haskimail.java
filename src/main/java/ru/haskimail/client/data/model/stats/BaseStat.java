package ru.haskimail.client.data.model.stats;

import java.util.Date;

/**
 * Базовая статистика с датой.
 */
public class BaseStat {
    private Date date;

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }
}
