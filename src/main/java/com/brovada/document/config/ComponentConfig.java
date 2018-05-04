package com.brovada.document.config;

import com.brovada.document.TranslationTable;

import java.util.Map;
import java.util.Optional;

public interface ComponentConfig {

    // TODO : change this to be a "string" based on class name if not specified.
    // can have an optional constructor that takes enum as param.
    ComponentType getType();
    // width & offset can be in px or % or whatever?
    default LayoutNumber getWidth() {return new LayoutNumber(12);};
    default LayoutNumber getOffset() {return new LayoutNumber(0);};

    default Optional<String> getBackground() { return Optional.empty(); }
    default Optional<String> getForeground() { return Optional.empty(); }
    default Optional<FontSpec> getFont() { return Optional.empty(); }

    default Optional<Expression> getCssClass() { return Optional.empty(); };

    default Optional<Map<String,PropertyValue>> getAttributes()  { return Optional.empty(); }    // e.g. disabled --> policy.country=='CA' && policy.province=='ON'

    default Optional<TranslationTable> getTranslations() { return Optional.empty(); }

    public static interface PropertyValue {
        // can be an expression, a javascript method name, or string/int/date.
    }


}

