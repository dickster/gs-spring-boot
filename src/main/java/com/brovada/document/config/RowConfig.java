package com.brovada.document.config;

import java.util.List;

public class RowConfig implements ComponentConfig, HasChildren, HasValidation {
    private List<ComponentConfig> contents;

    @Override
    public ComponentType getType() {
        return ComponentType.ROW;
    }

    @Override
    public List<? extends ComponentConfig> getChildren() {
        return contents;
    }
}
