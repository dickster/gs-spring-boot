package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.Map;

@Document
public class DropDownConfig<T> extends InputConfig<T> implements HasValidation {

    // TODO : create default choice provider.  (will return  "Provider not installed" choice).
    private @Nonnull ChoiceProvider<T> choiceProvider = new ChoiceProvider<T>() {};

    public DropDownConfig(String formControlName) {
        super(ComponentType.DROP_DOWN, formControlName);
    }

    public DropDownConfig withInlineChoices(Map<T,String> choices) {
        this.choiceProvider = new InlineChoiceProvider<T>().withChoices(choices);
        return this;
    }

    public DropDownConfig withRemoteChoices(String url) {
        this.choiceProvider = new RemoteChoiceProvider<T>().withUrl(url);
        return this;
    }

    //TODO : add options like search, scrolling parms etc...

}
