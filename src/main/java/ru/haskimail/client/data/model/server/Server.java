package ru.haskimail.client.data.model.server;

import java.util.List;

/**
 * Модель сервера Haskimail.
 */
public class Server {
    private Integer id;
    private String name;
    private String color;
    private List<String> apiTokens;
    private String deliveryHookUrl;
    private String bounceHookUrl;
    private String openHookUrl;
    private String clickHookUrl;
    private Boolean trackOpens;
    private String trackLinks;
    private Boolean postFirstOpenOnly;
    private String inboundAddress;
    private String inboundDomain;
    private String inboundHash;
    private Integer inboundSpamThreshold;
    private Boolean smtpApiActivated;
    private Boolean rawEmailEnabled;
    private Boolean enableSmtpApiErrorHooks;
    private Boolean includeBounceContentInHook;
    private String serverLink;
    private String deliveryType;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public List<String> getApiTokens() { return apiTokens; }
    public void setApiTokens(List<String> apiTokens) { this.apiTokens = apiTokens; }
    public String getDeliveryHookUrl() { return deliveryHookUrl; }
    public void setDeliveryHookUrl(String v) { this.deliveryHookUrl = v; }
    public String getBounceHookUrl() { return bounceHookUrl; }
    public void setBounceHookUrl(String v) { this.bounceHookUrl = v; }
    public String getOpenHookUrl() { return openHookUrl; }
    public void setOpenHookUrl(String v) { this.openHookUrl = v; }
    public String getClickHookUrl() { return clickHookUrl; }
    public void setClickHookUrl(String v) { this.clickHookUrl = v; }
    public Boolean getTrackOpens() { return trackOpens; }
    public void setTrackOpens(Boolean v) { this.trackOpens = v; }
    public String getTrackLinks() { return trackLinks; }
    public void setTrackLinks(String v) { this.trackLinks = v; }
    public Boolean getPostFirstOpenOnly() { return postFirstOpenOnly; }
    public void setPostFirstOpenOnly(Boolean v) { this.postFirstOpenOnly = v; }
    public String getInboundAddress() { return inboundAddress; }
    public void setInboundAddress(String v) { this.inboundAddress = v; }
    public String getInboundDomain() { return inboundDomain; }
    public void setInboundDomain(String v) { this.inboundDomain = v; }
    public String getInboundHash() { return inboundHash; }
    public void setInboundHash(String v) { this.inboundHash = v; }
    public Integer getInboundSpamThreshold() { return inboundSpamThreshold; }
    public void setInboundSpamThreshold(Integer v) { this.inboundSpamThreshold = v; }
    public Boolean getSmtpApiActivated() { return smtpApiActivated; }
    public void setSmtpApiActivated(Boolean v) { this.smtpApiActivated = v; }
    public Boolean getRawEmailEnabled() { return rawEmailEnabled; }
    public void setRawEmailEnabled(Boolean v) { this.rawEmailEnabled = v; }
    public Boolean getEnableSmtpApiErrorHooks() { return enableSmtpApiErrorHooks; }
    public void setEnableSmtpApiErrorHooks(Boolean v) { this.enableSmtpApiErrorHooks = v; }
    public Boolean getIncludeBounceContentInHook() { return includeBounceContentInHook; }
    public void setIncludeBounceContentInHook(Boolean v) { this.includeBounceContentInHook = v; }
    public String getServerLink() { return serverLink; }
    public void setServerLink(String v) { this.serverLink = v; }
    public String getDeliveryType() { return deliveryType; }
    public void setDeliveryType(String v) { this.deliveryType = v; }
}
