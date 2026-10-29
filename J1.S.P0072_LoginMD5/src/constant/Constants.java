package constant;

public final class Constants {

    private Constants() {
    }

    public static final String REGEX_USERNAME = ".*[^ ].*";
    public static final String REGEX_PASSWORD = ".*[^ ].*";
    public static final String REGEX_NAME = ".*[^ ].*";
    public static final String REGEX_PHONE = "^[0-9]{10,11}$";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    public static final String REGEX_ADDRESS = ".*[^ ].*";
    public static final String REGEX_YN = "^[YyNn]$";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
}