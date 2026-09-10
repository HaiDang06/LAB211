package constant;

public class Message {

    // --- Prompts ---
    public static final String INPUT_BASE_MENU = "1 for Binary, 2 for Decimal, 3 for Hexadecimal\n"
            + "Enter choice: ";
    public static final String CONVERT_MENU = "1 for Binary, 2 for Decimal, 3 for Hexadecimal, 4 exit\n"
            + "Enter choice: ";

    public static final String ENTER_BIN = "Enter binary number: ";
    public static final String ENTER_DEC = "Enter decimal number: ";
    public static final String ENTER_HEX = "Enter hexadecimal number: ";
// --- Success Messages ---
    public static final String CONVERT_SUCCESS = "Number after convert: %s";

    // --- Error Messages ---
    public static final String ERROR_NO_DATA = "No input data available.";
    public static final String ERROR_INVALID_TARGET = "Invalid target base.";
    public static final String ERROR_INVALID_GENERAL = "Invalid!";
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";
}
