package ru.haskimail.client.data.model.senders;

/**
 * Подпись отправителя.
 */
public class Signature {
    private String domain;
    private String emailAddress;
    private String replyToEmailAddress;
    private String name;
    private Boolean confirmed;
    private Integer id;

    public String getDomain() { return domain; }
    public void setDomain(String v) { this.domain = v; }
    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String v) { this.emailAddress = v; }
    public String getReplyToEmailAddress() { return replyToEmailAddress; }
    public void setReplyToEmailAddress(String v) { this.replyToEmailAddress = v; }
    public String getName() { return name; }
    public void setName(String v) { this.name = v; }
    public Boolean getConfirmed() { return confirmed; }
    public void setConfirmed(Boolean v) { this.confirmed = v; }
    public Integer getId() { return id; }
    public void setId(Integer v) { this.id = v; }
}
