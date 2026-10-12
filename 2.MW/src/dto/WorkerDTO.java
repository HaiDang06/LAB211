package dto;

/**
 * Lớp Data Transfer Object (DTO) dùng để đóng gói và vận chuyển dữ liệu người dùng nhập từ giao diện (Main/View)
 * xuống các tầng xử lý nghiệp vụ (Controller, Service, Repository).
 * 
 * Tại sao cần dùng WorkerDTO thay vì dùng trực tiếp thực thể Worker?
 * - Giảm sự phụ thuộc (Decoupling) giữa tầng giao diện hiển thị và tầng thực thể dữ liệu (Domain Model).
 * - Chứa các trường dữ liệu tạm thời phục vụ cho các luồng xử lý riêng biệt (ví dụ: `amount` là số tiền cần tăng/giảm,
 *   `status` là cờ đánh dấu "UP"/"DOWN") mà lớp thực thể Worker không cần và không nên lưu trữ cố định.
 */
public class WorkerDTO {

    /**
     * Mã định danh của công nhân được nhập vào.
     */
    private String id;

    /**
     * Họ tên của công nhân.
     */
    private String name;

    /**
     * Tuổi của công nhân.
     */
    private int age;

    /**
     * Mức lương cơ bản ban đầu khi thêm mới công nhân.
     */
    private double salary;

    /**
     * Địa điểm / nơi làm việc của công nhân.
     */
    private String workLocation;

    /**
     * Trạng thái thao tác điều chỉnh lương ("UP" để tăng lương, "DOWN" để giảm lương).
     */
    private String status;

    /**
     * Số tiền cần tăng thêm hoặc giảm bớt đối với lương hiện tại.
     */
    private double amount;

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
     * Lấy mức lương cơ bản ban đầu.
     * 
     * @return Mức lương ban đầu.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Thiết lập mức lương cơ bản ban đầu.
     * 
     * @param salary Mức lương ban đầu.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Lấy trạng thái thao tác điều chỉnh lương ("UP" hoặc "DOWN").
     * 
     * @return Chuỗi trạng thái.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Thiết lập trạng thái thao tác điều chỉnh lương.
     * 
     * @param status Trạng thái ("UP" hoặc "DOWN").
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Lấy địa điểm làm việc.
     * 
     * @return Nơi làm việc.
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Thiết lập địa điểm làm việc.
     * 
     * @param workLocation Nơi làm việc.
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    /**
     * Lấy số tiền tăng thêm hoặc giảm bớt.
     * 
     * @return Số tiền biến động (kiểu double).
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Thiết lập số tiền tăng thêm hoặc giảm bớt.
     * 
     * @param amount Số tiền biến động.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
