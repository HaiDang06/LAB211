package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Worker implements Comparable<Worker> {

    private String id;
    private String name;
    private int age;
    private double currentSalary;
    private String workLocation;
    private List<SalaryHistory> salaryHistoryList;

    // Tạo worker mới và tự động ghi nhận mức lương ban đầu (INITIAL) vào lịch sử
    public Worker(String id, String name, int age, double currentSalary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.currentSalary = currentSalary;
        this.workLocation = workLocation;
        this.salaryHistoryList = new ArrayList<>();
        this.salaryHistoryList.add(new SalaryHistory(currentSalary, "INITIAL", new Date()));
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

    public List<SalaryHistory> getSalaryHistoryList() {
        return salaryHistoryList;
    }

    public void setSalaryHistoryList(List<SalaryHistory> salaryHistoryList) {
        this.salaryHistoryList = salaryHistoryList;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public int compareTo(Worker otherWorker) {
        return id.compareTo(otherWorker.id);
    }
}
