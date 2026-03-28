package ru.haskimail.unit;

import org.junit.jupiter.api.Test;
import ru.haskimail.client.Parameters;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit-тесты для построителя параметров запроса.
 */
class ParametersTest {

    @Test
    void пустыеПараметры() {
        Parameters params = new Parameters();
        assertEquals("", params.toString());
    }

    @Test
    void строковыйПараметр() {
        Parameters params = new Parameters();
        params.build("tag", "test");
        String result = params.toString();
        assertTrue(result.contains("tag=test"));
        assertTrue(result.startsWith("?"));
    }

    @Test
    void числовойПараметр() {
        Parameters params = new Parameters();
        params.build("count", 25);
        assertTrue(params.toString().contains("count=25"));
    }

    @Test
    void булевыйПараметр() {
        Parameters params = new Parameters();
        params.build("trackOpens", true);
        assertTrue(params.toString().contains("trackOpens=true"));
    }

    @Test
    void несколькоПараметров() {
        Parameters params = new Parameters();
        params.build("count", 10).build("offset", 0).build("tag", "test");
        String result = params.toString();
        assertTrue(result.contains("count=10"));
        assertTrue(result.contains("offset=0"));
        assertTrue(result.contains("tag=test"));
    }

    @Test
    void nullЗначенияИгнорируются() {
        Parameters params = new Parameters();
        params.build("tag", (String) null);
        assertEquals("", params.toString());
    }
}
