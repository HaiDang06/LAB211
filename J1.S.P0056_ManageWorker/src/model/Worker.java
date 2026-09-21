/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.Message;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author win
 */
public class Worker implements Comparable<Worker> {

    private String id;
    private String name;
    private int age;
    private double currentSalary;
    private String workLocation;
    List<SalaryHistory> history;

    public Worker(String id, String name, int age, double currentSalary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.currentSalary = currentSalary;
        this.workLocation = workLocation;
        this.history = new ArrayList<>();
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

    public List<SalaryHistory> getHistory() {
        return history;
    }

    public void setHistory(List<SalaryHistory> history) {
        this.history = history;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public int compareTo(Worker o) {
        return id.compareTo(o.id);
    }

@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    SimpleDateFormat df = new SimpleDateFormat(Message.DATE_REGEX); 
    for (SalaryHistory sh : history) {
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
