/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import constant.Constants;
import constant.TaskType;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Tuan Tran
 */
public class ResponseDTO {
    
// Khai bao cac thuoc tinh luu tru thong tin hien thi cua task
    private int id;
    private TaskType taskType;
    private String requirementName;
    private Date date;
    private double time;
    private String assign;
    private String reviewer;

// Cac phuong thuc getter lay gia tri thuoc tinh
    public int getId() {
        return id;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public Date getDate() {
        return date;
    }

    public double getTime() {
        return time;
    }

    public String getAssign() {
        return assign;
    }

    public String getReviewer() {
        return reviewer;
    }
// Cac phuong thuc setter gan gia tri cho thuoc tinh
    public void setId(int id) {
        this.id = id;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    // Phuong thuc dinh dang va tra ve chuoi thong tin de hien thi len man hinh dang bang
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_PATTERN);
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                getId(),
                getRequirementName(),
                getTaskType().getName(),
                dateFormat.format(getDate()),
                getTime(),
                getAssign(),
                getReviewer()
        );
    }
}
