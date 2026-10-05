package constant;

/**
 * Lớp chứa các hằng số chuỗi văn bản phục vụ cho việc hiển thị thông báo.
 * Giúp cho việc đa ngôn ngữ hoặc bảo trì các thông báo dễ dàng hơn,
 * mọi thay đổi về văn bản hiển thị chỉ cần thực hiện tập trung tại lớp này.
 */
public class Message {
    // --- Prompts (Lời nhắc nhập liệu) ---
    /** Lời nhắc hiển thị menu chọn hệ cơ số đầu vào cho số cần chuyển đổi. */
    public static final String INPUT_BASE_MENU = "1 for Binary, 2 for Decimal, 3 for Hexadecimal\n"
            + "Enter choice: ";
            
    /** Lời nhắc hiển thị menu chọn hệ cơ số đích muốn chuyển sang. */
    public static final String CONVERT_MENU = "1 for Binary, 2 for Decimal, 3 for Hexadecimal, 4 exit\n"
            + "Enter choice: ";

    /** Yêu cầu người dùng nhập một chuỗi số nhị phân. */
    public static final String ENTER_BIN = "Enter binary number: ";
    
    /** Yêu cầu người dùng nhập một chuỗi số thập phân. */
    public static final String ENTER_DEC = "Enter decimal number: ";
    
    /** Yêu cầu người dùng nhập một chuỗi số thập lục phân. */
    public static final String ENTER_HEX = "Enter hexadecimal number: ";

    // --- Success Messages (Thông báo thành công) ---
    /** Thông báo hiển thị kết quả sau khi chuyển đổi thành công. Định dạng: %s sẽ được thay thế bằng kết quả. */
    public static final String CONVERT_SUCCESS = "Number after convert: %s";

    // --- Error Messages (Thông báo lỗi) ---
    /** Thông báo lỗi khi người dùng không nhập dữ liệu hoặc chỉ nhập khoảng trắng. */
    public static final String ERROR_NO_DATA = "No input data available.";
    
    /** Thông báo lỗi khi hệ cơ số đích người dùng chọn không hợp lệ. */
    public static final String ERROR_INVALID_TARGET = "Invalid target base.";
    
    /** Thông báo lỗi chung khi đầu vào không hợp lệ với yêu cầu (ví dụ: nhập chữ cho menu số, sai định dạng Regex). */
    public static final String ERROR_INVALID_GENERAL = "Invalid!";
    
    /** Thông báo lỗi khi lựa chọn số nằm ngoài phạm vi cho phép (min -> max). */
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";
}
