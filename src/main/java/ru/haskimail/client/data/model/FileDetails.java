package ru.haskimail.client.data.model;

import org.apache.tika.Tika;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Вспомогательный класс для работы с файлами вложений.
 */
public class FileDetails {

    /**
     * Получить имя файла из пути.
     */
    public static String getFileName(String path) {
        return new File(path).getName();
    }

    /**
     * Получить содержимое файла в формате Base64.
     */
    public static String getFileContent(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(new File(path).toPath());
        return Base64.getEncoder().encodeToString(bytes);
    }

    /**
     * Определить MIME-тип файла.
     */
    public static String getFileContentType(String path) throws IOException {
        Tika tika = new Tika();
        return tika.detect(new File(path));
    }
}
