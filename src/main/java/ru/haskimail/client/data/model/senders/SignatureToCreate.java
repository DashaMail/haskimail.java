package ru.haskimail.client.data.model.senders;

/**
 * Запрос на создание подписи отправителя.
 */
public class SignatureToCreate {
    private String fromEmail;
    private String name;
    private String replyToEmail;
    private String returnPathDomain;
    private String confirmationPersonalNote;

    public String getFromEmail() { return fromEmail; }
    public void setFromEmail(String v) { this.fromEmail = v; }
    public String getName() { return name; }
    public void setName(String v) { this.name = v; }
    public String getReplyToEmail() { return replyToEmail; }
    public void setReplyToEmail(String v) { this.replyToEmail = v; }
    public String getReturnPathDomain() { return returnPathDomain; }
    public void setReturnPathDomain(String v) { this.returnPathDomain = v; }
    public String getConfirmationPersonalNote() { return confirmationPersonalNote; }
    public void setConfirmationPersonalNote(String v) { this.confirmationPersonalNote = v; }
}
