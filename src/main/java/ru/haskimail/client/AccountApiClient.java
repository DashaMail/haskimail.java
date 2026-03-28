package ru.haskimail.client;

import ru.haskimail.client.data.model.RequestResponse;
import ru.haskimail.client.data.model.data_removal.DataRemoval;
import ru.haskimail.client.data.model.data_removal.DataRemovalStatus;
import ru.haskimail.client.data.model.domains.Domain;
import ru.haskimail.client.data.model.domains.DomainDetails;
import ru.haskimail.client.data.model.domains.Domains;
import ru.haskimail.client.data.model.senders.*;
import ru.haskimail.client.data.model.server.Server;
import ru.haskimail.client.data.model.servers.Servers;
import ru.haskimail.client.data.model.templates.TemplatesPush;
import ru.haskimail.client.data.model.templates.TemplatesPushRequest;
import ru.haskimail.client.exception.HaskimailException;

import java.io.IOException;
import java.util.Map;

/**
 * Клиент API Haskimail для работы на уровне аккаунта.
 *
 * Предоставляет методы для:
 * - Управления серверами
 * - Управления доменами
 * - Управления подписями отправителей
 * - Пуш шаблонов между серверами
 * - Удаления данных
 */
public class AccountApiClient extends BaseApiClient {

    private static final String ENDPOINT_SERVERS = "/servers";
    private static final String ENDPOINT_DOMAINS = "/domains";
    private static final String ENDPOINT_SENDERS = "/senders";
    private static final String ENDPOINT_TEMPLATES_PUSH = "/templates/push";
    private static final String ENDPOINT_DATA_REMOVALS = "/data-removals";

    public AccountApiClient(String baseUrl, Map<String, Object> headers) {
        super(baseUrl, headers);
    }

    public AccountApiClient(String baseUrl, Map<String, Object> headers, Boolean secureConnection) {
        super(baseUrl, headers, secureConnection);
    }

    // ========== Серверы ==========

    /**
     * Получить сервер по ID.
     */
    public Server getServer(Integer serverId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_SERVERS + "/" + serverId), Server.class);
    }

    /**
     * Создать сервер.
     */
    public Server createServer(Server server) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_SERVERS), Server.class, server);
    }

    /**
     * Обновить сервер.
     */
    public Server setServer(Integer serverId, Server server) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_SERVERS + "/" + serverId), Server.class, server);
    }

    /**
     * Получить список серверов.
     */
    public Servers getServers(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_SERVERS + parameters), Servers.class);
    }

    /**
     * Удалить сервер.
     */
    public RequestResponse deleteServer(Integer serverId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(ENDPOINT_SERVERS + "/" + serverId), RequestResponse.class);
    }

    // ========== Домены ==========

    /**
     * Получить список доменов.
     */
    public Domains getDomains() throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_DOMAINS), Domains.class);
    }

    /**
     * Получить детали домена.
     */
    public DomainDetails getDomainDetails(Integer domainId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId), DomainDetails.class);
    }

    /**
     * Создать домен.
     */
    public DomainDetails createDomain(Domain domain) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_DOMAINS), DomainDetails.class, domain);
    }

    /**
     * Обновить домен.
     */
    public DomainDetails setDomain(Integer domainId, Domain domain) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId), DomainDetails.class, domain);
    }

    /**
     * Удалить домен.
     */
    public RequestResponse deleteDomain(Integer domainId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId), RequestResponse.class);
    }

    /**
     * Проверить SPF для домена.
     */
    public DomainDetails verifyDomainSPF(Integer domainId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId + "/verifyspf"), DomainDetails.class);
    }

    /**
     * Ротация DKIM для домена.
     */
    public DomainDetails rotateDomainDKIM(Integer domainId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId + "/rotatedkim"), DomainDetails.class);
    }

    /**
     * Проверить Return-Path для домена.
     */
    public DomainDetails verifyDomainReturnPath(Integer domainId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId + "/verifyreturnpath"), DomainDetails.class);
    }

    /**
     * Проверить DKIM для домена.
     */
    public DomainDetails verifyDomainDKIM(Integer domainId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_DOMAINS + "/" + domainId + "/verifydkim"), DomainDetails.class);
    }

    // ========== Подписи отправителей ==========

    /**
     * Получить список подписей отправителей.
     */
    public Signatures getSenderSignatures(Parameters parameters) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_SENDERS + parameters), Signatures.class);
    }

    /**
     * Получить подпись отправителя по ID.
     */
    public SignatureDetails getSenderSignatureDetails(Integer signatureId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_SENDERS + "/" + signatureId), SignatureDetails.class);
    }

    /**
     * Создать подпись отправителя.
     */
    public SignatureDetails createSenderSignature(SignatureToCreate signature) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_SENDERS), SignatureDetails.class, signature);
    }

    /**
     * Обновить подпись отправителя.
     */
    public SignatureDetails setSenderSignature(Integer signatureId, SignatureToCreate signature) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_SENDERS + "/" + signatureId), SignatureDetails.class, signature);
    }

    /**
     * Удалить подпись отправителя.
     */
    public RequestResponse deleteSenderSignature(Integer signatureId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.DELETE, getEndpointUrl(ENDPOINT_SENDERS + "/" + signatureId), RequestResponse.class);
    }

    /**
     * Повторно отправить подтверждение подписи.
     */
    public RequestResponse resendSenderSignatureConfirmation(Integer signatureId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_SENDERS + "/" + signatureId + "/resend"), RequestResponse.class);
    }

    /**
     * Проверить SPF для подписи отправителя.
     */
    public SignatureDetails verifySenderSignatureSPF(Integer signatureId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_SENDERS + "/" + signatureId + "/verifyspf"), SignatureDetails.class);
    }

    /**
     * Запросить новый DKIM для подписи отправителя.
     */
    public RequestResponse requestNewSenderSignatureDKIM(Integer signatureId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_SENDERS + "/" + signatureId + "/requestnewdkim"), RequestResponse.class);
    }

    // ========== Пуш шаблонов ==========

    /**
     * Пуш шаблонов между серверами.
     */
    public TemplatesPush pushTemplates(TemplatesPushRequest request) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.PUT, getEndpointUrl(ENDPOINT_TEMPLATES_PUSH), TemplatesPush.class, request);
    }

    // ========== Удаление данных ==========

    /**
     * Создать запрос на удаление данных.
     */
    public DataRemovalStatus createDataRemoval(DataRemoval dataRemoval) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.POST, getEndpointUrl(ENDPOINT_DATA_REMOVALS), DataRemovalStatus.class, dataRemoval);
    }

    /**
     * Получить статус запроса на удаление данных.
     */
    public DataRemovalStatus getDataRemovalStatus(Integer dataRemovalId) throws HaskimailException, IOException {
        return execute(HttpClient.REQUEST_TYPES.GET, getEndpointUrl(ENDPOINT_DATA_REMOVALS + "/" + dataRemovalId), DataRemovalStatus.class);
    }
}
