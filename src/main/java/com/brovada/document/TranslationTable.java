package com.brovada.document;

import javax.annotation.Nonnull;
import java.util.HashMap;

public class TranslationTable extends HashMap<String, TranslationTable.Translations> {

    // TODO : should be hierarchical. component->form->application
    // .: formConfig should have translations. so should each componentConfig  (optionally)
    // translation service will filter out all languages not requested.  only include one in payload.
    // it should go through and do all the translating so client doesn't have to.  i.e. replace
    // all @Translatable Strings with their values.
    public TranslationTable() {
        
    }

    public TranslationTable withTranslations(@Nonnull String lang, @Nonnull Translations translations) {
        put(lang, translations);
        return this;
    }

    public static class Translations extends HashMap<String, String> {

    }


}
