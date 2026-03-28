package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.bounces.Bounces;
import ru.haskimail.client.data.model.bounces.DeliveryStats;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для работы с отказами доставки.
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class BounceTest extends BaseTest {

    @Test
    void получениеСпискаОтказов() throws Exception {
        ApiClient client = getApiClient();
        Parameters params = new Parameters();
        params.build("count", 10).build("offset", 0);

        Bounces bounces = client.getBounces(params);
        assertNotNull(bounces);
        assertNotNull(bounces.getTotalCount());
    }

    @Test
    void получениеСтатистикиДоставки() throws Exception {
        ApiClient client = getApiClient();
        DeliveryStats stats = client.getDeliveryStats();
        assertNotNull(stats);
    }
}
