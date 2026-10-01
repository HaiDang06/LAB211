package constant;

/**
 * Lớp chứa các hằng số sử dụng trong ứng dụng (như Regex).
 * Việc đặt các hằng số ở đây giúp dễ dàng quản lý, bảo trì và tái sử dụng
 * ở nhiều nơi khác nhau mà không phải viết lại (tránh Hardcode).
 */
public class Constants {
    /**
     * Constructor private ngăn việc khởi tạo đối tượng từ lớp này, 
     * vì đây chỉ là một lớp chứa tĩnh (Utility/Constant Class).
     */
    private Constants() {
    }

    /** Regex để kiểm tra chuỗi có phải là số nhị phân hợp lệ hay không (chỉ chứa 0 và 1). */
    public static final String REGEX_BINARY = "[01]+";
    
    /** Regex để kiểm tra chuỗi có phải là số thập phân hợp lệ hay không (chỉ chứa 0 đến 9). */
    public static final String REGEX_DECIMAL = "[0-9]+";
    
    /** Regex để kiểm tra chuỗi có phải là số thập lục phân hợp lệ hay không (chứa 0-9 và A-F, không phân biệt hoa thường). */
    public static final String REGEX_HEXADECIMAL = "[0-9A-Fa-f]+";
    
    /** Hằng số đại diện cho trường hợp hệ cơ số không được tìm thấy hoặc không hợp lệ. */
    public static final int NOTFOUNDBASE = -1;
}
