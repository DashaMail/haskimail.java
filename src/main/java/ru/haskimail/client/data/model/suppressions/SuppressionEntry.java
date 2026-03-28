package ru.haskimail.client.data.model.suppressions;

/**
 * Запись для добавления в стоп-список.
 */
public class SuppressionEntry {
    private String emailAddress;

    public SuppressionEntry() {}
    public SuppressionEntry(String emailAddress) { this.emailAddress = emailAddress; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }
}
