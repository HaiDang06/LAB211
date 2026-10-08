package constant;

/**
 * Lớp chứa các hằng số dùng chung trong hệ thống.
 */
public class Constants {
    private Constants() {
    }
    
    // Các biểu thức chính quy (Regex) dùng để kiểm tra tính hợp lệ của dữ liệu đầu vào
    public static final String DATE_REGEX = "dd/MM/yyyy";
    public static final String ID_REGEX = "[Ww]\\d+"; // Bắt đầu bằng W hoặc w, theo sau là các chữ số
    public static final String NAME_REGEX = "[A-Za-z\\s]+"; // Chỉ chứa chữ cái và khoảng trắng
    public static final String LOCATION_REGEX = "[A-Za-z0-9\\s]+"; // Chứa chữ cái, số và khoảng trắng
}
