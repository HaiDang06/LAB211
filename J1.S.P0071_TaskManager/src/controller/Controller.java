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
 * Tầng điều khiển (Controller) trong mô hình kiến trúc MVC.
 * Đóng vai trò làm cầu nối giữa giao diện người dùng (Main/View) và tầng dữ
 * liệu (TaskRepository).
 * Nhận dữ liệu truyền vào qua TaskDTO, thực thi các nghiệp vụ thêm, xóa, hiển
 * thị danh sách task
 * và yêu cầu TaskView phản hồi thông điệp tương ứng tới người dùng.
 *
 * @author win
 */
public class Controller {

    private TaskRepository repo; // Gọi trực tiếp Repository
    private TaskDTO dto;
    private TaskView view;

    /**
     * Khởi tạo Controller mặc định, khởi tạo các thành phần Repository, TaskDTO và
     * TaskView.
     */
    public Controller() {
        this.repo = new TaskRepository();
        this.dto = new TaskDTO();
        this.view = new TaskView();
    }

    /**
     * Lấy đối tượng TaskView hiện tại.
     * 
     * @return đối tượng TaskView
     */
    public TaskView getView() {
        return view;
    }

    /**
     * Lấy đối tượng TaskDTO hiện tại đang lưu trữ dữ liệu.
     * 
     * @return đối tượng TaskDTO
     */
    public TaskDTO getDto() {
        return dto;
    }

    /**
     * Thiết lập đối tượng TaskDTO mới chứa dữ liệu từ người dùng.
     * 
     * @param dto đối tượng TaskDTO mới
     */
    public void setDto(TaskDTO dto) {
        this.dto = dto;
    }

    /**
     * Xử lý nghiệp vụ thêm mới một Task vào hệ thống:
     * Chuyển đối tượng TaskDTO sang Repository để tạo và lưu Task mới.
     * Nếu thêm thành công, gửi thông báo thành công qua View.
     * Nếu thất bại, gửi thông báo lỗi qua View.
     */
    public void addTask() {
        // Thực hiện thêm task vào repository và kiểm tra kết quả trả về
        if (repo.addTask(dto)) {
            view.printMessage(Message.SUCCESS_ADD_MESSAGE);
        } else {
            view.printMessage(Message.ERROR_CANNOT_ADD);
        }
    }

    /**
     * Xử lý nghiệp vụ xóa một Task khỏi hệ thống theo ID:
     * Kiểm tra ID có tồn tại trong Repository hay không.
     * Nếu không tìm thấy, gửi thông báo lỗi "Task does not exist!" qua View.
     * Nếu tìm thấy, thực hiện xóa và thông báo thành công.
     */
    public void deleteTask() {
        // Kiểm tra xem Task với ID đã cho có tồn tại hay không trước khi thực hiện xóa
        if (repo.findById(dto.getId()) == null) {
            view.printMessage(Message.ERROR_CANNOT_FOUND);
            return;
        }

        // Tiến hành xóa task theo ID và thông báo kết quả thành công
        if (repo.deleteTask(dto.getId())) {
            view.printMessage(Message.SUCCESS_DELETE_MESSAGE);
        }
    }

    /**
     * Xử lý nghiệp vụ hiển thị danh sách tất cả các công việc:
     * Kiểm tra nếu danh sách trống thì thông báo lỗi "List Task is empty!".
     * Ngược lại, lấy danh sách ResponseDTO từ Repository, truyền vào View và gọi in
     * bảng.
     */
    public void showTasks() {
        try {
            // Kiểm tra danh sách có trống hay không trước khi lấy dữ liệu
            if (repo.isEmpty()) {
                throw new Exception(Message.ERROR_EMPTY);
            }
            // Lấy danh sách ResponseDTO đã tính toán từ Repository
            List<ResponseDTO> response = repo.getAllTasks();
            // Đẩy dữ liệu sang tầng View
            view.setResponseDTO(response);
            // Yêu cầu View in danh sách dạng bảng ra màn hình
            view.printTask();
        } catch (Exception ex) {
            // Bắt và in thông báo lỗi nếu danh sách rỗng hoặc có lỗi phát sinh
            view.printMessage(ex.getMessage());
        }
    }
}