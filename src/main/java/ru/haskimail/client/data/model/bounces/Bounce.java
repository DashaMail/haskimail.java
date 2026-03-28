package ru.haskimail.client.data.model.bounces;

import java.util.Date;

/**
 * Модель отказа доставки (bounce).
 */
public class Bounce {
    private Integer id;
    private String messageId;
    private Integer serverId;
    private String type;
    private Integer typeCode;
    private Date bouncedAt;
    private Boolean dumpAvailable;
    private String email;
    private String from;
    private String subject;
    private String content;
    private Boolean inactive;
    private Boolean canActivate;
    private String name;
    private String tag;
    private String description;
    private String details;
    private String recordType;
    /** Канал сообщения */
    private String messageStream;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }
    public Integer getServerId() { return serverId; }
    public void setServerId(Integer serverId) { this.serverId = serverId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public Integer getTypeCode() { return typeCode; }
    public void setTypeCode(Integer typeCode) { this.typeCode = typeCode; }
    public Date getBouncedAt() { return bouncedAt; }
    public void setBouncedAt(Date bouncedAt) { this.bouncedAt = bouncedAt; }
    public Boolean getDumpAvailable() { return dumpAvailable; }
    public void setDumpAvailable(Boolean dumpAvailable) { this.dumpAvailable = dumpAvailable; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getFrom() { return from; }
    public void setFrom(String from) { this.from = from; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Boolean getInactive() { return inactive; }
    public void setInactive(Boolean inactive) { this.inactive = inactive; }
    public Boolean getCanActivate() { return canActivate; }
    public void setCanActivate(Boolean canActivate) { this.canActivate = canActivate; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public String getRecordType() { return recordType; }
    public void setRecordType(String recordType) { this.recordType = recordType; }
    public String getMessageStream() { return messageStream; }
    public void setMessageStream(String messageStream) { this.messageStream = messageStream; }
}
