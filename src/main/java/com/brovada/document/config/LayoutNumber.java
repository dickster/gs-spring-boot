package com.brovada.document.config;

public class LayoutNumber {

    enum LayoutUnit {
        EM, EX, PCT, PX, CM, MM, IN , PT, PC, COLS;
    }

    private int value;
    private LayoutUnit unit = LayoutUnit.COLS;
    

    public LayoutNumber(int n) {
        // TODO convert into unit & number.  default unit is cols (1-12)
        this.value = n;
    }
    public LayoutNumber(int n,LayoutUnit unit) {
        this.value = n;
        this.unit=unit;
    }

    public LayoutNumber cols(int n) {
        this.unit=LayoutUnit.COLS;
        this.value=n;
        return this;
    }

    public String getUnit() {  // em, ex, %, px, cm, mm, in, pt, pc  or cols (1-12)
        return "px";
    }

    public int getValue() {
        return 0;
    }

}
