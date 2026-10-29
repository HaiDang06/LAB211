package model;
import java.util.Date;

/**
 *
 * @author win
 */
public class SalaryHistory{
    private double salary;
    private String status;
    private Date date;

    // Tạo một bản ghi lịch sử lương: mức lương sau khi đổi, trạng thái, ngày đổi
    public SalaryHistory(double salary, String status, Date date) {
        this.salary = salary;
        this.status = status;
        this.date = date;
    }

    // Lấy mức lương tại thời điểm thay đổi
    public double getSalary() {
        return salary;
    }

    // Gán mức lương tại thời điểm thay đổi
    public void setSalary(double salary) {
        this.salary = salary;
    }


    // Lấy trạng thái thay đổi (UP/DOWN/INITIAL)
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

}
