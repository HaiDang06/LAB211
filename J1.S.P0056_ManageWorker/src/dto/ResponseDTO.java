/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constant.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.SalaryHistory;

/**
 *
 * @author Tuan Tran
 */
public class ResponseDTO {

    private String id;
    private String name;
    private int age;
    private double salary;
    private String status;
    private Date date;

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

    // Lấy mức lương tại thời điểm thay đổi
    public double getSalary() {
        return salary;
    }

    // Gán mức lương tại thời điểm thay đổi
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Lấy trạng thái thay đổi
    public String getStatus() {
        return status;
    }

    // Gán trạng thái thay đổi
    public void setStatus(String status) {
        this.status = status;
    }

    // Lấy ngày thay đổi lương
    public Date getDate() {
        return date;
    }

    // Gán ngày thay đổi lương
    public void setDate(Date date) {
        this.date = date;
    }

    // Tạo một dòng của bảng hiển thị từ dữ liệu của DTO
    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_REGEX);
        return String.format("%7s%10s%10s%10s%10s%15s\n",
                this.id,
                this.name,
                this.age,
                this.salary,
                this.status,
                df.format(date));
    }
}
