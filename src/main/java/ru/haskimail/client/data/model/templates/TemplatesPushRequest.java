package ru.haskimail.client.data.model.templates;

/**
 * Запрос на пуш шаблонов между серверами.
 */
public class TemplatesPushRequest {
    private Integer sourceServerId;
    private Integer destinationServerId;
    private Boolean performChanges;

    public Integer getSourceServerId() { return sourceServerId; }
    public void setSourceServerId(Integer v) { this.sourceServerId = v; }
    public Integer getDestinationServerId() { return destinationServerId; }
    public void setDestinationServerId(Integer v) { this.destinationServerId = v; }
    public Boolean getPerformChanges() { return performChanges; }
    public void setPerformChanges(Boolean v) { this.performChanges = v; }
}
