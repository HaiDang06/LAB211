package model;

import constant.Base;

public class BaseNumber {

    private Base base;
    private String presentation;

    public BaseNumber(Base base, String presentation) {
        this.base = base;
        this.presentation = presentation;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

}
