package com.brovada.document.config;

import javax.annotation.Nonnull;

public class RemoteChoiceProvider<T> implements ChoiceProvider<T> {

    private String url;

    /*package protected constructor and methods*/
    RemoteChoiceProvider() {
    }

    RemoteChoiceProvider withUrl(@Nonnull String url) {
        this.url = url;
        return this;
    }

}
