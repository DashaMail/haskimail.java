package ru.haskimail.client.data.model.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Статистика возвратов по дням.
 */
public class BounceStat extends BaseStat {
    private Integer hardBounce;
    private Integer softBounce;
    private Integer smtpApiError;
    @JsonProperty("Transient")
    private Integer transientBounce;
    private Integer unknown;
    private Integer dMARCPolicy;
    private Integer subscribe;

    public Integer getHardBounce() { return hardBounce; }
    public void setHardBounce(Integer hardBounce) { this.hardBounce = hardBounce; }
    public Integer getSoftBounce() { return softBounce; }
    public void setSoftBounce(Integer softBounce) { this.softBounce = softBounce; }
    public Integer getSmtpApiError() { return smtpApiError; }
    public void setSmtpApiError(Integer smtpApiError) { this.smtpApiError = smtpApiError; }
    public Integer getTransientBounce() { return transientBounce; }
    public void setTransientBounce(Integer transientBounce) { this.transientBounce = transientBounce; }
    public Integer getUnknown() { return unknown; }
    public void setUnknown(Integer unknown) { this.unknown = unknown; }
    public Integer getDMARCPolicy() { return dMARCPolicy; }
    public void setDMARCPolicy(Integer dMARCPolicy) { this.dMARCPolicy = dMARCPolicy; }
    public Integer getSubscribe() { return subscribe; }
    public void setSubscribe(Integer subscribe) { this.subscribe = subscribe; }
}
