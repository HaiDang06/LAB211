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
 *
 * @author Tuan Tran
 */
public class TaskRepository {

    // Khai bao danh sach luu tru task va bien quan ly ma id tu tang
    private List<Task> taskList;
    private int lastId;

    // Khoi tao repository voi danh sach rong va id bat dau tu 0
    public TaskRepository() {
        this.taskList = new ArrayList<>();
        this.lastId = 0;
    }

    // Thuc hien them moi mot task vao danh sach tu doi tuong DTO
    public boolean addTask(TaskDTO dto) {
        Task task = new Task(dto.getTaskType(), dto.getRequirementName(),
                dto.getDate(), dto.getPlanFrom(), dto.getPlanTo(), dto.getAssign(), dto.getReviewer());
        task.setId(++lastId);
        return taskList.add(task);
    }

    // Thuc hien xoa task khoi danh sach dua theo ma id
    public boolean deleteTask(int id) {
        return taskList.removeIf(task -> task.getId() == id);
    }

    // Lay toan bộ danh sach task va chuyen doi thanh dinh dang hien thi ResponseDTO
    public List<ResponseDTO> getAllTasks() {
        // Tạo danh sách kết quả mới kiểu ResponseDTO
        List<ResponseDTO> result = new ArrayList<>();

        // Duyệt qua danh sách Task hiện có
        for (Task task : taskList) {
            ResponseDTO res = new ResponseDTO();
            // Gán dữ liệu đã format vào Body của DTO
            res.setId(task.getId());
            res.setRequirementName(task.getRequirementName());
            res.setTaskType(task.getTaskType());
            res.setDate(task.getDate());
            res.setTime(task.getPlanTo() - task.getPlanFrom());
            res.setAssign(task.getAssign());
            res.setReviewer(task.getReviewer());
            result.add(res);
        }
        return result;
    }

    // Tim kiem va tra ve task dua theo ma id
    public Task findById(int id) {
        for (Task task : taskList) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    // Kiem tra xem danh sach task co dang trong hay khong
    public boolean isEmpty() {
        return taskList.isEmpty();
    }
}