package ru.haskimail.integration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import ru.haskimail.client.ApiClient;
import ru.haskimail.client.Parameters;
import ru.haskimail.client.data.model.templates.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Интеграционные тесты для работы с шаблонами.
 */
@EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_TOKEN", matches = ".+")
class TemplateTest extends BaseTest {

    @Test
    void получениеСпискаШаблонов() throws Exception {
        ApiClient client = getApiClient();
        Templates templates = client.getTemplates(new Parameters().build("count", 10).build("offset", 0));
        assertNotNull(templates);
        assertNotNull(templates.getTotalCount());
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "HASKIMAIL_SERVER_ID", matches = ".+")
    void созданиеИУдалениеШаблона() throws Exception {
        ApiClient client = getApiClient();

        Template template = new Template();
        template.setName("Тестовый шаблон Java " + System.currentTimeMillis());
        template.setSubject("Тестовая тема {{product_name}}");
        template.setHtmlBody("<html><body>Привет, {{name}}!</body></html>");
        template.setTextBody("Привет, {{name}}!");
        template.setAssociatedServerId(Integer.parseInt(SERVER_ID));

        Template created = client.createTemplate(template);
        assertNotNull(created);
        assertNotNull(created.getTemplateId());
        assertEquals(template.getName(), created.getName());

        // Получение
        Template fetched = client.getTemplate(created.getTemplateId());
        assertNotNull(fetched);
        assertEquals(template.getName(), fetched.getName());
        assertEquals(template.getSubject(), fetched.getSubject());

        // Удаление
        client.deleteTemplate(created.getTemplateId());
    }
}
