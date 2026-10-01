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

    /**
     * Chuyển đổi enum Base sang giá trị số nguyên nguyên thủy tương ứng để phục vụ tính toán toán học.
     * Phương thức này là static vì nó mang tính chất Utility, 
     * không phụ thuộc vào trạng thái (state) của một đối tượng cụ thể.
     * 
     * @param base Enum Base (BIN, DEC, HEX).
     * @return Giá trị nguyên tương ứng (2 cho BIN, 10 cho DEC, 16 cho HEX) hoặc -1 nếu đầu vào không hợp lệ.
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
}
