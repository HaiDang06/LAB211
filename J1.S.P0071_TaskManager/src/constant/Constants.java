package constant;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Lớp chứa các hằng số dùng chung trong toàn bộ ứng dụng quản lý Task (J1.S.P0071).
 * Bao gồm các biểu thức chính quy (Regex) và định dạng ngày tháng, thời gian.
 *
 * @author Tuan Tran
 */
public class Constants {

    // Khởi tạo constructor private để ngăn việc tạo thể hiện của lớp hằng số
    private Constants() {
    }

    /**
     * Biểu thức chính quy (Regex) kiểm tra tên và chuỗi văn bản:
     * Chỉ chấp nhận chữ cái thường, hoa, chữ số và khoảng trắng.
     */
    public static final String REGEX_NAME = "[A-Za-z0-9\\s]+";

    /**
     * Định dạng chuẩn cho ngày tháng trong chương trình (ngày-tháng-năm).
     */
    public static final String DATE_FORMAT_PATTERN = "dd-MM-yyyy";

    /**
     * Định dạng hiển thị thời gian số thực (lấy 1 chữ số sau dấu phẩy).
     */
    public static final String TIME_FORMAT_PATTERN = "%.1f";
}
