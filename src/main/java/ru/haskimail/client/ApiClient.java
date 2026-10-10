package ru.haskimail.client;

import ru.haskimail.client.data.model.RequestResponse;
import ru.haskimail.client.data.model.bounces.*;
import ru.haskimail.client.data.model.message.Message;
import ru.haskimail.client.data.model.message.MessageResponse;
import ru.haskimail.client.data.model.messages.*;
import ru.haskimail.client.data.model.stats.*;
import ru.haskimail.client.data.model.streams.*;
import ru.haskimail.client.data.model.suppressions.*;
import ru.haskimail.client.data.model.templates.*;
import ru.haskimail.client.data.model.webhooks.Webhook;
import ru.haskimail.client.data.model.webhooks.Webhooks;
import ru.haskimail.client.exception.HaskimailException;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Основной клиент API Haskimail для работы на уровне сервера.
 *
 * Предоставляет методы для:
 * - Отправки email-сообщений
 * - Управления шаблонами
 * - Работы с отказами доставки (bounces)
 * - Получения статистики
 * - Управления вебхуками
 * - Управления стоп-списками (suppressions)
 * - Управления каналами (message streams)
 */
public class ApiClient extends BaseApiClient {

    // Эндпоинты отправки
    private static final String ENDPOINT_EMAIL = "/email";
    private static final String ENDPOINT_EMAIL_WITH_TEMPLATE = "/email/withTemplate";

    // Эндпоинты отказов доставки
    private static final String ENDPOINT_BOUNCES = "/bounces";
    private static final String ENDPOINT_DELIVERY_STATS = "/deliverystats";

    // Эндпоинты шаблонов
    private static final String ENDPOINT_TEMPLATES = "/templates";

    // Эндпоинты сообщений
    private static final String ENDPOINT_MESSAGES = "/messages";
    private static final String ENDPOINT_MESSAGES_OPENS = "/messages/opens";
    private static final String ENDPOINT_MESSAGES_CLICKS = "/messages/clicks";

    // Эндпоинты статистики
    private static final String ENDPOINT_STATS = "/stats";
    private static final String ENDPOINT_STATS_SENDS = "/stats/sends";
    private static final String ENDPOINT_STATS_BOUNCES = "/stats/bounces";
    private static final String ENDPOINT_STATS_SPAM = "/stats/spam";
    private static final String ENDPOINT_STATS_OPENS = "/stats/opens";
    private static final String ENDPOINT_STATS_CLICKS = "/stats/clicks";

    // Эндпоинты вебхуков
    private static final String ENDPOINT_WEBHOOKS = "/webhooks";

    // Эндпоинты каналов (Message Streams)
    private static final String ENDPOINT_MESSAGE_STREAMS = "/message-streams";

    // Эндпоинты стоп-списков (Suppressions)
    private static final String ENDPOINT_SUPPRESSIONS = "/suppressions";

    public ApiClient(String baseUrl, Map<String, Object> headers) {
        super(baseUrl, headers);
    }

    public ApiClient(String baseUrl, Map<String, Object> headers, Boolean secureConnection) {
        super(baseUrl, headers, secureConnection);
    }

    // ========== Отправка сообщений ==========

