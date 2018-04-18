package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AutocompleteConfig<T> extends InputConfig<T> {

    private ChoiceProvider<T> choiceProvider;

    public AutocompleteConfig(String formControlName) {
        super(ComponentType.AUTOCOMPLETE, formControlName);
    }

    public AutocompleteConfig withRemoteChoices(String url) {
        this.choiceProvider = new RemoteChoiceProvider<>().withUrl(url);
        return this;
    }

    public boolean isRemote() {
        return choiceProvider instanceof RemoteChoiceProvider;
    }

}
