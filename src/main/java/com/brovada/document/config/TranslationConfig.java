package com.brovada.document.config;

import com.google.common.collect.Maps;

import java.util.Locale;
import java.util.Map;

public class TranslationConfig {

    private Map<Locale, Map<String, String>> translationsTable = Maps.newHashMap();
    private Locale defaultLocale = Locale.getDefault();

    public TranslationConfig withTranslationsFor(Locale locale, Map<String, String> translations) {
        translationsTable.put(locale, translations);
        return this;
    }

    public String get(String key) {
        String value = translationsTable.get(defaultLocale).get(key);
        return value==null ? key : value;
    }
    
    public String get(String key, Locale locale) {
        String value = translationsTable.get(locale).get(key);
        return value==null ? key : value;
    }

    public TranslationConfig withDefaultLocale(Locale locale) {
        this.defaultLocale = locale;
        return this;
    }

}
