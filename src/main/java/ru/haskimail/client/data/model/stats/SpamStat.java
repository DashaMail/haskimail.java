package ru.haskimail.client.data.model.stats;

/**
 * Статистика жалоб на спам по дням.
 */
public class SpamStat extends BaseStat {
    private Integer spamComplaint;

    public Integer getSpamComplaint() { return spamComplaint; }
    public void setSpamComplaint(Integer spamComplaint) { this.spamComplaint = spamComplaint; }
}
