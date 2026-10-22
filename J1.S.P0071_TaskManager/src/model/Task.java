/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import constant.TaskType;
import java.util.Date;

/**
 * Thực thể đại diện cho một công việc (Task) trong hệ thống.
 * Chứa toàn bộ thông tin chi tiết của task: ID, loại task, tên yêu cầu,
 * ngày thực hiện, thời gian bắt đầu/kết thúc, người thực hiện và người đánh giá.
 *
 * @author win
 */
public class Task {

    /** Mã định danh duy nhất của Task (tự động tăng) */
    private int id;

    /** Loại công việc (Code, Test, Design, Review) */
    private TaskType taskType;

    /** Tên hoặc tóm tắt yêu cầu công việc */
    private String requirementName;

    /** Ngày thực hiện công việc */
    private Date date;

    /** Thời gian bắt đầu dự kiến (giờ từ 8.0 đến 17.0) */
    private double planFrom;

    /** Thời gian kết thúc dự kiến (giờ từ planFrom + 0.5 đến 17.5) */
    private double planTo;

    /** Tên người được giao công việc (Assignee) */
    private String assign;

    /** Tên người kiểm tra / nghiệm thu công việc (Reviewer) */
    private String reviewer;

    /**
     * Khởi tạo đối tượng Task mặc định (không có tham số).
     */
    public Task() {
    }

    /**
     * Khởi tạo đối tượng Task với đầy đủ thông tin chi tiết.
     * ID ban đầu được gán mặc định là 0 (sẽ được cập nhật khi lưu vào Repository).
     *
     * @param taskType loại công việc
     * @param requirementName tên yêu cầu công việc
     * @param date ngày thực hiện
     * @param planFrom thời gian bắt đầu (giờ)
     * @param planTo thời gian kết thúc (giờ)
     * @param assign người được giao thực hiện
     * @param reviewer người nghiệm thu
     */
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

    /**
     * Lấy mã ID định danh của task.
     * @return mã ID của task
     */
    public int getId() {
        return id;
    }

    /**
     * Gán mã ID định danh cho task.
     * @param id mã ID cần gán
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Lấy loại công việc (TaskType).
     * @return đối tượng enum TaskType
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Gán loại công việc (TaskType).
     * @param taskType loại công việc
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * Lấy tên yêu cầu công việc.
     * @return tên yêu cầu công việc
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Gán tên yêu cầu công việc.
     * @param requirementName tên yêu cầu công việc
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * Lấy ngày thực hiện công việc.
     * @return đối tượng Date ngày thực hiện
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gán ngày thực hiện công việc.
     * @param date ngày thực hiện
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Lấy thời gian bắt đầu theo kế hoạch.
     * @return thời gian bắt đầu (giờ)
     */
    public double getPlanFrom() {
        return planFrom;
    }

    /**
     * Gán thời gian bắt đầu theo kế hoạch.
     * @param planFrom thời gian bắt đầu (giờ)
     */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * Lấy thời gian kết thúc theo kế hoạch.
     * @return thời gian kết thúc (giờ)
     */
    public double getPlanTo() {
        return planTo;
    }

    /**
     * Gán thời gian kết thúc theo kế hoạch.
     * @param planTo thời gian kết thúc (giờ)
     */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /**
     * Lấy tên người được phân công thực hiện.
     * @return tên người thực hiện (Assignee)
     */
    public String getAssign() {
        return assign;
    }

    /**
     * Gán tên người được phân công thực hiện.
     * @param assign tên người thực hiện
     */
    public void setAssign(String assign) {
        this.assign = assign;
    }

    /**
     * Lấy tên người đánh giá công việc.
     * @return tên người đánh giá (Reviewer)
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Gán tên người đánh giá công việc.
     * @param reviewer tên người đánh giá
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}