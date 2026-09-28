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
     * 
     * @param base         Hệ cơ số.
     * @param presentation Chuỗi biểu diễn giá trị.
     */
    public BaseNumber(Base base, String presentation) {
        this.base = base;
        this.presentation = presentation;
    }

    /**
     * Lấy hệ cơ số của con số.
     * 
     * @return Hệ cơ số hiện tại.
     */
    public Base getBase() {
        return base;
    }

    /**
     * Thiết lập hệ cơ số của con số.
     * 
     * @param base Hệ cơ số cần thiết lập.
     */
    public void setBase(Base base) {
        this.base = base;
    }

    /**
     * Lấy chuỗi biểu diễn giá trị của con số.
     * 
     * @return Chuỗi giá trị.
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

    /**
     * Chuyển đổi enum Base sang giá trị số nguyên.
     * 
     * @param base Enum Base (BIN, DEC, HEX).
     * @return Giá trị nguyên tương ứng (2, 10, 16) hoặc -1 nếu không hợp lệ.
     */
    public static int baseToInt(Base base) {
        if (base == null) {
            return -1;
        }
        switch (base) {
            case BIN:
                return 2;
            case DEC:
                return 10;
            case HEX:
                return 16;
            default:
                return -1;
        }
    }

    /**
     * Chuyển đổi giá trị số nguyên sang enum Base.
     * 
     * @param value Giá trị nguyên (2, 10, 16).
     * @return Enum Base tương ứng (BIN, DEC, HEX) hoặc null nếu không hợp lệ.
     */
    public static Base intToBase(int value) {
        switch (value) {
            case 2:
                return Base.BIN;
            case 10:
                return Base.DEC;
            case 16:
                return Base.HEX;
            default:
                return null;
        }
    }

}
