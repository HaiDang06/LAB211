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
 * Data Transfer Object (Response DTO) dùng để chuyển dữ liệu kết quả từ tầng Repository/Controller
 * đến tầng View để hiển thị cho người dùng.
 * Chứa thông tin đã tính toán sẵn như tổng thời gian thực hiện (time = planTo - planFrom).
 *
 * @author Tuan Tran
 */
public class ResponseDTO {

    /** Mã định danh của Task */
    private int id;

    /** Loại công việc (TaskType) */
    private TaskType taskType;

    /** Tên yêu cầu công việc */
    private String requirementName;

    /** Ngày thực hiện công việc */
    private Date date;

    /** Tổng thời gian thực hiện (time = planTo - planFrom) */
    private double time;

    /** Người được phân công thực hiện (Assignee) */
    private String assign;

    /** Người đánh giá / nghiệm thu kết quả (Reviewer) */
    private String reviewer;

    /**
     * Khởi tạo đối tượng ResponseDTO mặc định (không tham số).
     */
    public ResponseDTO() {
    }

    /**
     * Lấy mã ID của task.
     * @return mã ID
     */
    public int getId() {
        return id;
    }

    /**
     * Lấy loại công việc.
     * @return đối tượng enum TaskType
     */
    public TaskType getTaskType() {
        return taskType;
    }

    /**
     * Lấy tên yêu cầu công việc.
     * @return tên yêu cầu công việc
     */
    public String getRequirementName() {
        return requirementName;
    }

    /**
     * Lấy ngày thực hiện công việc.
     * @return ngày thực hiện
     */
    public Date getDate() {
        return date;
    }

    /**
     * Lấy tổng thời gian thực hiện công việc.
     * @return số giờ làm việc (double)
     */
    public double getTime() {
        return time;
    }

    /**
     * Lấy tên người thực hiện công việc.
     * @return tên người thực hiện
     */
    public String getAssign() {
        return assign;
    }

    /**
     * Lấy tên người đánh giá.
     * @return tên người đánh giá
     */
    public String getReviewer() {
        return reviewer;
    }

    /**
     * Thiết lập mã ID cho task.
     * @param id mã ID cần gán
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Thiết lập loại công việc.
     * @param taskType loại công việc
     */
    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    /**
     * Thiết lập tên yêu cầu công việc.
     * @param requirementName tên yêu cầu công việc
     */
    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    /**
     * Thiết lập ngày thực hiện công việc.
     * @param date ngày thực hiện
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Thiết lập tổng thời gian thực hiện công việc.
     * @param time tổng số giờ làm việc
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Thiết lập người thực hiện công việc.
     * @param assign tên người thực hiện
     */
    public void setAssign(String assign) {
        this.assign = assign;
    }

    /**
     * Thiết lập người đánh giá công việc.
     * @param reviewer tên người đánh giá
     */
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    /**
     * Định dạng thông tin của Task thành một dòng trong bảng hiển thị danh sách.
     * Sử dụng định dạng cột có độ rộng cố định: ID, Name, TaskType, Date, Time, Assignee, Reviewer.
     *
     * @return chuỗi biểu diễn hàng dữ liệu của Task trên console
     */
    @Override
    public String toString() {
        // Định dạng ngày tháng theo pattern chuẩn "dd-MM-yyyy"
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_PATTERN);
        // Trả về chuỗi dòng bảng với các cột có độ rộng căn lề trái phù hợp
        return String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                getId(),
                getRequirementName(),
                getTaskType(),
                dateFormat.format(getDate()),
                getTime(),
                getAssign(),
                getReviewer()
        );
    }
}
