package ru.haskimail.client.data.model.bounces;

import java.util.List;

/**
 * Коллекция отказов доставки.
 */
public class Bounces {
    private Integer totalCount;
    private List<Bounce> bounces;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public List<Bounce> getBounces() { return bounces; }
    public void setBounces(List<Bounce> bounces) { this.bounces = bounces; }
}
