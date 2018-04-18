package com.brovada.document.config;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class InlineChoiceProvider<T> implements ChoiceProvider<T> {

    private Map<T, Object> choices;

    /*package protected constructor and methods*/
    InlineChoiceProvider() {
    }

    InlineChoiceProvider withChoices(@Nonnull Map<T, Object> choices) {
        Preconditions.checkState(this.choices == null, "You can't set provider more than once");
        this.choices = choices;
        return this;
    }

    InlineChoiceProvider withInlineChoices(@Nonnull List<T> choices) {
        Preconditions.checkState(this.choices == null, "You can't set provider more than once");
        this.choices = Maps.toMap(choices, new Function<T, Object>() {
            @Override @Nullable public Object apply(@Nullable T input) {
                return input != null ? input.toString() : null;
            }
        });
        return this;
    }

}
