package utils;

import constant.Message;

/**
 * Lớp Validation cung cấp các phương thức tiện ích để kiểm tra tính hợp lệ của dữ liệu đầu vào.
 */
public class Validation {
    /**
     * Constructor private ngăn việc khởi tạo đối tượng từ lớp này.
     */
    private Validation() {
    }

    /**
     * Đọc và kiểm tra một số nguyên nằm trong khoảng cho trước.
     * @param input Chuỗi đầu vào.
     * @param min Giá trị nhỏ nhất (bao gồm).
     * @param max Giá trị lớn nhất (bao gồm).
     * @return Số nguyên hợp lệ.
     * @throws Exception Nếu đầu vào không phải số hoặc nằm ngoài khoảng hợp lệ.
     */
    public static int getInt(String input, int min, int max) throws Exception{
        try {
            int check = Integer.parseInt(input);
            if(check >= min && check <= max){
                return check;
            } else {
                throw new Exception(String.format(Message.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e){
                throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    /**
     * Đọc và kiểm tra một chuỗi dựa trên biểu thức chính quy (Regex).
     * @param input Chuỗi đầu vào.
     * @param REGEX Biểu thức chính quy cần khớp.
     * @return Chuỗi hợp lệ.
     * @throws Exception Nếu chuỗi không khớp với định dạng.
     */
    public static String getString(String input, final String REGEX) throws Exception{
        if (input.matches(REGEX)){
            return input;
        }
        throw new Exception(Message.ERROR_INVALID_GENERAL);
    }
}