    /**
     * Отправить email-сообщение.
     */
    public MessageResponse deliverMessage(Message message) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_EMAIL), MessageResponse.class, message);
    }

    /**
     * Отправить сообщение по шаблону.
     */
    public MessageResponse deliverMessageWithTemplate(TemplatedMessage message) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_EMAIL_WITH_TEMPLATE), MessageResponse.class, message);
    }

    // ========== Отказы доставки (Bounces) ==========

    /**
     * Получить список отказов доставки.
     */
    public Bounces getBounces(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_BOUNCES + parameters), Bounces.class);
    }

    /**
     * Получить статистику доставки.
     */
    public DeliveryStats getDeliveryStats() throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_DELIVERY_STATS), DeliveryStats.class);
    }

    // ========== Шаблоны ==========

    /**
     * Получить шаблон по ID.
     */
    public Template getTemplate(Integer templateId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_TEMPLATES + "/" + templateId), Template.class);
    }

    /**
     * Получить шаблон по алиасу.
     */
    public Template getTemplate(String templateAlias) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_TEMPLATES + "/" + templateAlias), Template.class);
    }

    /**
     * Создать шаблон.
     */
    public Template createTemplate(Template template) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_TEMPLATES), Template.class, template);
    }

    /**
     * Обновить шаблон по ID.
     */
    public Template setTemplate(Integer templateId, Template template) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_TEMPLATES + "/" + templateId), Template.class, template);
    }

    /**
     * Обновить шаблон по алиасу.
     */
    public Template setTemplate(String templateAlias, Template template) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_TEMPLATES + "/" + templateAlias), Template.class, template);
    }

    /**
     * Получить список шаблонов.
     */
    public Templates getTemplates(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_TEMPLATES + parameters), Templates.class);
    }

    /**
     * Удалить шаблон по ID.
     */
    public RequestResponse deleteTemplate(Integer templateId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(ENDPOINT_TEMPLATES + "/" + templateId), RequestResponse.class);
    }

    /**
     * Удалить шаблон по алиасу.
     */
    public RequestResponse deleteTemplate(String templateAlias) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(ENDPOINT_TEMPLATES + "/" + templateAlias), RequestResponse.class);
    }

    // ========== Исходящие сообщения ==========

    /**
     * Получить список исходящих сообщений.
     */
    public OutboundMessages getMessages(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGES + parameters), OutboundMessages.class);
    }

    /**
     * Получить детали исходящего сообщения.
     */
    public OutboundMessageDetails getMessageDetails(String messageId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGES + "/" + messageId + "/details"), OutboundMessageDetails.class);
    }

    /**
     * Получить открытия сообщений.
     */
    public OutboundMessageOpens getMessageOpens(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGES_OPENS + parameters), OutboundMessageOpens.class);
    }

    /**
     * Получить открытия конкретного сообщения.
     */
    public OutboundMessageOpens getMessageOpens(String messageId, Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGES_OPENS + "/" + messageId + parameters), OutboundMessageOpens.class);
    }

    /**
     * Получить клики по ссылкам.
     */
    public OutboundMessageClicks getMessageClicks(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGES_CLICKS + parameters), OutboundMessageClicks.class);
    }

    /**
     * Получить клики конкретного сообщения.
     */
    public OutboundMessageClicks getMessageClicks(String messageId, Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGES_CLICKS + "/" + messageId + parameters), OutboundMessageClicks.class);
    }

    // ========== Статистика ==========

    /**
     * Получить общую статистику исходящих сообщений.
     */
    public OutboundStats getOutboundStats(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_STATS + parameters), OutboundStats.class);
    }

    /**
     * Получить статистику отправок.
     */
    public OutboundSendStats getSendStats(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_STATS_SENDS + parameters), OutboundSendStats.class);
    }

    /**
     * Получить статистику отказов доставки.
     */
    public OutboundBounceStats getBounceStats(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_STATS_BOUNCES + parameters), OutboundBounceStats.class);
    }

    /**
     * Получить статистику жалоб на спам.
     */
    public OutboundSpamStats getSpamStats(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_STATS_SPAM + parameters), OutboundSpamStats.class);
    }

    /**
     * Получить статистику открытий.
     */
    public OutboundOpenStats getOpenStats(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_STATS_OPENS + parameters), OutboundOpenStats.class);
    }

    /**
     * Получить статистику кликов.
     */
    public OutboundClickStats getClickStats(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_STATS_CLICKS + parameters), OutboundClickStats.class);
    }

    // ========== Вебхуки ==========

    /**
     * Получить список вебхуков.
     */
    public Webhooks getWebhooks(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_WEBHOOKS + parameters), Webhooks.class);
    }

    /**
     * Получить вебхук по ID.
     */
    public Webhook getWebhook(Integer webhookId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_WEBHOOKS + "/" + webhookId), Webhook.class);
    }

    /**
     * Создать вебхук.
     */
    public Webhook createWebhook(Webhook webhook) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_WEBHOOKS), Webhook.class, webhook);
    }

    /**
     * Обновить вебхук.
     */
    public Webhook setWebhook(Integer webhookId, Webhook webhook) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_WEBHOOKS + "/" + webhookId), Webhook.class, webhook);
    }

    /**
     * Удалить вебхук.
     */
    public RequestResponse deleteWebhook(Integer webhookId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(ENDPOINT_WEBHOOKS + "/" + webhookId), RequestResponse.class);
    }

    // ========== Стоп-списки (Suppressions) ==========

    /**
     * Создать записи в стоп-списке.
     *
     * @param messageStream идентификатор канала
     * @param entries записи для добавления в стоп-список
     */
    public SuppressionStatuses createSuppressions(String messageStream, SuppressionEntries entries) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST,
                getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStream + ENDPOINT_SUPPRESSIONS),
                SuppressionStatuses.class, entries);
    }

    /**
     * Получить записи стоп-списка.
     *
     * @param messageStream идентификатор канала
     */
    public Suppressions getSuppressions(String messageStream, Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET,
                getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStream + ENDPOINT_SUPPRESSIONS + parameters),
                Suppressions.class);
    }

    /**
     * Удалить записи из стоп-списка.
     *
     * @param messageStream идентификатор канала
     * @param entries записи для удаления из стоп-списка
     */
    public SuppressionStatuses deleteSuppressions(String messageStream, SuppressionEntries entries) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST,
                getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStream + ENDPOINT_SUPPRESSIONS + "/delete"),
                SuppressionStatuses.class, entries);
    }

    // ========== Каналы (Message Streams) ==========

    /**
     * Получить список каналов.
     */
    public MessageStreams getMessageStreams() throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGE_STREAMS), MessageStreams.class);
    }

    /**
     * Получить канал по ID.
     */
    public MessageStream getMessageStream(String messageStreamId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStreamId), MessageStream.class);
    }

    /**
     * Создать канал.
     */
    public MessageStream createMessageStream(MessageStream messageStream) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_MESSAGE_STREAMS), MessageStream.class, messageStream);
    }

    /**
     * Обновить канал.
     */
    public MessageStream setMessageStream(String messageStreamId, MessageStream messageStream) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PATCH, getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStreamId), MessageStream.class, messageStream);
    }

    /**
     * Архивировать канал.
     */
    public MessageStreamArchiveResponse archiveMessageStream(String messageStreamId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST,
                getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStreamId + "/archive"),
                MessageStreamArchiveResponse.class);
    }

    /**
     * Разархивировать канал.
     */
    public MessageStreamUnarchiveResponse unarchiveMessageStream(String messageStreamId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST,
                getEndpointUrl(ENDPOINT_MESSAGE_STREAMS + "/" + messageStreamId + "/unarchive"),
                MessageStreamUnarchiveResponse.class);
    }
}
