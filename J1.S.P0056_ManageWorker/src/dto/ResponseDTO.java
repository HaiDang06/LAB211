/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constant.Message;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat(Message.DATE_REGEX);
        return String.format("%7s%10s%10s%10s%10s%15s\n",
                this.id,
                this.name,
                this.age,
                this.salary,
                this.status,
                df.format(date));
    }
}
