package model;

import constant.Base;

/**
 * Lớp model (Mô hình dữ liệu) đại diện cho một con số.
 * Chứa thông tin về hệ cơ số của nó và chuỗi ký tự biểu diễn giá trị thực tế.
 */
public class BaseNumber {
    private Base base;
    private String presentation;

    /**
     * Khởi tạo đối tượng BaseNumber.
     * 
     * @param base         Hệ cơ số của số được nhập vào (BIN, DEC, HEX).
     * @param presentation Chuỗi biểu diễn giá trị (ví dụ: "1010", "15", "1F").
     */
    public BaseNumber(Base base, String presentation) {
        this.base = base;
        this.presentation = presentation;
    }

    /**
     * Lấy hệ cơ số của con số.
     * 
     * @return Hệ cơ số hiện tại (kiểu Enum Base).
     */
    public Base getBase() {
        return base;
    }

    /**
     * Thiết lập hệ cơ số của con số.
     * 
     * @param base Hệ cơ số cần thiết lập (kiểu Enum Base).
     */
    public void setBase(Base base) {
        this.base = base;
    }

    /**
     * Lấy chuỗi biểu diễn giá trị của con số.
     * 
     * @return Chuỗi giá trị dạng văn bản (String).
     */
    public String getPresentation() {
        return presentation;
    }

    /**
     * Thiết lập chuỗi biểu diễn giá trị của con số.
     * 
     * @param presentation Chuỗi giá trị cần thiết lập.
     */
    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

}
