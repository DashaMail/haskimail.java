package ru.haskimail.client.data.model.streams;

import java.util.Date;

/**
 * Канал сообщений.
 * Каналы позволяют организовать отправку по типам: транзакционные, маркетинговые и т.д.
 */
public class MessageStream {
    private String id;
    private Integer serverId;
    private String name;
    private String description;
    private String messageStreamType;
    private Date createdAt;
    private Date updatedAt;
    private Date archivedAt;
    private SubscriptionManagementConfiguration subscriptionManagementConfiguration;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Integer getServerId() { return serverId; }
    public void setServerId(Integer serverId) { this.serverId = serverId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getMessageStreamType() { return messageStreamType; }
    public void setMessageStreamType(String messageStreamType) { this.messageStreamType = messageStreamType; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }
    public Date getArchivedAt() { return archivedAt; }
    public void setArchivedAt(Date archivedAt) { this.archivedAt = archivedAt; }
    public SubscriptionManagementConfiguration getSubscriptionManagementConfiguration() { return subscriptionManagementConfiguration; }
    public void setSubscriptionManagementConfiguration(SubscriptionManagementConfiguration subscriptionManagementConfiguration) { this.subscriptionManagementConfiguration = subscriptionManagementConfiguration; }
}
