package com.brovada.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Locale;



@Document
public class JobConfig {
    @Id
    public String id;
    
    public String name;


   private StateTable stateTable = new StateTable();

   private StateRouting routing = new StateRouting();

   private TranslationTable translations = new TranslationTable();

   private Locale locale;

   private String dateFormat;

   private String currency;

   private String timeFormat;

   private String numberFormat;

   private Actions actions;


    public void setId(String id) {
        this.id = id;
    }

    public StateTable getStateTable() {
        return stateTable;
    }

    public void setStateTable(StateTable stateTable) {
        this.stateTable = stateTable;
    }

    public StateRouting getRouting() {
        return routing;
    }

    public void setRouting(StateRouting routing) {
        this.routing = routing;
    }

    public TranslationTable getTranslations() {
        return translations;
    }

    public void setTranslations(TranslationTable translations) {
        this.translations = translations;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public void setTimeFormat(String timeFormat) {
        this.timeFormat = timeFormat;
    }

    public String getNumberFormat() {
        return numberFormat;
    }

    public void setNumberFormat(String numberFormat) {
        this.numberFormat = numberFormat;
    }

    public Actions getActions() {
        return actions;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }
    // date formatting, currency formatting, is this driven by Locale?


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "JobConfig{" +
                "actions=" + actions +
                ", currency='" + currency + '\'' +
                ", dateFormat='" + dateFormat + '\'' +
                ", id='" + id + '\'' +
                ", locale=" + locale +
                ", numberFormat='" + numberFormat + '\'' +
                ", routing=" + routing +
                ", stateTable=" + stateTable +
                ", timeFormat='" + timeFormat + '\'' +
                ", translations=" + translations +
                '}';
    }
}
