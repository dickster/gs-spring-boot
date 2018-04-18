package com.brovada.service;

import com.brovada.document.JobConfig;

import javax.annotation.Nullable;
import java.util.Locale;

public class TranslationService {

    public JobConfig translate(JobConfig jobConfig, @Nullable Locale locale) {
        // if null return untouched.
        // iterate through config.  whenever you see a @Translatable
        //   string in any of the config objects, replace it's value.
        // getting replacement value means looking at:
        //  1: component translations.
        //  2: form translations
        //  3: job translations
        //  4: brovada wide translations.
        return jobConfig;
    }

}
