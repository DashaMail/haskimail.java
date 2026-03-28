package ru.haskimail.client.data.model.domains;

/**
 * Детальная информация о домене.
 */
public class DomainDetails extends Domain {
    private String dkimHost;
    private String dkimTextValue;
    private String dkimPendingHost;
    private String dkimPendingTextValue;
    private String dkimRevokedHost;
    private String dkimRevokedTextValue;
    private String dkimUpdateStatus;
    private String returnPathDomain;
    private String returnPathDomainCNAMEValue;
    private Boolean safeToRemoveRevokedKeyFromDNS;

    public String getDkimHost() { return dkimHost; }
    public void setDkimHost(String v) { this.dkimHost = v; }
    public String getDkimTextValue() { return dkimTextValue; }
    public void setDkimTextValue(String v) { this.dkimTextValue = v; }
    public String getDkimPendingHost() { return dkimPendingHost; }
    public void setDkimPendingHost(String v) { this.dkimPendingHost = v; }
    public String getDkimPendingTextValue() { return dkimPendingTextValue; }
    public void setDkimPendingTextValue(String v) { this.dkimPendingTextValue = v; }
    public String getDkimRevokedHost() { return dkimRevokedHost; }
    public void setDkimRevokedHost(String v) { this.dkimRevokedHost = v; }
    public String getDkimRevokedTextValue() { return dkimRevokedTextValue; }
    public void setDkimRevokedTextValue(String v) { this.dkimRevokedTextValue = v; }
    public String getDkimUpdateStatus() { return dkimUpdateStatus; }
    public void setDkimUpdateStatus(String v) { this.dkimUpdateStatus = v; }
    public String getReturnPathDomain() { return returnPathDomain; }
    public void setReturnPathDomain(String v) { this.returnPathDomain = v; }
    public String getReturnPathDomainCNAMEValue() { return returnPathDomainCNAMEValue; }
    public void setReturnPathDomainCNAMEValue(String v) { this.returnPathDomainCNAMEValue = v; }
    public Boolean getSafeToRemoveRevokedKeyFromDNS() { return safeToRemoveRevokedKeyFromDNS; }
    public void setSafeToRemoveRevokedKeyFromDNS(Boolean v) { this.safeToRemoveRevokedKeyFromDNS = v; }
}
