package model;

import constant.Constants;
import constant.Messages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp thực thể (Model) đại diện cho một Công nhân (Worker).
 * Cài đặt giao diện Comparable để hỗ trợ sắp xếp theo ID.
 */
public class Worker implements Comparable<Worker>{
    private String id;
    private String name;
    private int age;
    private double currentSalary;
    private String workLocation;
    // Danh sách lưu trữ lịch sử thay đổi lương của công nhân này
    List<SalaryHistory> historyList;

    public Worker(String id, String name, int age, double currentSalary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.currentSalary = currentSalary;
        this.workLocation = workLocation;
        this.historyList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    public List<SalaryHistory> getHistory() {
        return historyList;
    }

    public void setHistory(List<SalaryHistory> history) {
        this.historyList = history;
    }

    /**
     * So sánh 2 công nhân dựa theo ID (sắp xếp tăng dần).
     */
    @Override
    public int compareTo(Worker o){
        return id.compareTo(o.id);
    }

    /**
     * Định dạng chuỗi hiển thị thông tin công nhân và lịch sử lương.
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_REGEX);
        for (SalaryHistory sh : historyList) {
            sb.append(String.format("%7s%10s%10s%10s%10s%15s\n",
                    this.id,
                    this.name,
                    this.age,
                    sh.getSalaryHistory(),
                    sh.getStatus(),
                    df.format(sh.getDate())));
        }
        return sb.toString();
    }
}
