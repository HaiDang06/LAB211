package model;

import constant.Base;

/**
 * Lớp BaseModel cung cấp các phương thức tiện ích để ánh xạ giữa Base Enum và giá trị nguyên.
 */
public class BaseModel {
    private Base base;

    /**
     * Lấy Enum Base tương ứng với giá trị kiểu int.
     * @param type Giá trị kiểu int (10, 16, 2).
     * @return Enum Base tương ứng.
     */
    public static Base getBase(int type) {
        switch (type) {
            case 10:
                return Base.DEC;
            case 16:
                return Base.HEX;
            case 2:
                return Base.BIN;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Lấy giá trị kiểu int tương ứng với Enum Base.
     * @param base Enum Base.
     * @return Giá trị kiểu int.
     */
    public static int getValue(Base base) {
        switch (base) {
            case DEC:
                return 10;
            case HEX:
                return 16;
            case BIN:
                return 2;
            default:
                throw new AssertionError();
        }
    }
}
