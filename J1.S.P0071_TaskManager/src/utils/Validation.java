/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import constant.Message;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Lớp tiện ích (Utility Class) cung cấp các phương thức xác thực và chuẩn hóa
 * dữ liệu đầu vào.
 * Bao gồm kiểm tra số nguyên trong khoảng, kiểm tra số thực (bước nhảy 0.5),
 * kiểm tra định dạng ngày tháng và kiểm tra chuỗi ký tự theo Regular
 * Expression.
 *
 * @author Tuan Tran
 */
public class Validation {

    // Khoi tao private constructor de ngan chan viec tao the hien cua lop tien ich
    private Validation() {
    }

    // Kiem tra va phan tich gia tri so nguyen nhap vao nam trong khoang cho phep
    public static int getInt(String input, int min, int max) throws Exception {
        try {
            int check = Integer.parseInt(input);
            if (check >= min && check <= max) {
                return check;
            } else {
                throw new Exception(String.format(Message.INTERGER_NUMBER_RANGE_ERROR, min, max));
            }
        } catch (NumberFormatException e) {
            throw new Exception(Message.ERROR_INVALID_GENERAL);
        }
    }

    // Kiem tra va chuyen doi chuoi thanh doi tuong ngay thang nam theo dinh dang
    public static Date getDate(String input, final String REGEX) throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat(REGEX);
        dateFormat.setLenient(false);
        try {
            if (input.isEmpty()) {
                return null;
            }
            return dateFormat.parse(input);
        } catch (ParseException e) {
            throw new Exception(Message.ERROR_INVALID_DATE_FORMAT);
        }
    }

    // Kiem tra va phan tich gia tri so thuc nhap vao nam trong khoang va buoc nhay
    // hop le
    public static double getDouble(String input, double min, double max) throws Exception {
        try {
            double check = Double.parseDouble(input);
            if (check >= min && check <= max) {
                if (check * 10 % 5 == 0) {
                    return check;
                }
                throw new Exception("Must be x.0 or x.5");
            } else {
                throw new Exception(String.format(Message.REAL_NUMBER_RANGE_ERROR, min, max));
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
}
