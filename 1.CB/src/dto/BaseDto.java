package dto;

import constant.Base;

/**
 * Lớp DTO (Data Transfer Object) cho đầu vào.
 * Dùng để đóng gói và vận chuyển dữ liệu từ View (khi người dùng nhập) tới Controller,
 * rồi từ Controller sang Service mà không làm lộ logic nội bộ.
 */
public class BaseDto {
    // Hệ cơ số ban đầu (BIN, DEC, HEX)
    private Base base;
    
    // Chuỗi giá trị nhập vào ban đầu (ví dụ "1010", "A1")
    private String presentation;
    
    // Hệ cơ số đích mà người dùng muốn chuyển đổi sang
    private Base targetBase;

    /**
     * Lấy hệ cơ số ban đầu của chuỗi.
     * @return Hệ cơ số hiện tại.
     */
    public Base getBase() {
        return base;
    }

    /**
     * Thiết lập hệ cơ số ban đầu.
     * @param base Hệ cơ số cần thiết lập (ví dụ người dùng chọn 1 thì base = BIN).
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
     * @param presentation Chuỗi giá trị (ví dụ "1010").
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
     * @param targetBase Hệ cơ số đích do người dùng nhập ở menu sau (ví dụ chọn 2 thì target = DEC).
     */
    public void setTargetBase(Base targetBase) {
        this.targetBase = targetBase;
    }
}
