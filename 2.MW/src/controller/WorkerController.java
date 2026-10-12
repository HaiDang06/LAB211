package controller;

import constant.Messages;
import dto.ResponseDTO;
import dto.WorkerDTO;
import java.util.List;
import service.WorkerService;
import view.WorkerView;

/**
 * Lớp WorkerController thuộc tầng Điều khiển (Controller) trong mô hình kiến trúc MVC.
 * 
 * Nhiệm vụ và vai trò:
 * - Tiếp nhận luồng công việc từ tầng giao diện (Main).
 * - Quản lý và điều phối dữ liệu giữa tầng Service (xử lý nghiệp vụ) và tầng View (hiển thị giao diện).
 * - Xử lý các ngoại lệ (try-catch) phát sinh từ các tầng bên dưới, sau đó thông báo kết quả tương ứng ra View.
 */
public class WorkerController {

    /**
     * Tầng nghiệp vụ xử lý các logic liên quan đến công nhân và lương.
     */
    private WorkerService service;

    /**
     * Đối tượng truyền tải dữ liệu chứa thông tin nhập từ người dùng.
     */
    private WorkerDTO dto;

    /**
     * Tầng giao diện hiển thị dữ liệu và các thông báo cho người dùng.
     */
    private WorkerView view;

    /**
     * Hàm khởi tạo Controller, khởi tạo sẵn các đối tượng Service, DTO và View.
     */
    public WorkerController() {
        this.service = new WorkerService();
        this.dto = new WorkerDTO();
        this.view = new WorkerView();
    }

    /**
     * Lấy đối tượng View đang được liên kết với Controller.
     * 
     * @return Thể hiện {@link WorkerView}.
     */
    public WorkerView getView() {
        return view;
    }

    /**
     * Thiết lập hoặc cập nhật dữ liệu DTO cần xử lý cho Controller trước khi thực thi nghiệp vụ.
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa dữ liệu người dùng vừa nhập.
     */
    public void setDto(WorkerDTO dto) {
        this.dto = dto;
    }

    /**
     * Điều phối thực hiện chức năng thêm một công nhân mới:
     * 1. Gọi phương thức {@link WorkerService#addWorker(WorkerDTO)} với dữ liệu DTO hiện tại.
     * 2. Nếu thêm thành công, chuyển thông báo thành công cho View và in ra màn hình.
     * 3. Bắt ngoại lệ nếu có lỗi (ví dụ trùng ID) và chuyển thông điệp lỗi cho View để in ra.
     */
    public void addWorker() {
        try {
            // Gọi tầng Service để thực hiện thêm mới công nhân
            if (service.addWorker(dto)) {
                view.setMess(Messages.SUCCESS_MESSAGE);
                view.printMess();
            }
        } catch (Exception e) {
            // Khi có lỗi, lấy thông điệp lỗi gán vào View và hiển thị
            view.setError(e.getMessage());
            view.printError();
        }
    }

    /**
     * Điều phối thực hiện chức năng cập nhật lương (tăng hoặc giảm):
     * 1. Phân loại yêu cầu dựa trên trạng thái status của DTO ("UP" hoặc "DOWN").
     * 2. Gọi hàm tương ứng ở tầng Service (upSalary hoặc downSalary).
     * 3. Nếu thực hiện thành công, hiển thị thông báo thành công qua View.
     * 4. Bắt ngoại lệ và hiển thị thông báo lỗi nếu thao tác thất bại (danh sách rỗng, không tìm thấy ID,...).
     */
    public void updateSalary() {
        try {
            boolean isSuccess = false;

            // Kiểm tra trạng thái được truyền từ giao diện để điều hướng nghiệp vụ thích hợp
            if (dto.getStatus().equalsIgnoreCase("UP")) {
                isSuccess = service.upSalary(dto);
            } else if (dto.getStatus().equalsIgnoreCase("DOWN")) {
                isSuccess = service.downSalary(dto);
            }

            // Nếu nghiệp vụ hoàn tất thành công, thông báo kết quả qua View
            if (isSuccess) {
                view.setMess(Messages.SUCCESS_MESSAGE);
                view.printMess();
            }
        } catch (Exception ex) {
            // Hiển thị thông báo lỗi bắt được từ tầng Service / Repository
            view.setError(ex.getMessage());
            view.printError();
        }
    }

    /**
     * Điều phối thực hiện chức năng hiển thị lịch sử thay đổi lương:
     * 1. Gọi {@link WorkerService#getSalaryHistory()} để lấy danh sách ResponseDTO đã tổng hợp và sắp xếp.
     * 2. Truyền danh sách dữ liệu sang cho View thông qua {@link WorkerView#setResponseDTO(List)}.
     * 3. Yêu cầu View hiển thị bảng lịch sử lương lên màn hình console.
     * 4. Bắt và hiển thị lỗi nếu danh sách công nhân hoặc lịch sử đang rỗng.
     */
    public void showSalaryHistory() {
        try {
            // Lấy danh sách lịch sử biến động lương từ Service
            List<ResponseDTO> response = service.getSalaryHistory();
            // Đẩy dữ liệu sang tầng View
            view.setResponseDTO(response);
            // Kích hoạt View in bảng dữ liệu ra màn hình
            view.printWorkers();
        } catch (Exception ex) {
            // Bắt và in thông báo lỗi (ví dụ: History is empty!)
            view.setError(ex.getMessage());
            view.printError();
        }
    }
}