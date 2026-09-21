/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author KATANA15
 */
public class Message {

    public static final String MENU_HEADER = "======== Worker Management =========\n";
    public static final String MENU_BODY
            = "1. Add Worker\n"
            + "2. Up salary\n"
            + "3. Down salary\n"
            + "4. Display Information salary\n"
            + "5. Exit";
    public static final String CHOICE_PROMPT = "Enter your choice: ";
    public static final String ID_PROMPT = "Enter id: ";
    public static final String NAME_PROMPT = "Enter Name: ";
    public static final String AGE_PROMPT = "Enter age: ";
    public static final String SALARY_PROMPT = "Enter Salary: ";
    public static final String LOCATION_PROMPT = "Enter work location: ";
    public static final String AMOUNT_PROMPT = "Enter amount: ";
    public static final String DATE_REGEX = "dd/MM/yyyy";
    public static final String ID_REGEX = "[Ww]\\d+";
    public static final String NAME_REGEX = "[A-Za-z\\s]+";
    public static final String LOCATION_REGEX = "[A-Za-z0-9\\s]+";
    public static final String SUCCESS_MESSAGE = "Success!";
    public static final String FAIL_MESSAGE = "Fail!";
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
