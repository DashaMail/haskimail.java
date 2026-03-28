package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.suppressions.Suppressions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для работы со стоп-списками (suppressions).
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class SuppressionTest extends BaseTest {

    @Test
    void получениеСтопСписка() throws Exception {
        ApiClient client = getApiClient();
        Suppressions suppressions = client.getSuppressions("outbound", new Parameters());
        assertNotNull(suppressions);
    }
}
