package utils;

import constant.Message;

public class Validation {

    private Validation() {
    }

    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double check = Double.parseDouble(input);
            //kiem tra so co nam trong khoang gia tri khong
            if (check >= min && check <= max) {
                return check;
            } else {
                //in ra thong bao loi
                throw new Exception(String.format(Message.NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            //in ra thong bao loi
            throw new Exception(Message.INVALID_NUMBER_ERROR);
        }
    }
}
