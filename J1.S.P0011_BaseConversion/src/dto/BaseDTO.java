
package dto;

import constant.Base;


public class BaseDTO {

    private Base base;
    private String presentation;
    private Base targetBase;

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

    public Base getTargetBase() {
        return targetBase;
    }

    public void setTargetBase(Base targetBase) {
        this.targetBase = targetBase;
    }

}
