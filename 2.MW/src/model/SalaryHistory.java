package model;

import java.util.Date;

/**
 * Lớp lưu trữ thông tin về lịch sử thay đổi lương của một công nhân.
 */
public class SalaryHistory {
    private double salaryHistory;
    private String status;
    private Date date;

    public SalaryHistory(double salaryHistory, String status, Date date) {
        this.salaryHistory = salaryHistory;
        this.status = status;
        this.date = date;
    }

    public double getSalaryHistory() {
        return salaryHistory;
    }

    public void setSalaryHistory(double salaryHistory) {
        this.salaryHistory = salaryHistory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
