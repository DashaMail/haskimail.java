package ru.haskimail.client.data.model.senders;

/**
 * Детальная информация о подписи отправителя.
 */
public class SignatureDetails extends Signature {
    private String dkimHost;
    private String dkimTextValue;
    private Boolean dkimVerified;
    private Boolean spfVerified;
    private String returnPathDomain;
    private String returnPathDomainCNAMEValue;
    private Boolean returnPathDomainVerified;
    private String confirmationPersonalNote;

    public String getDkimHost() { return dkimHost; }
    public void setDkimHost(String v) { this.dkimHost = v; }
    public String getDkimTextValue() { return dkimTextValue; }
    public void setDkimTextValue(String v) { this.dkimTextValue = v; }
    public Boolean getDkimVerified() { return dkimVerified; }
    public void setDkimVerified(Boolean v) { this.dkimVerified = v; }
    public Boolean getSpfVerified() { return spfVerified; }
    public void setSpfVerified(Boolean v) { this.spfVerified = v; }
    public String getReturnPathDomain() { return returnPathDomain; }
    public void setReturnPathDomain(String v) { this.returnPathDomain = v; }
    public String getReturnPathDomainCNAMEValue() { return returnPathDomainCNAMEValue; }
    public void setReturnPathDomainCNAMEValue(String v) { this.returnPathDomainCNAMEValue = v; }
    public Boolean getReturnPathDomainVerified() { return returnPathDomainVerified; }
    public void setReturnPathDomainVerified(Boolean v) { this.returnPathDomainVerified = v; }
    public String getConfirmationPersonalNote() { return confirmationPersonalNote; }
    public void setConfirmationPersonalNote(String v) { this.confirmationPersonalNote = v; }
}
