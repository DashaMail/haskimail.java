package ru.haskimail.client.data.model.senders;

import java.util.List;

/**
 * Коллекция подписей отправителей.
 */
public class Signatures {
    private Integer totalCount;
    private List<Signature> senderSignatures;

    public Integer getTotalCount() { return totalCount; }
    public void setTotalCount(Integer totalCount) { this.totalCount = totalCount; }
    public List<Signature> getSenderSignatures() { return senderSignatures; }
    public void setSenderSignatures(List<Signature> senderSignatures) { this.senderSignatures = senderSignatures; }
}
