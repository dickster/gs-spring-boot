package com.brovada.document.config;

public class TabSectionConfig  extends SectionConfig {
    // need to get tab title from underlying data....it will emit event on change?   then what?
    // bind title to computed Vue value.  if none given, use first field in tab?
    private String tabTitle;  //nullable.

    // need a hook to lambda value/index => 'someString'

    private int min;
    private int max;
    private String bind;  // the variable bound to is typically an array/collection.

    @Override
    public ComponentType getType() {
        return ComponentType.TAB_SECTION;
    }

    public TabSectionConfig() {
        super();
    }
}
