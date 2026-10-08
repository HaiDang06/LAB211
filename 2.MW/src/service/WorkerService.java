package service;

import constant.Messages;
import dto.ResponseDTO;
import dto.WorkerDTO;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Lớp dịch vụ (Service) xử lý các nghiệp vụ liên quan đến công nhân (Worker).
 */
public class WorkerService {
    private WorkerRepository workerRepository;

    public WorkerService() {
        this.workerRepository = new WorkerRepository();
    }

    /**
     * Thêm một công nhân mới vào hệ thống.
     *
     * @param workerDTO Đối tượng chứa thông tin công nhân cần thêm
     * @return true nếu thêm thành công, ngược lại false
     * @throws Exception nếu có lỗi xảy ra
     */
    public boolean addWorker(WorkerDTO workerDTO) throws Exception{
        // Tạo đối tượng Worker từ dữ liệu truyền vào
        Worker newWorker = new Worker(workerDTO.getId(), workerDTO.getName(), workerDTO.getAge(),
                workerDTO.getSalary(), workerDTO.getWorkLocation());
        // Khởi tạo lịch sử lương ban đầu
        SalaryHistory salaryHistory = new SalaryHistory(workerDTO.getSalary(), "INITIAL", new Date());
        newWorker.getHistory().add(salaryHistory);
        
        // Lưu công nhân vào kho dữ liệu
        return workerRepository.add(newWorker);
    }

    /**
     * Cập nhật (tăng hoặc giảm) lương của một công nhân.
     *
     * @param workerDTO Đối tượng chứa thông tin cập nhật lương (ID, số tiền, trạng thái UP/DOWN)
     * @return true nếu cập nhật thành công, ngược lại false
     * @throws Exception nếu danh sách trống hoặc không tìm thấy công nhân
     */
    public boolean updateSalary(WorkerDTO workerDTO) throws Exception{
        Worker worker = workerRepository.getWorkerById(workerDTO.getId());
        double salaryUpdate;
        // Ghi lại lịch sử cập nhật lương với thời gian hiện tại
        SalaryHistory salaryHistory = new SalaryHistory(workerDTO.getSalary(), workerDTO.getStatus(), new Date());

        // Kiểm tra danh sách trống
        if (workerRepository.isEmpty()){
            throw new Exception(Messages.EMPTY_ERROR);
        }

        // Kiểm tra công nhân có tồn tại hay không
        if (worker == null){
            throw new Exception(Messages.NOT_FOUND_ID_ERROR);
        }

        // Tính toán mức lương mới
        if (workerDTO.getStatus().equalsIgnoreCase("UP")){
            salaryUpdate = worker.getCurrentSalary() + workerDTO.getAmount();
        } else {
            // Tránh trường hợp lương bị âm
            salaryUpdate = Math.max(0, worker.getCurrentSalary() - workerDTO.getAmount());
        }
        
        // Cập nhật mức lương và thêm vào lịch sử
        worker.setCurrentSalary(salaryUpdate);
        return worker.getHistory().add(salaryHistory);
    }

    /**
     * Lấy toàn bộ lịch sử thay đổi lương của tất cả công nhân.
     *
     * @return Danh sách các đối tượng ResponseDTO chứa thông tin lịch sử
     * @throws Exception nếu không có dữ liệu lịch sử
     */
    public List<ResponseDTO> getSalaryHistory() throws Exception{
        List<Worker> historyList = workerRepository.getAll();
        List<ResponseDTO> resultList = new ArrayList<>();

        // Kiểm tra nếu danh sách công nhân trống
        if (historyList.isEmpty()){
            throw new Exception(Messages.EMPTY_ERROR2);
        }

        // Duyệt qua từng công nhân và lấy lịch sử lương của họ
        for (Worker worker: historyList){
            for (SalaryHistory salaryHistory: worker.getHistory()){
                ResponseDTO responseDTO = new ResponseDTO();
                responseDTO.setId(worker.getId());
                responseDTO.setName(worker.getName());
                responseDTO.setAge(worker.getAge());
                responseDTO.setSalary(salaryHistory.getSalaryHistory());
                responseDTO.setStatus(salaryHistory.getStatus());
                responseDTO.setDate(salaryHistory.getDate());
                resultList.add(responseDTO);
            }
        }

        // Kiểm tra nếu kết quả trả về trống
        if (resultList.isEmpty()){
            throw new Exception(Messages.EMPTY_ERROR2);
        }

        return resultList;
    }
}
