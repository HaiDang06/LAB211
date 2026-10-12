/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.Message;
import dto.ResponseDTO;
import dto.TaskDTO;
import java.util.ArrayList;
import java.util.List;
import repository.TaskRepository;
import view.TaskView;

/**
 *
 * @author win
 */
public class Controller {

    private TaskRepository repo; // Gọi trực tiếp Repository
    private TaskDTO dto;
    private TaskView view;

    public Controller() {
        this.repo = new TaskRepository();
        this.dto = new TaskDTO();
        this.view = new TaskView();
    }

    public TaskView getView() {
        return view;
    }

    public TaskDTO getDto() {
        return dto;
    }

    public void addTask() {
        // Thực hiện thêm và kiểm tra kết quả trả về
        if (repo.addTask(dto)) {
            view.printMessage(Message.SUCCESS_ADD_MESSAGE); // Sửa tại đây
        } else {
            view.printMessage(Message.ERROR_CANNOT_ADD); // Sửa tại đây
        }
    }

    public void deleteTask() {
        // Logic kiểm tra ID tồn tại trước khi xóa (Thay cho Service)
        if (repo.findById(dto.getId()) == null) {
            view.printMessage(Message.ERROR_CANNOT_FOUND); // Sửa tại đây
            return;
        }

        if (repo.deleteTask(dto.getId())) {
            view.printMessage(Message.SUCCESS_DELETE_MESSAGE); // Sửa tại đây
        }
    }

    public void showTasks() {
        try {
            // Kiểm tra danh sách trống trước khi lấy dữ liệu
            if (repo.isEmpty()) {
                throw new Exception(Message.ERROR_EMPTY);
            }
            // Yêu cầu View hiển thị
            List<ResponseDTO> response = repo.getAllTasks();
            view.setResponseDTO(response);
            view.printTask();
        } catch (Exception ex) {
            view.printMessage(ex.getMessage()); // Sửa tại đây
        }
    }

    // Getters và Setters cho DTO
    public void setDto(TaskDTO dto) {
        this.dto = dto;
    }
}