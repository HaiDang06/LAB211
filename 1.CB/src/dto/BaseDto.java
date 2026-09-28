package dto;

import constant.Base;

/**
 * Lớp DTO (Data Transfer Object) dùng để truyền dữ liệu giữa các tầng (View, Controller, Service).
 */
public class BaseDto {
    private Base base;
    private String presentation;
    private Base targetBase;

    /**
     * Lấy hệ cơ số ban đầu.
     * @return Hệ cơ số hiện tại.
     */
    public Base getBase() {
        return base;
    }

    /**
     * Thiết lập hệ cơ số ban đầu.
     * @param base Hệ cơ số cần thiết lập.
     */
    public void setBase(Base base) {
        this.base = base;
    }

    /**
     * Lấy chuỗi biểu diễn giá trị đầu vào.
     * @return Chuỗi giá trị.
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * Thiết lập chuỗi biểu diễn giá trị đầu vào.
     * @param presentation Chuỗi giá trị cần thiết lập.
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    /**
     * Lấy hệ cơ số đích muốn chuyển đổi sang.
     * @return Hệ cơ số đích.
     */
    public Base getTargetBase() {
        return targetBase;
    }

    /**
     * Thiết lập hệ cơ số đích muốn chuyển đổi sang.
     * @param targetBase Hệ cơ số đích.
     */
    public void setTargetBase(Base targetBase) {
        this.targetBase = targetBase;
    }
}
