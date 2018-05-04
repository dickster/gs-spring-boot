package com.brovada.document.config;

import javax.annotation.Nonnull;

public class RemoteChoiceProvider<T> implements ChoiceProvider<T> {

    // TODO ; add optional language/locale parameter.
    private String url;

    /*package protected constructor and methods*/
    RemoteChoiceProvider() {
    }

    RemoteChoiceProvider withUrl(@Nonnull String url) {
        this.url = url;
        return this;
    }

}
