package ru.haskimail.unit;

import org.junit.jupiter.api.Test;
import ru.haskimail.client.data.model.message.Message;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для модели сообщения.
 */
class MessageTest {

    @Test
    void конструкторСПолнымНаборомПараметров() {
        Message msg = new Message("from@test.ru", "to@test.ru", "Тема", "<b>HTML</b>", "Текст");
        assertEquals("from@test.ru", msg.getFrom());
        assertEquals("to@test.ru", msg.getTo());
        assertEquals("Тема", msg.getSubject());
        assertEquals("<b>HTML</b>", msg.getHtmlBody());
        assertEquals("Текст", msg.getTextBody());
    }

    @Test
    void добавлениеЗаголовков() {
        Message msg = new Message();
        msg.addHeader("X-Custom", "value1");
        msg.addHeader("X-Another", "value2");
        assertEquals(2, msg.getHeaders().size());
        assertEquals("X-Custom", msg.getHeaders().get(0).getName());
    }

    @Test
    void очисткаЗаголовков() {
        Message msg = new Message();
        msg.addHeader("X-Custom", "value");
        msg.clearHeaders();
        assertEquals(0, msg.getHeaders().size());
    }

    @Test
    void конвертацияПолучателейИзMap() {
        Message msg = new Message();
        Map<String, String> recipients = new LinkedHashMap<>();
        recipients.put("Иван Иванов", "ivan@test.ru");
        msg.setTo(recipients);
        assertTrue(msg.getTo().contains("ivan@test.ru"));
        assertTrue(msg.getTo().contains("Иван Иванов"));
    }

    @Test
    void добавлениеМетаданных() {
        Message msg = new Message();
        msg.addMetadata("key1", "value1");
        msg.addMetadata("key2", "value2");
        assertEquals(2, msg.getMetadata().size());
        assertEquals("value1", msg.getMetadata().get("key1"));
    }

    @Test
    void добавлениеВложенийИзБайтов() {
        Message msg = new Message();
        msg.addAttachment("test.txt", "содержимое".getBytes(), "text/plain");
        assertEquals(1, msg.getAttachments().size());
        assertEquals("test.txt", msg.getAttachments().get(0).get("Name"));
        assertEquals("text/plain", msg.getAttachments().get(0).get("ContentType"));
    }

    @Test
    void добавлениеВстроенногоИзображения() {
        Message msg = new Message();
        msg.addAttachment("image.png", "imagedata".getBytes(), "image/png", "cid:image1");
        assertEquals("cid:image1", msg.getAttachments().get(0).get("ContentId"));
    }

    @Test
    void установкаОтслеживанияСсылок() {
        Message msg = new Message();
        msg.setTrackLinks(Message.TRACK_LINKS.HtmlAndText.value);
        assertEquals("HtmlAndText", msg.getTrackLinks());
    }

    @Test
    void установкаКанала() {
        Message msg = new Message();
        msg.setMessageStream("outbound");
        assertEquals("outbound", msg.getMessageStream());
    }
}
