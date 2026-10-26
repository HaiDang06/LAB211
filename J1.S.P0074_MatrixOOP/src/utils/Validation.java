package utils;

import constant.Message;

public class Validation {

    private Validation() {
    }

    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int check = Integer.parseInt(input);
            // kiem tra so co nam trong khoang gia tri khong
            if (check >= min && check <= max) {
                return check;
            } else {
                // in ra thong bao loi
                throw new Exception(String.format(Message.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            // in ra thong bao loi
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    // Kiểm tra số dòng/cột của ma trận 2 có khớp với yêu cầu của ma trận 1 không
    public static int getMatrixDimension(String input, int expectedSize, String errorMsg) throws Exception {
        try {
            int check = Integer.parseInt(input);
            if (check <= 0) {
                throw new Exception(Message.ERR_INVALID_DIMENSION);
            }
            if (check != expectedSize) {
                throw new Exception(errorMsg);
            }
            return check;
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }
}