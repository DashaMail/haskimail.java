package ru.haskimail.client.data.model.suppressions;

import java.util.List;

/**
 * Стоп-список (подавления доставки по каналу).
 */
public class Suppressions {
    private List<Suppression> suppressions;

    public List<Suppression> getSuppressions() { return suppressions; }
    public void setSuppressions(List<Suppression> suppressions) { this.suppressions = suppressions; }
}
