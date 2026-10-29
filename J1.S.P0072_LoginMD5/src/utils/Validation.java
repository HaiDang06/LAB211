package utils;

import constant.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Validation {

    private Validation() {
    }

    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int check = Integer.parseInt(input);
            if (check >= min && check <= max) {
                return check;
            } else {
                throw new Exception("Please input number in a range " + min + " -> " + max);
            }
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    public static String getString(String input, final String REGEX) throws Exception {
        if (input.matches(REGEX)) {
            return input;
        }
        throw new Exception(Message.ERROR_INVALID_GENERAL);
    }
    
    public static Date getDate(String input, final String FORMAT) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(input);
        } catch (ParseException e) {
            throw new Exception(Message.ERROR_INVALID_DATE);
        }
    }

}