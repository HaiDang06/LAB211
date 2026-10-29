/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Tuan Tran
 */
public class WorkerDTO {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String workLocation;
    private String status;
    private double amount;

    // Tạo DTO rỗng, dữ liệu được Main gán dần khi nhập
    public WorkerDTO() {
    }

    // Lấy mã worker
    public String getId() {
        return id;
    }

    // Gán mã worker
    public void setId(String id) {
        this.id = id;
    }

    // Lấy tên worker
    public String getName() {
        return name;
    }

    // Gán tên worker
    public void setName(String name) {
        this.name = name;
    }

    // Lấy tuổi worker
    public int getAge() {
        return age;
    }

    // Gán tuổi worker
    public void setAge(int age) {
        this.age = age;
    }

    // Lấy lương ban đầu khi thêm worker
    public double getSalary() {
        return salary;
    }

    // Gán lương ban đầu khi thêm worker
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Lấy nơi làm việc
    public String getWorkLocation() {
        return workLocation;
    }

    // Gán nơi làm việc
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    // Lấy số tiền tăng/giảm
    public double getAmount() {
        return amount;
    }

    // Gán số tiền tăng/giảm
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Lấy trạng thái thay đổi lương (UP/DOWN)
    public String getStatus() {
        return status;
    }

    // Gán trạng thái thay đổi lương (UP/DOWN)
    public void setStatus(String status) {
        this.status = status;
    }

}
