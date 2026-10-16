package ru.haskimail.client.data.model.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика открытий по платформам.
 */
public class OpenPlatformStat extends BaseStat {
    private Integer desktop;
    private Integer mobile;
    //в API — WebMail, а UPPER_CAMEL_CASE из имени поля дал бы Webmail
    @JsonProperty("WebMail")
    private Integer webmail;
    private Integer unknown;

    public Integer getDesktop() { return desktop; }
    public void setDesktop(Integer desktop) { this.desktop = desktop; }
    public Integer getMobile() { return mobile; }
    public void setMobile(Integer mobile) { this.mobile = mobile; }
    public Integer getWebmail() { return webmail; }
    public void setWebmail(Integer webmail) { this.webmail = webmail; }
    public Integer getUnknown() { return unknown; }
    public void setUnknown(Integer unknown) { this.unknown = unknown; }
}
