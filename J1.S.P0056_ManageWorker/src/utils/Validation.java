package utils;

import constant.Message;

public class Validation {

    private Validation() {
    }

    // Chuyển chuỗi nhập vào thành số thực và kiểm tra nằm trong khoảng [min, max]
    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double number = Double.parseDouble(input);
            //kiem tra so co nam trong khoang gia tri khong
            if (number >= min && number <= max) {
                return number;
            } else {
                //in ra thong bao loi
                throw new Exception(String.format(Message.REAL_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            //in ra thong bao loi
            throw new Exception(Message.INVALID_NUMBER_ERROR);
        }
    }

    // Chuyển chuỗi nhập vào thành số nguyên và kiểm tra nằm trong khoảng [min, max]
    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int number = Integer.parseInt(input);
            //kiem tra so co nam trong khoang gia tri khong
            if (number >= min && number <= max) {
                return number;
            } else {
                //in ra thong bao loi
                throw new Exception(String.format(Message.INTEGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            //in ra thong bao loi
            throw new Exception(Message.INVALID_NUMBER_ERROR);
        }
    }

    // Kiểm tra chuỗi nhập vào có khớp regex hay không, khớp thì trả về chính chuỗi đó
    public static String getString(String input, final String regex) throws Exception {
        // Khớp regex thì hợp lệ
        if (input.matches(regex)) {
            return input;
        }
        // Không khớp regex thì báo lỗi
        throw new Exception(Message.INVALID_STRING_ERROR);
    }
}
