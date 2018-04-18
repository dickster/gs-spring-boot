package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

@Document
public class FormConfig extends SectionConfig {

    private @Nonnull String id = "";

    private @Nullable String initialFocus = null;
    private @Nullable String comments = null;

    public FormConfig() {
    }

    public FormConfig withInitialFocus(@Nonnull String inputId) {
        this.initialFocus = inputId;
        return this;
    }

    public Optional<String> getInitialFocus() {
        return Optional.ofNullable(initialFocus);
    }

    public @Nonnull String getId() {
        return id;
    }
    
    public Version getVersion() {return new Version(3);}

    @Override
    public ComponentType getType() {
        return ComponentType.FORM;
    }
}
