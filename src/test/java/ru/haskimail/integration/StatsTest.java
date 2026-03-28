package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.stats.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для получения статистики.
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class StatsTest extends BaseTest {

    @Test
    void получениеОбщейСтатистики() throws Exception {
        ApiClient client = getApiClient();
        OutboundStats stats = client.getOutboundStats(new Parameters());
        assertNotNull(stats);
    }

    @Test
    void получениеСтатистикиОтправок() throws Exception {
        ApiClient client = getApiClient();
        OutboundSendStats stats = client.getSendStats(new Parameters());
        assertNotNull(stats);
    }

    @Test
    void получениеСтатистикиОтказов() throws Exception {
        ApiClient client = getApiClient();
        OutboundBounceStats stats = client.getBounceStats(new Parameters());
        assertNotNull(stats);
    }
}
