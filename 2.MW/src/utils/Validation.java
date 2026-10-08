package utils;

import constant.Messages;

/**
 * Lớp tiện ích hỗ trợ xác thực và kiểm tra dữ liệu đầu vào.
 */
public class Validation {
    private Validation() {
    }

    /**
     * Lấy và kiểm tra số thực (double) nằm trong khoảng cho phép.
     * @param input Chuỗi đầu vào
     * @param min Giá trị nhỏ nhất
     * @param max Giá trị lớn nhất
     * @return Số thực hợp lệ
     * @throws Exception nếu chuỗi không hợp lệ hoặc không nằm trong khoảng cho phép
     */
    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double check = Double.parseDouble(input);
            // Kiểm tra số có nằm trong khoảng giá trị không
            if (check >= min && check <= max) {
                return check;
            } else {
                // In ra thông báo lỗi nếu ngoài khoảng
                throw new Exception(String.format(Messages.REAL_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            // In ra thông báo lỗi nếu không phải số thực
            throw new Exception(Messages.INVALID_NUMBER_ERROR);
        }
    }

    /**
     * Lấy và kiểm tra số nguyên (int) nằm trong khoảng cho phép.
     * @param input Chuỗi đầu vào
     * @param min Giá trị nhỏ nhất
     * @param max Giá trị lớn nhất
     * @return Số nguyên hợp lệ
     * @throws Exception nếu chuỗi không hợp lệ hoặc không nằm trong khoảng cho phép
     */
    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int check = Integer.parseInt(input);
            // Kiểm tra số có nằm trong khoảng giá trị không
            if (check >= min && check <= max) {
                return check;
            } else {
                // In ra thông báo lỗi nếu ngoài khoảng
                throw new Exception(String.format(Messages.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            // In ra thông báo lỗi nếu không phải số nguyên
            throw new Exception(Messages.INVALID_NUMBER_ERROR);
        }
    }

    /**
     * Lấy và kiểm tra chuỗi có khớp với biểu thức chính quy (Regex) không.
     * @param input Chuỗi đầu vào
     * @param REGEX Biểu thức chính quy cần khớp
     * @return Chuỗi hợp lệ
     * @throws Exception nếu chuỗi không khớp
     */
    public static String getString(String input, final String REGEX) throws Exception {
        if (input.matches(REGEX)) {
            return input;
        }
        throw new Exception(Messages.INVALID_STRING_ERROR);
    }
}
