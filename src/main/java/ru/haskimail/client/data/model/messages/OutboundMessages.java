package ru.haskimail.client.data.model.messages;

import java.util.List;

public class OutboundMessages {
    private Integer totalCount;
    private List<OutboundMessage> messages;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public List<OutboundMessage> getMessages() { return messages; }
    public void setMessages(List<OutboundMessage> messages) { this.messages = messages; }
}
