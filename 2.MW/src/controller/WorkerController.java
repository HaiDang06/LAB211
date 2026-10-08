package controller;

import constant.Messages;
import dto.ResponseDTO;
import dto.WorkerDTO;
import service.WorkerService;
import view.WorkerView;

import java.util.List;

/**
 * Lớp điều khiển (Controller) quản lý luồng dữ liệu giữa giao diện và các dịch vụ xử lý logic.
 */
public class WorkerController {
    private WorkerService service;
    private WorkerDTO dto;
    private WorkerView view;

    public WorkerController() {
        this.service = new WorkerService();
        this.dto = new WorkerDTO();
        this.view = new WorkerView();
    }

    public WorkerView getView() {
        return view;
    }

    /**
     * Cập nhật đối tượng DTO chứa thông tin truyền từ giao diện.
     * @param dto Đối tượng WorkerDTO
     */
    public void setDto(WorkerDTO dto) {
        this.dto = dto;
    }

    /**
     * Chức năng thêm công nhân mới.
     * Chuyển dữ liệu DTO xuống WorkerService và hiển thị thông báo.
     */
    public void addWorker() {
        try {
            if (service.addWorker(dto)) {
                view.setMess(Messages.SUCCESS_MESSAGE);
                view.printMess();
            }
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.printError();
        }
    }

    /**
     * Chức năng cập nhật lương (tăng hoặc giảm).
     * Gọi hàm cập nhật từ WorkerService và hiển thị thông báo.
     */
    public void updateSalary() {
        try {
            if (service.updateSalary(dto)) {
                view.setMess(Messages.SUCCESS_MESSAGE);
                view.printMess();
            }
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }

    /**
     * Chức năng hiển thị lịch sử thay đổi lương của tất cả công nhân.
     */
    public void showSalaryHistory() {
        try {
            // Lấy danh sách lịch sử từ service
            List<ResponseDTO> response = service.getSalaryHistory();
            // Đưa dữ liệu sang View để in ra màn hình
            view.setResponseDTO(response);
            view.printWorkers();
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }
}
