package model;

import constant.Base;

/**
 * Lớp đại diện cho một con số với hệ cơ số và chuỗi biểu diễn tương ứng.
 */
public class BaseNumber {
    private Base base;
    private String presentation;

    /**
     * Khởi tạo đối tượng BaseNumber.
     * @param base Hệ cơ số.
     * @param presentation Chuỗi biểu diễn giá trị.
     */
    public BaseNumber(Base base, String presentation) {
        this.base = base;
        this.presentation = presentation;
    }

    /**
     * Lấy hệ cơ số của con số.
     * @return Hệ cơ số hiện tại.
     */
    public Base getBase() {
        return base;
    }

    /**
     * Thiết lập hệ cơ số của con số.
     * @param base Hệ cơ số cần thiết lập.
     */
    public void setBase(Base base) {
        this.base = base;
    }

    /**
     * Lấy chuỗi biểu diễn giá trị của con số.
     * @return Chuỗi giá trị.
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * Thiết lập chuỗi biểu diễn giá trị của con số.
     * @param presentation Chuỗi giá trị cần thiết lập.
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }
}
