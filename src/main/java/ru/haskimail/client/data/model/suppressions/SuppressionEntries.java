package ru.haskimail.client.data.model.suppressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Коллекция записей для стоп-списка.
 */
public class SuppressionEntries {
    private List<SuppressionEntry> suppressions;

    public SuppressionEntries() { this.suppressions = new ArrayList<>(); }

    public SuppressionEntries(String... emailAddresses) {
        this();
        for (String email : emailAddresses) {
            suppressions.add(new SuppressionEntry(email));
        }
    }

    public List<SuppressionEntry> getSuppressions() { return suppressions; }
    public void setSuppressions(List<SuppressionEntry> suppressions) { this.suppressions = suppressions; }
}
