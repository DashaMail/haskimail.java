package ru.haskimail.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Построитель параметров запроса.
 * Используется для формирования query-строки URL.
 */
public class Parameters {

    private final Map<String, String> parameters;

    public Parameters() {
        this.parameters = new HashMap<>();
    }

    public Parameters build(String name, String value) {
        if (value != null) { parameters.put(name, value); }
        return this;
    }

    public Parameters build(String name, Boolean value) {
        if (value != null) { parameters.put(name, value.toString()); }
        return this;
    }

    public Parameters build(String name, Integer value) {
        if (value != null) { parameters.put(name, value.toString()); }
        return this;
    }

    public Parameters build(String name, Date value) {
        if (value != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            parameters.put(name, sdf.format(value));
        }
        return this;
    }

    @Override
    public String toString() {
        if (parameters.isEmpty()) return "";

        StringBuilder sb = new StringBuilder("?");
        boolean first = true;
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            if (!first) sb.append("&");
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
}
