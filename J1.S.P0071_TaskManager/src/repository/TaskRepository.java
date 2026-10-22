/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dto.ResponseDTO;
import dto.TaskDTO;
import java.util.ArrayList;
import java.util.List;
import model.Task;

/**
 * Tầng lưu trữ và quản lý dữ liệu (Repository) cho đối tượng Task.
 * Quản lý danh sách các công việc trong bộ nhớ (In-Memory), thực hiện các thao tác CRUD cơ bản:
 * thêm mới, xóa, tìm kiếm theo ID và lấy danh sách hiển thị.
 *
 * @author Tuan Tran
 */
public class TaskRepository {

    /** Danh sách lưu trữ các đối tượng Task trong bộ nhớ */
    private List<Task> taskList;

    /** Biến đếm dùng để tự động sinh mã ID tăng dần cho mỗi Task mới */
    private int lastId;

    /**
     * Khởi tạo Repository với danh sách công việc rỗng và ID ban đầu là 0.
     */
    public TaskRepository() {
        this.taskList = new ArrayList<>();
        this.lastId = 0;
    }

    /**
     * Thêm mới một công việc vào danh sách lưu trữ.
     * Tạo đối tượng Task mới từ TaskDTO nhận được, tự động tăng lastId và gán cho Task.
     *
     * @param dto đối tượng TaskDTO chứa thông tin công việc người dùng đã nhập
     * @return true nếu thêm thành công vào danh sách, ngược lại trả về false
     */
    public boolean addTask(TaskDTO dto) {
        // Tạo thực thể Task từ thông tin trong TaskDTO
        Task task = new Task(dto.getTaskType(), dto.getRequirementName(),
                dto.getDate(), dto.getPlanFrom(), dto.getPlanTo(), dto.getAssign(), dto.getReviewer());
        // Tăng ID tự động và gán cho task
        task.setId(++lastId);
        // Lưu task vào danh sách
        return taskList.add(task);
    }

    /**
     * Xóa một công việc khỏi danh sách dựa theo mã ID.
     *
     * @param id mã định danh của task cần xóa
     * @return true nếu tìm thấy và xóa thành công, false nếu không có phần tử nào bị xóa
     */
    public boolean deleteTask(int id) {
        // Sử dụng removeIf để tìm và xóa phần tử có ID trùng khớp
        return taskList.removeIf(task -> task.getId() == id);
    }

    /**
     * Lấy toàn bộ danh sách công việc hiện có và chuyển đổi thành danh sách ResponseDTO để phục vụ hiển thị.
     * Tính toán tổng thời gian thực hiện: time = planTo - planFrom.
     *
     * @return danh sách các đối tượng ResponseDTO sẵn sàng hiển thị lên View
     */
    public List<ResponseDTO> getAllTasks() {
        // Tạo danh sách kết quả mới kiểu ResponseDTO
        List<ResponseDTO> result = new ArrayList<>();

        // Duyệt qua từng Task trong danh sách lưu trữ
        for (Task task : taskList) {
            ResponseDTO res = new ResponseDTO();
            // Gán dữ liệu tương ứng sang ResponseDTO
            res.setId(task.getId());
            res.setRequirementName(task.getRequirementName());
            res.setTaskType(task.getTaskType());
            res.setDate(task.getDate());
            // Tính toán tổng thời gian hoàn thành (tính theo giờ)
            res.setTime(task.getPlanTo() - task.getPlanFrom());
            res.setAssign(task.getAssign());
            res.setReviewer(task.getReviewer());
            // Thêm vào danh sách kết quả trả về
            result.add(res);
        }
        return result;
    }

    /**
     * Tìm kiếm một công việc trong danh sách dựa theo mã ID.
     *
     * @param id mã ID cần tìm kiếm
     * @return đối tượng Task nếu tìm thấy, hoặc null nếu không tồn tại
     */
    public Task findById(int id) {
        // Duyệt qua danh sách để tìm task có ID tương ứng
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        // Trả về null nếu không tìm thấy task với ID trên
        return null;
    }

    /**
     * Kiểm tra xem danh sách công việc hiện tại có đang trống hay không.
     *
     * @return true nếu danh sách không có phần tử nào, ngược lại trả về false
     */
    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}