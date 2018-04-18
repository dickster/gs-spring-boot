package com.brovada.document.config;

import com.google.common.collect.Lists;

import javax.annotation.Nullable;
import java.util.List;

public abstract class SectionConfig implements ComponentConfig, HasChildren, HasValidation {

    private @Nullable String title;
    List<ComponentConfig> contents = Lists.newArrayList();   // can either be a list of Rows or a sections or components.

    public <T extends SectionConfig> T withTitle(String title) {
        this.title = title;
        return (T) this;
    }


    @Override
    public List<? extends ComponentConfig> getChildren() {
        return contents;
    }
}
