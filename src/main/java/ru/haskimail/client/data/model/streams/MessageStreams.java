package ru.haskimail.client.data.model.streams;

/**
 * Коллекция каналов сообщений.
 */
public class MessageStreams {
    private Integer totalCount;
    private MessageStream[] messageStreams;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public MessageStream[] getMessageStreams() { return messageStreams; }
    public void setMessageStreams(MessageStream[] messageStreams) { this.messageStreams = messageStreams; }
}
