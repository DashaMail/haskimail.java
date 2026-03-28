package ru.haskimail.client.data.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.module.SimpleModule;
import ru.haskimail.client.data.parser.jackson.CustomDateDeserializer;

import java.io.IOException;
import java.util.Date;

/**
 * Обработчик данных для сериализации/десериализации JSON.
 * Использует Jackson ObjectMapper с настройкой UpperCamelCase.
 */
public class DataHandler {

    private final ObjectMapper mapper;

    public DataHandler(boolean strict) {
        this.mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.UPPER_CAMEL_CASE);
        if (!strict) {
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }

        // Регистрация глобального десериализатора дат для всех форматов API Haskimail
        SimpleModule dateModule = new SimpleModule();
        dateModule.addDeserializer(Date.class, new CustomDateDeserializer());
        mapper.registerModule(dateModule);
    }

    public String toJson(Object data) throws JsonProcessingException {
        return mapper.writeValueAsString(data);
    }

    public <T> T fromJson(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }

    public ObjectMapper getMapper() { return mapper; }
}
