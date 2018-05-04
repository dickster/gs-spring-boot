package com.brovada.document;

import java.util.Locale;

public final class JobConfigBuilder {
    public String id;
    private VersionFoo version;
    private StateTable stateTable;
    private StateRouting routing;
    private TranslationTable translations;
    private Locale locale;
    private String dateFormat;
    private String currency;
    private String timeFormat;
    private String numberFormat;
    private Actions actions;

    private JobConfigBuilder() {
    }

    public static JobConfigBuilder aJobConfig() {
        return new JobConfigBuilder();
    }

    
    public JobConfigBuilder withStateTable(StateTable stateTable) {
        this.stateTable = stateTable;
        return this;
    }

    public JobConfigBuilder withRouting(StateRouting routing) {
        this.routing = routing;
        return this;
    }

    public JobConfigBuilder withTranslations(TranslationTable translations) {
        this.translations = translations;
        return this;
    }

    public JobConfigBuilder withLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    public JobConfigBuilder withDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public JobConfigBuilder withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public JobConfigBuilder withTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
        return this;
    }

    public JobConfigBuilder withNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
        return this;
    }

    public JobConfigBuilder withActions(Actions actions) {
        this.actions = actions;
        return this;
    }

    public JobConfig build() {
        JobConfig jobConfig = new JobConfig();
        jobConfig.setId(id);
        jobConfig.setStateTable(stateTable);
        jobConfig.setRouting(routing);
        jobConfig.setTranslations(translations);
        jobConfig.setLocale(locale);
        jobConfig.setDateFormat(dateFormat);
        jobConfig.setCurrency(currency);
        jobConfig.setTimeFormat(timeFormat);
        jobConfig.setNumberFormat(numberFormat);
        jobConfig.setActions(actions);
        return jobConfig;
    }
}
