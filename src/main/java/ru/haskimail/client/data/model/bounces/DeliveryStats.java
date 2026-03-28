package ru.haskimail.client.data.model.bounces;

import java.util.List;

/**
 * Статистика доставки.
 */
public class DeliveryStats {
    private Integer inactiveMails;
    private List<BounceType> bounces;

    public Integer getInactiveMails() { return inactiveMails; }
    public void setInactiveMails(Integer inactiveMails) { this.inactiveMails = inactiveMails; }
    public List<BounceType> getBounces() { return bounces; }
    public void setBounces(List<BounceType> bounces) { this.bounces = bounces; }
}
