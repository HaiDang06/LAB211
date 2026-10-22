/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;
import constant.TaskType;

/**
 * Data Transfer Object (DTO) cho thực thể Task.
 * Dùng để truyền nhận dữ liệu giữa tầng giao diện (View/Main), tầng điều khiển (Controller)
 * và tầng lưu trữ dữ liệu (Repository) mà không làm lộ trực tiếp thực thể gốc.
 *
 * @author Tuan Tran
 */
public class TaskDTO {

    /** Mã định danh của Task */
    private int id;

    /** Loại công việc (Code, Test, Design, Review) */
    private TaskType taskType;

    /** Tên yêu cầu công việc */
    private String requirementName;

    /** Ngày thực hiện công việc */
    private Date date;

    /** Thời gian bắt đầu theo kế hoạch (tính theo giờ, ví dụ: 8.0, 8.5) */
    private double planFrom;

    /** Thời gian kết thúc theo kế hoạch (tính theo giờ, ví dụ: 17.0, 17.5) */
    private double planTo;

    /** Người được phân công thực hiện công việc (Assignee) */
    private String assign;

    /** Người đánh giá / nghiệm thu kết quả công việc (Reviewer) */
    private String reviewer;

    /**
     * Khởi tạo đối tượng TaskDTO mặc định (không tham số).
     */
    public TaskDTO() {
    }

    /**
     * Lấy mã ID của task.
     * @return mã ID của task
     */
    public int getId() {
        return id;
    }

    /**
     * Thiết lập mã ID cho task.
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
     * Thiết lập loại công việc (TaskType).
     * @param taskType đối tượng enum TaskType
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
     * Thiết lập tên yêu cầu công việc.
     * @param requirementName tên yêu cầu công việc
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * Lấy ngày thực hiện công việc.
     * @return đối tượng Date đại diện cho ngày thực hiện
     */
    public Date getDate() {
        return date;
    }

    /**
     * Thiết lập ngày thực hiện công việc.
     * @param date ngày thực hiện
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Lấy thời gian bắt đầu dự kiến.
     * @return thời gian bắt đầu (giờ)
     */
    public double getPlanFrom() {
        return planFrom;
    }

    /**
     * Thiết lập thời gian bắt đầu dự kiến.
     * @param planFrom thời gian bắt đầu (giờ)
     */
    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    /**
     * Lấy thời gian kết thúc dự kiến.
     * @return thời gian kết thúc (giờ)
     */
    public double getPlanTo() {
        return planTo;
    }

    /**
     * Thiết lập thời gian kết thúc dự kiến.
     * @param planTo thời gian kết thúc (giờ)
     */
    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    /**
     * Lấy tên người được phân công thực hiện.
     * @return tên người được phân công (Assignee)
     */
    public String getAssign() {
        return assign;
    }

    /**
     * Thiết lập người thực hiện công việc.
     * @param assign tên người được phân công
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
     * Thiết lập người đánh giá công việc.
     * @param reviewer tên người đánh giá
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
}
