package utils;

import constant.Message;

/**
 * Lớp Validation cung cấp các phương thức tiện ích (Utility Methods) tĩnh để kiểm tra 
 * tính hợp lệ của dữ liệu đầu vào từ người dùng (như kiểu dữ liệu, phạm vi, định dạng regex).
 */
public class Validation {
    /**
     * Constructor private ngăn việc khởi tạo đối tượng từ lớp này,
     * vì tất cả các phương thức đều là static.
     */
    private Validation() {
    }

    /**
     * Đọc và kiểm tra một số nguyên được truyền vào từ chuỗi.
     * Đảm bảo chuỗi nhập vào có thể parse thành Integer và nằm trong khoảng [min, max].
     * 
     * @param input Chuỗi đầu vào (do người dùng nhập).
     * @param min Giá trị nhỏ nhất được phép (bao gồm).
     * @param max Giá trị lớn nhất được phép (bao gồm).
     * @return Số nguyên hợp lệ sau khi parse.
     * @throws Exception Nếu đầu vào không phải số (NumberFormatException) hoặc nằm ngoài khoảng cho phép.
     */
    public static int getInt(String input, int min, int max) throws Exception{
        try {
            // Cố gắng ép kiểu chuỗi sang số nguyên
            int check = Integer.parseInt(input);
            
            // Kiểm tra điều kiện giới hạn
            if(check >= min && check <= max){
                return check;
            } else {
                // Quăng lỗi với thông báo yêu cầu nhập trong khoảng quy định
                throw new Exception(String.format(Message.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e){
                // Nếu ép kiểu thất bại (nhập chữ cái, ký tự đặc biệt...), quăng lỗi chung
                throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    /**
     * Kiểm tra một chuỗi đầu vào có khớp với định dạng biểu thức chính quy (Regex) hay không.
     * Đảm bảo chuỗi không rỗng và chứa các ký tự hợp lệ theo yêu cầu của hệ cơ số.
     * 
     * @param input Chuỗi đầu vào (do người dùng nhập).
     * @param REGEX Biểu thức chính quy dùng để xác thực chuỗi (ví dụ: "[01]+" cho nhị phân).
     * @return Chuỗi gốc nếu nó hoàn toàn hợp lệ.
     * @throws Exception Nếu chuỗi trống, null, hoặc chứa ký tự không khớp Regex.
     */
    public static String getString(String input, final String REGEX) throws Exception{
        // Kiểm tra xem chuỗi có bị null hoặc chỉ chứa khoảng trắng hay không
        if (input == null || input.trim().isEmpty()) {
            throw new Exception(Message.ERROR_NO_DATA);
        }
        
        // Dùng phương thức matches của String để kiểm tra toàn bộ chuỗi với Regex
        if (input.matches(REGEX)){
            return input;
        }
        
        // Nếu không khớp, quăng lỗi dữ liệu không hợp lệ
        throw new Exception(Message.ERROR_INVALID_GENERAL);
    }
}
