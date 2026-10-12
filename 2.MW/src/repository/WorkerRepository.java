package repository;

import constant.Messages;
import dto.WorkerDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SalaryHistory;
import model.Worker;

/**
 * Lớp WorkerRepository thuộc tầng Repository (Data Access Object / Data Access Layer).
 * 
 * Nhiệm vụ chính:
 * - Trực tiếp quản lý và thao tác với nguồn dữ liệu (ở đây là danh sách trong bộ nhớ: in-memory List).
 * - Cung cấp các thao tác CRUD (Create, Read, Update) đối với thực thể công nhân {@link Worker}.
 * - Tách biệt logic lưu trữ dữ liệu khỏi logic nghiệp vụ (Service) và giao diện (View).
 */
public class WorkerRepository {

    /**
     * Danh sách lưu trữ tất cả các công nhân hiện có trong hệ thống trong bộ nhớ RAM.
     */
    private List<Worker> workerList;

    /**
     * Hàm khởi tạo WorkerRepository, khởi tạo một danh sách ArrayList rỗng để chứa công nhân.
     */
    public WorkerRepository() {
        this.workerList = new ArrayList<>();
    }

    /**
     * Tìm kiếm một công nhân trong danh sách theo mã ID.
     * 
     * @param id Mã công nhân cần tìm (không phân biệt chữ hoa, chữ thường).
     * @return Đối tượng {@link Worker} nếu tìm thấy, hoặc {@code null} nếu không tồn tại.
     */
    public Worker getWorkerById(String id) {
        // Duyệt tuần tự qua từng công nhân trong danh sách
        for (Worker worker : workerList) {
            // So sánh ID không phân biệt chữ hoa thường
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null; // Không tìm thấy công nhân phù hợp
    }

    /**
     * Tiếp nhận dữ liệu từ DTO, kiểm tra trùng lặp và thêm một công nhân mới vào danh sách.
     * Đồng thời tự động tạo một bản ghi lịch sử lương ban đầu ("INITIAL").
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa dữ liệu nhập từ người dùng.
     * @return {@code true} nếu thêm mới thành công vào danh sách.
     * @throws Exception nếu mã công nhân (ID) đã tồn tại trong hệ thống.
     */
    public boolean addWorker(WorkerDTO dto) throws Exception {
        // Bước 1: Kiểm tra tính duy nhất của mã công nhân
        if (getWorkerById(dto.getId()) != null) {
            throw new Exception(String.format(Messages.DUPLICATE_ERROR, dto.getId()));
        }

        // Bước 2: Chuyển đổi dữ liệu (Mapping) từ DTO sang Model thực thể Worker
        Worker newWorker = new Worker(
                dto.getId(),
                dto.getName(),
                dto.getAge(),
                dto.getSalary(),
                dto.getWorkLocation()
        );

        // Bước 3: Tạo bản ghi lịch sử lương khởi tạo ban đầu với trạng thái "INITIAL"
        SalaryHistory initialHistory = new SalaryHistory(dto.getSalary(), "INITIAL", new Date());
        newWorker.getHistory().add(initialHistory);

        // Bước 4: Thêm công nhân mới vào danh sách lưu trữ
        return workerList.add(newWorker);
    }

    /**
     * Thực hiện tăng lương cho một công nhân dựa trên mã ID và số tiền cần tăng.
     * Cập nhật mức lương hiện tại và ghi nhận một bản ghi lịch sử với trạng thái "UP".
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa mã công nhân và số tiền tăng (amount).
     * @return {@code true} nếu cập nhật và ghi lịch sử thành công.
     * @throws Exception nếu không tìm thấy công nhân với mã ID tương ứng.
     */
    public boolean upSalary(WorkerDTO dto) throws Exception {
        // Bước 1: Tìm kiếm công nhân theo ID
        Worker worker = getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Messages.NOT_FOUND_ID_ERROR);
        }

        // Bước 2: Tính toán mức lương mới sau khi tăng
        double newSalary = worker.getCurrentSalary() + dto.getAmount();
        worker.setCurrentSalary(newSalary);

        // Bước 3: Tạo bản ghi lịch sử biến động lương mới với trạng thái "UP"
        SalaryHistory history = new SalaryHistory(newSalary, "UP", new Date());
        return worker.getHistory().add(history);
    }

    /**
     * Thực hiện giảm lương cho một công nhân dựa trên mã ID và số tiền cần giảm.
     * Cập nhật mức lương hiện tại và ghi nhận một bản ghi lịch sử với trạng thái "DOWN".
     * Lưu ý: Mức lương sau khi giảm được giới hạn tối thiểu là 0 thông qua Math.max.
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa mã công nhân và số tiền giảm (amount).
     * @return {@code true} nếu cập nhật và ghi lịch sử thành công.
     * @throws Exception nếu không tìm thấy công nhân với mã ID tương ứng.
     */
    public boolean downSalary(WorkerDTO dto) throws Exception {
        // Bước 1: Tìm kiếm công nhân theo ID
        Worker worker = getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Messages.NOT_FOUND_ID_ERROR);
        }

        // Bước 2: Tính toán mức lương mới sau khi giảm (đảm bảo không âm)
        double newSalary = Math.max(0, worker.getCurrentSalary() - dto.getAmount());
        worker.setCurrentSalary(newSalary);

        // Bước 3: Tạo bản ghi lịch sử biến động lương mới với trạng thái "DOWN"
        SalaryHistory history = new SalaryHistory(newSalary, "DOWN", new Date());
        return worker.getHistory().add(history);
    }

    /**
     * Lấy toàn bộ danh sách công nhân hiện có trong hệ thống.
     * Trả về một danh sách mới chứa các phần tử (Shallow Copy) để bảo vệ tính đóng gói,
     * tránh việc danh sách nội bộ bị sửa đổi trực tiếp từ bên ngoài.
     * 
     * @return Danh sách mới chứa tất cả các {@link Worker}.
     */
    public List<Worker> getAll() {
        return new ArrayList<>(workerList);
    }

    /**
     * Kiểm tra xem danh sách công nhân có rỗng hay không.
     * 
     * @return {@code true} nếu chưa có công nhân nào trong danh sách, ngược lại trả về {@code false}.
     */
    public boolean isEmpty() {
        return workerList.isEmpty();
    }
}