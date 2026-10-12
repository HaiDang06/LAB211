package model;

import java.util.Date;

/**
 * Lớp thực thể SalaryHistory đại diện cho một bản ghi lịch sử biến động lương của công nhân.
 * 
 * Mỗi khi lương của công nhân được khởi tạo, tăng (UP) hoặc giảm (DOWN),
 * một đối tượng SalaryHistory mới sẽ được tạo ra và lưu vào danh sách lịch sử của công nhân đó.
 */
public class SalaryHistory {

    /**
     * Mức lương của công nhân tại thời điểm diễn ra sự thay đổi (hoặc lương ban đầu).
     */
    private double salaryHistory;

    /**
     * Trạng thái điều chỉnh lương:
     * - "INITIAL": Lương khởi tạo khi mới thêm công nhân.
     * - "UP": Lương sau khi được tăng.
     * - "DOWN": Lương sau khi bị giảm.
     */
    private String status;

    /**
     * Thời gian (ngày, tháng, năm) thực hiện thao tác cập nhật mức lương.
     */
    private Date date;

    /**
     * Hàm khởi tạo (Constructor) tạo một bản ghi lịch sử thay đổi lương mới.
     * 
     * @param salaryHistory Mức lương được cập nhật tại thời điểm đó.
     * @param status Trạng thái biến động lương ("INITIAL", "UP", "DOWN").
     * @param date Ngày giờ thực hiện cập nhật lương.
     */
    public SalaryHistory(double salaryHistory, String status, Date date) {
        this.salaryHistory = salaryHistory;
        this.status = status;
        this.date = date;
    }

    /**
     * Lấy mức lương tại thời điểm ghi nhận lịch sử.
     * 
     * @return Mức lương (kiểu double).
     */
    public double getSalaryHistory() {
        return salaryHistory;
    }

    /**
     * Cập nhật mức lương cho bản ghi lịch sử.
     * 
     * @param salaryHistory Mức lương mới cần gán.
     */
    public void setSalaryHistory(double salaryHistory) {
        this.salaryHistory = salaryHistory;
    }

    /**
     * Lấy trạng thái thay đổi lương ("INITIAL", "UP" hoặc "DOWN").
     * 
     * @return Chuỗi trạng thái điều chỉnh lương.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Thiết lập trạng thái thay đổi lương.
     * 
     * @param status Trạng thái điều chỉnh ("UP", "DOWN", "INITIAL").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Lấy ngày giờ diễn ra biến động lương.
     * 
     * @return Đối tượng Date ghi nhận mốc thời gian.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Thiết lập ngày giờ cho bản ghi lịch sử.
     * 
     * @param date Đối tượng Date mốc thời gian mới.
     */
    public void setDate(Date date) {
        this.date = date;
    }
}
