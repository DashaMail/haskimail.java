# Отправка email-сообщений

## Простое сообщение

```java
import ru.haskimail.client.data.model.message.Message;
import ru.haskimail.client.data.model.message.MessageResponse;

Message message = new Message(
    "от@домен.ru",
    "кому@домен.ru",
    "Тема письма",
    "<h1>HTML-тело</h1>",
    "Текстовое тело"
);

MessageResponse response = client.deliverMessage(message);
```

## Отслеживание открытий и ссылок

```java
Message message = new Message("от@домен.ru", "кому@домен.ru", "Тема", "<p>Тело</p>");
message.setTrackOpens(true);
message.setTrackLinks(Message.TRACK_LINKS.HtmlAndText.value);
```

Доступные режимы отслеживания ссылок:
- `Html` — только в HTML-теле
- `Text` — только в текстовом теле
- `HtmlAndText` — в обоих

## Метаданные

Метаданные позволяют прикреплять пользовательские данные к сообщениям для последующего анализа.

```java
message.addMetadata("campaign_id", "12345");
message.addMetadata("user_id", "67890");
```

## Теги

Теги помогают категоризировать сообщения:

```java
message.setTag("password-reset");
```

## Каналы

Указать канал для отправки:

```java
message.setMessageStream("outbound");
```

## Пользовательские заголовки

```java
message.addHeader("X-Custom-Header", "значение");
message.addHeader("X-PM-Tag", "my-tag");
```

## Вложения

### Из файла

```java
message.addAttachment("/path/to/file.pdf");
```

### Из байтов

```java
byte[] content = Files.readAllBytes(Paths.get("file.pdf"));
message.addAttachment("file.pdf", content, "application/pdf");
```

### Встроенные изображения

```java
message.addAttachment("/path/to/image.png", "cid:logo");
message.setHtmlBody("<img src='cid:logo' />");
```

## Множественные получатели

### Простой список (через запятую)

```java
message.setTo("first@test.ru, second@test.ru");
```

### С именами

```java
Map<String, String> recipients = new LinkedHashMap<>();
recipients.put("Иван Иванов", "ivan@test.ru");
recipients.put("Пётр Петров", "petr@test.ru");
message.setTo(recipients);
```

## Пакетная отправка

Отправка до 500 сообщений за один вызов:

```java
List<Message> messages = new ArrayList<>();
messages.add(new Message("от@домен.ru", "кому1@домен.ru", "Тема 1", "<p>Тело 1</p>"));
messages.add(new Message("от@домен.ru", "кому2@домен.ru", "Тема 2", "<p>Тело 2</p>"));

List<MessageResponse> responses = client.deliverMessage(messages);
```

## Ответ на отправку

Объект `MessageResponse` содержит:

| Поле | Описание |
|---|---|
| `errorCode` | Код ошибки (0 = успех) |
| `message` | Текст сообщения/ошибки |
| `messageId` | Уникальный ID сообщения |
| `to` | Получатель |
| `submittedAt` | Время отправки |
