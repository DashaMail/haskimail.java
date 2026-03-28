<a href="https://haskimail.ru">
    <img src="https://github.com/DashaMail/haskimail.java/raw/main/haskimail.png" alt="Haskimail Logo" title="Haskimail" width="120" height="120" align="right">
</a>

# Haskimail Java

Официальная Java-библиотека для работы с [API Haskimail](https://api.haskimail.ru/) — сервиса транзакционной электронной почты.

## Установка

### Maven

```xml
<dependency>
    <groupId>ru.haskimail</groupId>
    <artifactId>haskimail</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'ru.haskimail:haskimail:1.0.0'
```

## Быстрый старт

### Отправка email-сообщения

```java
import ru.haskimail.Haskimail;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.data.model.message.Message;
import ru.haskimail.client.data.model.message.MessageResponse;

// Создание клиента
ApiClient client = Haskimail.getApiClient("ваш-серверный-токен");

// Создание и отправка сообщения
Message message = new Message(
    "отправитель@домен.ru",
    "получатель@домен.ru",
    "Тема письма",
    "<h1>Привет!</h1><p>Это письмо отправлено через Haskimail.</p>"
);

MessageResponse response = client.deliverMessage(message);
System.out.println("ID сообщения: " + response.getMessageId());
```

### Отправка с отслеживанием

```java
Message message = new Message("от@домен.ru", "кому@домен.ru", "Тема", "<p>Тело</p>");
message.setTrackOpens(true);
message.setTrackLinks(Message.TRACK_LINKS.HtmlAndText.value);
message.addMetadata("campaign", "welcome");

client.deliverMessage(message);
```

### Отправка по шаблону

> **Примечание:** API шаблонов (создание, получение, удаление) находится в разработке и пока не активен. Отправка по шаблону и получение списка шаблонов работают.

```java
import ru.haskimail.client.data.model.templates.TemplatedMessage;
import java.util.HashMap;

TemplatedMessage message = new TemplatedMessage();
message.setTemplateId(12345);
message.setFrom("от@домен.ru");
message.setTo("кому@домен.ru");

HashMap<String, Object> model = new HashMap<>();
model.put("name", "Иван");
model.put("product", "Haskimail");
message.setTemplateModel(model);

client.deliverMessageWithTemplate(message);
```

### Работа с каналами

Каналы (Message Streams) позволяют разделять потоки транзакционных и маркетинговых сообщений.

```java
import ru.haskimail.client.data.model.streams.MessageStreams;

// Получить список каналов
MessageStreams streams = client.getMessageStreams();

// Отправить сообщение через определённый канал
Message message = new Message("от@домен.ru", "кому@домен.ru", "Тема", "<p>Тело</p>");
message.setMessageStream("outbound");
client.deliverMessage(message);
```

### Стоп-списки

Стоп-списки (Suppressions) позволяют управлять адресами, на которые не должны отправляться сообщения.

```java
import ru.haskimail.client.data.model.suppressions.*;

// Получить записи стоп-списка для канала
Suppressions suppressions = client.getSuppressions("outbound", new Parameters());

// Добавить адреса в стоп-список
SuppressionEntries entries = new SuppressionEntries("spam@example.com", "bounce@example.com");
client.createSuppressions("outbound", entries);

// Удалить адреса из стоп-списка
client.deleteSuppressions("outbound", entries);
```

### Статистика

```java
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.stats.*;

Parameters params = new Parameters();
params.build("tag", "welcome");

OutboundStats stats = client.getOutboundStats(params);
System.out.println("Отправлено: " + stats.getSent());
System.out.println("Открыто: " + stats.getOpens());
```

### Управление вебхуками

```java
import ru.haskimail.client.data.model.webhooks.*;

// Создать вебхук
Webhook webhook = new Webhook("https://ваш-домен.ru/webhook");
client.createWebhook(webhook);

// Получить список вебхуков
Webhooks webhooks = client.getWebhooks(new Parameters());
```

## Клиент аккаунта

Для операций на уровне аккаунта (управление серверами, доменами, подписями) используйте `AccountApiClient`:

```java
import ru.haskimail.Haskimail;
import ru.haskimail.client.AccountApiClient;

AccountApiClient accountClient = Haskimail.getAccountApiClient("ваш-аккаунт-токен");

// Управление серверами
Server server = accountClient.getServer(1234);

// Управление доменами
Domains domains = accountClient.getDomains();
```

## Настройка

### Пользовательский URL API

```java
ApiClient client = Haskimail.getApiClient("токен", true, "custom.api.haskimail.ru");
```

### Таймауты

```java
ApiClient client = Haskimail.getApiClient("токен");
client.setConnectTimeoutSeconds(30);
client.setReadTimeoutSeconds(30);
```

### HTTP без SSL

```java
ApiClient client = Haskimail.getApiClient("токен", false);
```

## Обработка ошибок

Библиотека использует типизированные исключения:

| Исключение | HTTP-код | Описание |
|---|---|---|
| `InvalidAPIKeyException` | 401 | Неверный API-ключ |
| `InvalidMessageException` | 422 | Невалидное сообщение |
| `TimeoutException` | 408 | Таймаут запроса |
| `InternalServerException` | 500 | Внутренняя ошибка сервера |
| `UnknownException` | Прочие | Неизвестная ошибка |

```java
try {
    client.deliverMessage(message);
} catch (InvalidMessageException e) {
    System.err.println("Ошибка: " + e.getMessage() + " (код: " + e.getErrorCode() + ")");
} catch (HaskimailException e) {
    System.err.println("Ошибка API: " + e.getMessage());
}
```

## Требования

- Java 8 или выше
- Apache HttpClient 5.x

## Лицензия

MIT License. Подробности в файле [LICENSE](LICENSE).
