package ru.haskimail.unit;

import org.junit.jupiter.api.Test;
import ru.haskimail.client.data.model.message.Message;
import ru.haskimail.client.data.model.message.MessageResponse;
import ru.haskimail.client.data.model.stats.OutboundSendStats;
import ru.haskimail.client.data.parser.DataHandler;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для DataHandler (сериализация/десериализация JSON).
 */
class DataHandlerTest {

    private final DataHandler dataHandler = new DataHandler(false);

    @Test
    void сериализацияСообщенияВJson() throws Exception {
        Message message = new Message("from@test.ru", "to@test.ru", "Тема", "<b>Тело</b>");
        String json = dataHandler.toJson(message);

        assertNotNull(json);
        assertTrue(json.contains("from@test.ru"));
        assertTrue(json.contains("to@test.ru"));
        assertTrue(json.contains("Тема"));
    }

    @Test
    void десериализацияJsonВСообщение() throws Exception {
        String json = "{\"From\":\"from@test.ru\",\"To\":\"to@test.ru\",\"Subject\":\"Тема\"}";
        Message message = dataHandler.fromJson(json, Message.class);

        assertEquals("from@test.ru", message.getFrom());
        assertEquals("to@test.ru", message.getTo());
        assertEquals("Тема", message.getSubject());
    }

    @Test
    void десериализацияСНеизвестнымиПолями() throws Exception {
        String json = "{\"From\":\"test@test.ru\",\"UnknownField\":\"value\"}";
        Message message = dataHandler.fromJson(json, Message.class);

        assertEquals("test@test.ru", message.getFrom());
    }

    @Test
    void сериализацияUpperCamelCase() throws Exception {
        Message message = new Message();
        message.setFrom("test@test.ru");
        message.setHtmlBody("<p>Привет</p>");

        String json = dataHandler.toJson(message);
        assertTrue(json.contains("\"From\""));
        assertTrue(json.contains("\"HtmlBody\""));
    }

    @Test
    void десериализацияДатыБезВремени() throws Exception {
        //Статистика по дням (/stats/sends и другие) отдаёт Date как 2026-10-01
        OutboundSendStats stats = dataHandler.fromJson("{\"Days\":[{\"Date\":\"2026-10-01\",\"Sent\":44}]}", OutboundSendStats.class);
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(stats.getDays().get(0).getDate());
        assertEquals(2026, c.get(java.util.Calendar.YEAR));
        assertEquals(java.util.Calendar.OCTOBER, c.get(java.util.Calendar.MONTH));
        assertEquals(1, c.get(java.util.Calendar.DAY_OF_MONTH));
        //а дата со временем по-прежнему разбирается вместе со временем
        MessageResponse r = dataHandler.fromJson("{\"SubmittedAt\":\"2026-10-13 14:30:12\"}", MessageResponse.class);
        c.setTime(r.getSubmittedAt());
        assertEquals(14, c.get(java.util.Calendar.HOUR_OF_DAY));
        assertEquals(30, c.get(java.util.Calendar.MINUTE));
    }
}
