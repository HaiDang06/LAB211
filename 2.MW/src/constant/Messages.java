package constant;

/**
 * Lớp chứa các thông báo hiển thị trên giao diện hoặc báo lỗi.
 */
public class Messages {
    private Messages() {
    }
    
    // Các thông báo cho Menu
    public static final String MENU_HEADER = "======== Worker Management =========\n";
    public static final String MENU_BODY
            = "1. Add Worker\n"
            + "2. Up salary\n"
            + "3. Down salary\n"
            + "4. Display Information salary\n"
            + "5. Exit";
            
    // Các thông báo yêu cầu nhập dữ liệu (Prompt)
    public static final String CHOICE_PROMPT = "Enter your choice: ";
    public static final String ID_PROMPT = "Enter id: ";
    public static final String NAME_PROMPT = "Enter Name: ";
    public static final String AGE_PROMPT = "Enter age: ";
    public static final String SALARY_PROMPT = "Enter Salary: ";
    public static final String LOCATION_PROMPT = "Enter work location: ";
    public static final String AMOUNT_PROMPT = "Enter amount: ";
    
    // Thông báo trạng thái xử lý
    public static final String SUCCESS_MESSAGE = "Success!";
    public static final String FAIL_MESSAGE = "Fail!";
    
    // Các thông báo lỗi
    public static final String DUPLICATE_ERROR = "Worker with ID %s already exists.";
    public static final String NOT_FOUND_ID_ERROR = "Can not found code!";
    public static final String AMOUNT_ERROR = "Amount of money must be > 0 ";
    public static final String DOWN_SALARY_ERROR = "Can not down %.1f";
    public static final String EMPTY_ERROR = "List is empty!";
    public static final String EMPTY_ERROR2 = "History is empty!";
    public static final String REAL_NUMBER_RANGE_ERROR = "Please input number in a range %.1f -> %.1f";
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";
    public static final String INVALID_NUMBER_ERROR = "Invalid number!";
    public static final String INVALID_STRING_ERROR = "Invalid regex!";
}
