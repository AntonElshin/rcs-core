package ru.rcs.service;

public interface MessageService {

    String getLocalizedMessage(String key);

    void setLanguageTag(String languageTag);

    String getLanguageTag();

    String getLocalizedMessage(String property, String... parameters);
}
