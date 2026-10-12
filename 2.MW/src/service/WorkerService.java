package service;

import constant.Messages;
import dto.ResponseDTO;
import dto.WorkerDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;

/**
 * Lớp WorkerService thuộc tầng Service (Business Logic Layer / Service Layer).
 * 
 * Vai trò và nhiệm vụ:
 * - Tiếp nhận yêu cầu từ Controller, xử lý các nghiệp vụ (kiểm tra danh sách rỗng, sắp xếp, tổng hợp dữ liệu).
 * - Tương tác với tầng Repository để lấy hoặc lưu trữ dữ liệu.
 * - Chuẩn bị và chuyển đổi dữ liệu thành các DTO phù hợp để trả về cho tầng trên hiển thị.
 */
public class WorkerService {

    /**
     * Đối tượng Repository dùng để thao tác với nguồn dữ liệu công nhân.
     */
    private WorkerRepository repo;

    /**
     * Hàm khởi tạo WorkerService, khởi tạo đối tượng {@link WorkerRepository}.
     */
    public WorkerService() {
        this.repo = new WorkerRepository();
    }

    /**
     * Nghiệp vụ thêm một công nhân mới vào hệ thống.
     * Chuyển giao dữ liệu từ DTO xuống tầng Repository để thêm vào danh sách.
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa dữ liệu công nhân cần thêm.
     * @return {@code true} nếu thêm thành công.
     * @throws Exception nếu trùng mã công nhân hoặc gặp lỗi từ tầng Repository.
     */
    public boolean addWorker(WorkerDTO dto) throws Exception {
        return repo.addWorker(dto);
    }

    /**
     * Nghiệp vụ tăng lương cho một công nhân.
     * Kiểm tra điều kiện nghiệp vụ: Danh sách công nhân không được rỗng trước khi xử lý.
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa mã công nhân và số tiền muốn tăng.
     * @return {@code true} nếu tăng lương thành công.
     * @throws Exception nếu danh sách rỗng hoặc không tìm thấy mã công nhân.
     */
    public boolean upSalary(WorkerDTO dto) throws Exception {
        // Kiểm tra danh sách rỗng
        if (repo.isEmpty()) {
            throw new Exception(Messages.EMPTY_ERROR);
        }
        return repo.upSalary(dto);
    }

    /**
     * Nghiệp vụ giảm lương cho một công nhân.
     * Kiểm tra điều kiện nghiệp vụ: Danh sách công nhân không được rỗng trước khi xử lý.
     * 
     * @param dto Đối tượng {@link WorkerDTO} chứa mã công nhân và số tiền muốn giảm.
     * @return {@code true} nếu giảm lương thành công.
     * @throws Exception nếu danh sách rỗng hoặc không tìm thấy mã công nhân.
     */
    public boolean downSalary(WorkerDTO dto) throws Exception {
        // Kiểm tra danh sách rỗng
        if (repo.isEmpty()) {
            throw new Exception(Messages.EMPTY_ERROR);
        }
        return repo.downSalary(dto);
    }

    /**
     * Nghiệp vụ lấy và tổng hợp toàn bộ lịch sử thay đổi lương của tất cả công nhân trong hệ thống.
     * 
     * Quy trình xử lý:
     * 1. Lấy danh sách toàn bộ công nhân từ Repository; ném ngoại lệ nếu danh sách rỗng.
     * 2. Sắp xếp danh sách công nhân theo thứ tự tăng dần của mã ID bằng {@link Collections#sort(List)}.
     * 3. Duyệt qua từng công nhân và các bản ghi lịch sử tương ứng để trích xuất thành danh sách phẳng các {@link ResponseDTO}.
     * 4. Kiểm tra và trả về danh sách kết quả sẵn sàng cho tầng View hiển thị.
     * 
     * @return Danh sách các {@link ResponseDTO} chứa thông tin lịch sử lương đã sắp xếp theo ID công nhân.
     * @throws Exception nếu danh sách công nhân rỗng hoặc không có bản ghi lịch sử nào.
     */
    public List<ResponseDTO> getSalaryHistory() throws Exception {
        // Bước 1: Lấy danh sách công nhân từ Repo
        List<Worker> list = repo.getAll();
        if (list.isEmpty()) {
            throw new Exception(Messages.EMPTY_ERROR2);
        }

        // Bước 2: Sắp xếp danh sách công nhân theo ID tăng dần
        // Hàm sort sử dụng phương thức compareTo đã cài đặt trong lớp Worker
        Collections.sort(list);

        // Bước 3: Chuyển đổi và làm phẳng dữ liệu thành danh sách ResponseDTO
        List<ResponseDTO> result = new ArrayList<>();
        for (Worker w : list) {
            for (SalaryHistory sh : w.getHistory()) {
                ResponseDTO res = new ResponseDTO();
                res.setId(w.getId());
                res.setName(w.getName());
                res.setAge(w.getAge());
                res.setStatus(sh.getStatus());
                res.setSalary(sh.getSalaryHistory());
                res.setDate(sh.getDate());
                result.add(res);
            }
        }

        // Bước 4: Kiểm tra nếu danh sách kết quả rỗng
        if (result.isEmpty()) {
            throw new Exception(Messages.EMPTY_ERROR2);
        }

        return result;
    }
}