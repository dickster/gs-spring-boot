package com.brovada.document.config;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TextFieldConfig extends InputConfig<String> implements HasValidation {

    public TextFieldConfig(String bind) {
        super(ComponentType.TEXT_FIELD, bind);
    }

   
}
