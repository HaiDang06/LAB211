package constant;

public final class Message {

    private Message() {
    }

    public static final String MENU_HEADER = "============ Login Program =========\n";
    public static final String MENU_BODY
            = "1. Add User\n"
            + "2. Login\n"
            + "3. Exit\n";
    public static final String INPUT_CHOICE = "Your choice: ";
    
    public static final String INPUT_USERNAME = "Account: ";
    public static final String INPUT_PASSWORD = "Password: ";
    public static final String INPUT_NAME = "Name: ";
    public static final String INPUT_PHONE = "Phone (10-11 digits): ";
    public static final String INPUT_EMAIL = "Email: ";
    public static final String INPUT_ADDRESS = "Address: ";
    public static final String INPUT_DOB = "DOB (dd/MM/yyyy): ";

    public static final String ERROR_INVALID_GENERAL = "Invalid input!";
    public static final String ERROR_INVALID_DATE = "Invalid date format! Must be dd/MM/yyyy.";
    public static final String ERROR_ACCOUNT_EXIST = "Account already exists. Please enter another one.";
    public static final String ERROR_PASSWORD_MISMATCH = "Renew password does not match new password!";
    
    // Các thông báo lỗi dùng trong Service
    public static final String ERROR_USERNAME_EXIST_DB = "Error: Username already exists in DB!";
    public static final String ERROR_ACCOUNT_NOT_FOUND = "Error: Account does not exist!";
    public static final String ERROR_INCORRECT_PASSWORD = "Error: Incorrect password!";
    public static final String ERROR_OLD_PASSWORD_INCORRECT = "Error: Old password is incorrect!";
    
    public static final String SUCCESS_ADD_MESSAGE = "Account added successfully.";
    public static final String SUCCESS_CHANGE_PASSWORD = "Password changed successfully!";
}