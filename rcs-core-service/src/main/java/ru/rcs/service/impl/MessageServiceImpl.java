package ru.rcs.service.impl;

import java.util.Locale;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.stereotype.Service;
import ru.rcs.service.MessageService;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageSource messageSource;

    @Value("${language-tag}")
    private String LanguageTag = "";

    @Override
    public String getLocalizedMessage(String key) {
        return messageSource.getMessage(key, null, Locale.forLanguageTag(LanguageTag));
    }

    @Override
    public void setLanguageTag(String languageTag) {
        LanguageTag = languageTag;
    }

    @Override
    public String getLanguageTag() {
        return LanguageTag;
    }

    @Override
    public String getLocalizedMessage(String property, String... parameters) {
        try {
            return messageSource.getMessage(property, parameters, Locale.forLanguageTag(LanguageTag));
        } catch (NoSuchMessageException e) {
            log.debug("Error while translating message by key {}", property);
            return property;
        }
    }
}
