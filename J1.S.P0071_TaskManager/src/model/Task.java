/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.TaskType;
import java.util.Date;

/**
 *
 * @author win
 */
public class Task {

    // Khai bao cac thuoc tinh cua task
    private int id;
    private TaskType taskType;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String reviewer;

    // Khoi tao doi tuong task rong
    public Task() {
    }

    // Khoi tao doi tuong task voi day du thong tin chi tiet
    public Task(TaskType taskType, String requirementName, Date date, double planFrom,
            double planTo, String assign, String reviewer) {
        this.id = 0;
        this.taskType = taskType;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.reviewer = reviewer;
    }

    // Lay ma dinh danh id cua task
    public int getId() {
        return id;
    }

    // Gan ma dinh danh id cho task
    public void setId(int id) {
        this.id = id;
    }

    // Lay loai task
    public TaskType getTaskType() {
        return taskType;
    }

    // Gan loai task
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    // Lay ten yeu cau cong viec
    public String getRequirementName() {
        return requirementName;
    }

    // Gan ten yeu cau cong viec
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    // Lay thoi gian thuc hien task
    public Date getDate() {
        return date;
    }

    // Gan thoi gian thuc hien task
    public void setDate(Date date) {
        this.date = date;
    }

    // Lay thoi gian bat dau ke hoach
    public double getPlanFrom() {
        return planFrom;
    }

    // Gan thoi gian bat dau ke hoach
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    // Lay thoi gian ket thuc ke hoach
    public double getPlanTo() {
        return planTo;
    }

    // Gan thoi gian ket thuc ke hoach
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    // Lay nguoi duoc phan cong thuc hien
    public String getAssign() {
        return assign;
    }

    // Gan nguoi duoc phan cong thuc hien
    public void setAssign(String assign) {
        this.assign = assign;
    }

    // Lay nguoi kiem tra danh gia
    public String getReviewer() {
        return reviewer;
    }

    // Gan nguoi kiem tra danh gia
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}