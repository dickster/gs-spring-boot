package com.brovada.document.config;

// Hmm....maybe this shouldn't be an enum.   a string is more suitable because then you can add custom types
// without changing core type.
// only use this as a convenience.  don't enforce strictly.
public enum ComponentType {
    DATE_PICKER,
    DROP_DOWN,
    TEXT_FIELD,
    TEXT_AREA,
    YES_NO,
    RADIO,
    CHECKBOX,
    AUTOCOMPLETE,
    MAP,
    PHONE_NUMBER,
    POSTAL_CODE,
    CREDIT_CARD,
    PASSWORD,
    TIME,
    PANEL,
    LABEL,
    DURATION,
    ROW,
    SECTION,
    FORM,
    ACTIONBUTTON,
    TAB_SECTION

}
