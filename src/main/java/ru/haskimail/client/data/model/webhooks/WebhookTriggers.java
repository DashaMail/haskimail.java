package ru.haskimail.client.data.model.webhooks;

import ru.haskimail.client.data.model.webhooks.triggers.*;

/**
 * Триггеры вебхука.
 */
public class WebhookTriggers {
    private OpenWebhookTrigger open;
    private WebhookTrigger click;
    private WebhookTrigger delivery;
    private BounceWebhookTrigger bounce;
    private SpamWebhookTrigger spamComplaint;
    private SubscriptionChange subscriptionChange;

    public OpenWebhookTrigger getOpen() { return open; }
    public void setOpen(OpenWebhookTrigger open) { this.open = open; }
    public WebhookTrigger getClick() { return click; }
    public void setClick(WebhookTrigger click) { this.click = click; }
    public WebhookTrigger getDelivery() { return delivery; }
    public void setDelivery(WebhookTrigger delivery) { this.delivery = delivery; }
    public BounceWebhookTrigger getBounce() { return bounce; }
    public void setBounce(BounceWebhookTrigger bounce) { this.bounce = bounce; }
    public SpamWebhookTrigger getSpamComplaint() { return spamComplaint; }
    public void setSpamComplaint(SpamWebhookTrigger spamComplaint) { this.spamComplaint = spamComplaint; }
    public SubscriptionChange getSubscriptionChange() { return subscriptionChange; }
    public void setSubscriptionChange(SubscriptionChange subscriptionChange) { this.subscriptionChange = subscriptionChange; }
}
