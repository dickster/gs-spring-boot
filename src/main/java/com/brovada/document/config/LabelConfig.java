package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;

@Document
public class LabelConfig implements ComponentConfig {

    // how to display simple bound label/text.   like "hello {{name}}"

    private @Nonnull String label = "";

    public LabelConfig(String label) {
        labelled(label);
    }

    private LabelConfig labelled(String label) {
        this.label = label;
        return this;
    }

    @Override
    public ComponentType getType() {
        return ComponentType.LABEL;
    }

}
