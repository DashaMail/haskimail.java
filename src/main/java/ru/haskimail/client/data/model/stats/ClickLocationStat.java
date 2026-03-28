package ru.haskimail.client.data.model.stats;

/**
 * Статистика кликов по расположению в письме.
 */
public class ClickLocationStat extends BaseStat {
    private Integer html;
    private Integer text;

    public Integer getHtml() { return html; }
    public void setHtml(Integer html) { this.html = html; }
    public Integer getText() { return text; }
    public void setText(Integer text) { this.text = text; }
}
