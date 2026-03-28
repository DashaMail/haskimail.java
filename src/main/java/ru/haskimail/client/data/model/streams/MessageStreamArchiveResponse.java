package ru.haskimail.client.data.model.streams;

import java.util.Date;

/**
 * Ответ на архивирование канала.
 */
public class MessageStreamArchiveResponse {
    private String id;
    private Integer serverId;
    private Date expectedPurgeDate;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Integer getServerId() { return serverId; }
    public void setServerId(Integer serverId) { this.serverId = serverId; }
    public Date getExpectedPurgeDate() { return expectedPurgeDate; }
    public void setExpectedPurgeDate(Date expectedPurgeDate) { this.expectedPurgeDate = expectedPurgeDate; }
}
