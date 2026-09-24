package constant;

/**
 * Lớp chứa các hằng số sử dụng trong ứng dụng (như Regex).
 */
public class Constants {
    /**
     * Constructor private ngăn việc khởi tạo đối tượng từ lớp này.
     */
    private Constants() {
    }

    public final static String REGEX_BINARY = "[01]*";
    public static final String REGEX_DECIMAL = "[0-9]*";
    public static final String REGEX_HEXADECIMAL = "[0-9A-Fa-f]*";
    public static final int NOTFOUNDBASE = -1;
}
