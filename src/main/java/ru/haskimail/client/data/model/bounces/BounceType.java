package ru.haskimail.client.data.model.bounces;

/**
 * Тип отказа доставки.
 */
public class BounceType {
    private String type;
    private String name;
    private Integer count;

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getCount() { return count; }
    public void setCount(Integer count) { this.count = count; }
}
