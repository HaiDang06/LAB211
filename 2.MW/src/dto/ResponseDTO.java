package dto;

import constant.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Lớp Data Transfer Object (DTO) dùng để đóng gói dữ liệu kết quả trả về từ tầng Service
 * lên tầng View phục vụ cho việc hiển thị lịch sử thay đổi lương của công nhân.
 * 
 * Mỗi đối tượng ResponseDTO là một dòng dữ liệu phẳng (flattened record), kết hợp giữa
 * thông tin cơ bản của công nhân (ID, Name, Age) và thông tin của từng lần biến động lương (Salary, Status, Date).
 */
public class ResponseDTO {

    /**
     * Mã định danh công nhân.
     */
    private String id;

    /**
     * Họ tên công nhân.
     */
    private String name;

    /**
     * Tuổi của công nhân.
     */
    private int age;

    /**
     * Mức lương tại thời điểm ghi nhận biến động.
     */
    private double salary;

    /**
     * Trạng thái biến động lương ("INITIAL", "UP" hoặc "DOWN").
     */
    private String status;

    /**
     * Thời gian diễn ra sự thay đổi lương.
     */
    private Date date;

    /**
     * Lấy mã công nhân.
     * 
     * @return Mã công nhân.
     */
    public String getId() {
        return id;
    }

    /**
     * Thiết lập mã công nhân.
     * 
     * @param id Mã công nhân.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Lấy họ tên công nhân.
     * 
     * @return Họ tên công nhân.
     */
    public String getName() {
        return name;
    }

    /**
     * Thiết lập họ tên công nhân.
     * 
     * @param name Họ tên công nhân.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lấy tuổi công nhân.
     * 
     * @return Tuổi công nhân.
     */
    public int getAge() {
        return age;
    }

    /**
     * Thiết lập tuổi công nhân.
     * 
     * @param age Tuổi công nhân.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Lấy mức lương tại thời điểm ghi nhận.
     * 
     * @return Mức lương.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Thiết lập mức lương tại thời điểm ghi nhận.
     * 
     * @param salary Mức lương.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Lấy trạng thái biến động lương ("INITIAL", "UP" hoặc "DOWN").
     * 
     * @return Trạng thái thay đổi lương.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Thiết lập trạng thái biến động lương.
     * 
     * @param status Trạng thái thay đổi lương.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Lấy thời gian diễn ra biến động lương.
     * 
     * @return Đối tượng Date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Thiết lập thời gian diễn ra biến động lương.
     * 
     * @param date Đối tượng Date.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Định dạng đối tượng ResponseDTO thành một dòng văn bản tương ứng với cấu trúc cột của bảng hiển thị:
     * Code (7 ký tự), Name (10 ký tự), Age (10 ký tự), Salary (10 ký tự), Status (10 ký tự), Date (15 ký tự).
     * 
     * @return Chuỗi thông tin đã được căn chỉnh cột phù hợp với Header của bảng.
     */
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_REGEX);
        return String.format("%7s%10s%10s%10.1f%10s%15s",
                this.id,
                this.name,
                this.age,
                this.salary,
                this.status,
                df.format(this.date));
    }
}
