package ru.haskimail.client.data.model.stats;

/**
 * Статистика отправок по дням.
 */
public class SentStat extends BaseStat {
    private Integer sent;

    public Integer getSent() { return sent; }
    public void setSent(Integer sent) { this.sent = sent; }
}
