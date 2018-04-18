package com.brovada.document.config;

import com.google.common.collect.Maps;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Nonnull;
import java.util.Locale;
import java.util.Map;

@Document
public class WorkflowConfig {

    private Locale locale;
    // formatting? whatever??
    private Map<String, Map<String, String>> stateTable = Maps.newHashMap();

//    StateTable = "State[event]=>State.

    // State = formConfig id/version.
    // version = always head unless specified.   older versions are stored in a separate collection.
    // each major version gets its own document.   auto/CMF

    private TranslationConfig translationConfig = new TranslationConfig();

    // formatting, settings...like what???
    // need access to this from every form.
    // vue application needs a user-options variable which we can set.

    

    @Nonnull
    protected String resolveState(String stateName) {
        // TODO : return a URL.
        return stateName;
    }


}
