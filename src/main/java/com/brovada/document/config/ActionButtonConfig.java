package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;

@Document
public class ActionButtonConfig implements ComponentConfig {

    // how to display simple bound label/text.   like "hello {{name}}"

    private @Translatable @Nonnull String label = "";

    public ActionButtonConfig(String label) {
        labelled(label);
    }

    private ActionButtonConfig labelled(String label) {
        this.label = label;
        return this;
    }

    @Override
    public ComponentType getType() {
              // should do a default implementation that searches for
        //  an appropriate enum based on class name so every component doesn't have
        // to do this. 
        return ComponentType.ACTIONBUTTON;
    }

}
