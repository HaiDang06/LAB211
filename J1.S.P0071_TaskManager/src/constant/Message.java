/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 * Lớp chứa các chuỗi thông báo dùng trong giao diện console của chương trình.
 * Bao gồm tiêu đề menu, lời nhắc nhập liệu (prompt), thông báo lỗi và thông báo thành công.
 *
 * @author KATANA15
 */
public class Message {

    // Khởi tạo constructor private để ngăn việc tạo thể hiện của lớp thông báo
    private Message() {
    }

    // ==========================================
    // CÁC THÔNG BÁO MENU VÀ LỜI NHẮC NHẬP LIỆU
    // ==========================================

    /** Tiêu đề hiển thị cho menu chính */
    public static final String MENU_HEADER = "========= Task program =========\n";

    /** Danh sách các chức năng lựa chọn trong menu */
    public static final String MENU_BODY
            = "1. Add task\n"
            + "2. Delete tasks\n"
            + "3. Display task\n"
            + "4. Quit";

    /** Lời nhắc người dùng nhập lựa chọn chức năng menu */
    public static final String INPUT_CHOICE = "Your choice: ";

    /** Lời nhắc nhập mã Task ID cần thao tác */
    public static final String INPUT_TASK_ID = "Task ID: ";

    /** Lời nhắc nhập tên yêu cầu (Requirement Name) */
    public static final String INPUT_REQUIREMENT_NAME = "Requirement Name: ";

    /** Menu lựa chọn loại công việc (Task Type) từ 1 đến 4 */
    public static final String INPUT_TASK_TYPE_CHOICE = "Please enter 1->4\n"
            + "ID  Name\n"
            + "1.Code\n"
            + "2.Test\n"
            + "3.Design\n"
            + "4.Review \n"
            + "Enter your choice: ";

    /** Lời nhắc nhập ngày thực hiện task (định dạng dd-MM-yyyy) */
    public static final String INPUT_DATE = "Date: ";

    /** Lời nhắc nhập thời gian bắt đầu (From) */
    public static final String INPUT_PLAN_FROM = "From:";

    /** Lời nhắc nhập thời gian kết thúc (To) */
    public static final String INPUT_PLAN_TO = "To:";

    /** Lời nhắc nhập tên người thực hiện (Assignee) */
    public static final String INPUT_ASSIGNEE = "Assignee: ";

    /** Lời nhắc nhập tên người đánh giá (Reviewer) */
    public static final String INPUT_REVIEWER = "Reviewer: ";

    // ==========================================
    // CÁC THÔNG BÁO LỖI (ERROR MESSAGES)
    // ==========================================

    /** Lỗi dữ liệu nhập không hợp lệ chung */
    public static final String ERROR_INVALID_GENERAL = "Invalid!";

    /** Lỗi số thực không nằm trong phạm vi cho phép */
    public static final String REAL_NUMBER_RANGE_ERROR = "Please input number in a range %.1f -> %.1f";

    /** Lỗi số nguyên không nằm trong phạm vi cho phép */
    public static final String INTERGER_NUMBER_RANGE_ERROR = "Please input number in a range %d -> %d";

    /** Lỗi định dạng ngày tháng không đúng mẫu dd-MM-yyyy */
    public static final String ERROR_INVALID_DATE_FORMAT = "Invalid! Format dd-mm-yyyy";

    /** Lỗi thời gian Plan To phải lớn hơn Plan From và tối đa 17.5 */
    public static final String ERROR_PLAN_TO_RANGE_MAX = "Just be large than plan From and less than 17.5";

    /** Lỗi người dùng không nhập số thực hợp lệ */
    public static final String ERROR_INVALID_REAL_NUMBER = "Please enter real number!";

    /** Thông báo lỗi khi không thể thêm công việc */
    public static final String ERROR_CANNOT_ADD = "Can not add!!!";

    /** Thông báo lỗi mã loại công việc (Task Type ID) không tồn tại */
    public static final String ERROR_INVALID_TASK_TYPE_ID = "Invalid Task Type ID.";

    /** Thông báo lỗi khi không thể xóa công việc */
    public static final String ERROR_CANNOT_DELETE = "Can not delete!!!";

    /** Thông báo lỗi khi không tìm thấy công việc với ID đã nhập */
    public static final String ERROR_CANNOT_FOUND = "Task does not exist!";

    /** Thông báo lỗi danh sách công việc hiện đang trống */
    public static final String ERROR_EMPTY = "List Task is empty!";

    // ==========================================
    // CÁC THÔNG BÁO THÀNH CÔNG (SUCCESS MESSAGES)
    // ==========================================

    /** Thông báo thêm công việc thành công */
    public static final String SUCCESS_ADD_MESSAGE = "Add success!";

    /** Thông báo xóa công việc thành công */
    public static final String SUCCESS_DELETE_MESSAGE = "Delete success!";
}
