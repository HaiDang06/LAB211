package service;

import constant.Message;
import dto.ResponseDTO;
import dto.WorkerDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;

public class WorkerService {

    private WorkerRepository workerRepository;

    public WorkerService() {
        this.workerRepository = new WorkerRepository();
    }

    // Yêu cầu 4: Đổi sang void vì nếu lỗi đã ném Exception
    public void addWorker(WorkerDTO dto) throws Exception {
        workerRepository.addWorker(dto);
    }

    // Yêu cầu 3: Xử lý nghiệp vụ tăng lương trực tiếp tại Service
    public void upSalary(WorkerDTO dto) throws Exception {
        if (workerRepository.isEmpty()) {
            throw new Exception(Message.EMPTY_WORKER_ERROR);
        }

        Worker worker = workerRepository.getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Message.NOT_FOUND_ID_ERROR);
        }

        // Cộng thêm số tiền vào lương hiện tại
        double newSalary = worker.getCurrentSalary() + dto.getAmount();
        worker.setCurrentSalary(newSalary);

        // Ghi thêm một dòng UP vào lịch sử
        SalaryHistory salaryHistory = new SalaryHistory(newSalary, "UP", new Date());
        worker.getSalaryHistoryList().add(salaryHistory);
    }

    // Yêu cầu 2 & 3: Xử lý nghiệp vụ giảm lương tại Service và kiểm tra lương < 0
    public void downSalary(WorkerDTO dto) throws Exception {
        if (workerRepository.isEmpty()) {
            throw new Exception(Message.EMPTY_WORKER_ERROR);
        }

        Worker worker = workerRepository.getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Message.NOT_FOUND_ID_ERROR);
        }

        // Yêu cầu 2: Kiểm tra nếu lương sau khi giảm < 0 thì báo lỗi và dừng lại luôn
        double newSalary = worker.getCurrentSalary() - dto.getAmount();
        if (newSalary < 0) {
            throw new Exception(Message.DOWN_SALARY_ERROR);
        }

        worker.setCurrentSalary(newSalary);

        // Ghi thêm một dòng DOWN vào lịch sử
        SalaryHistory salaryHistory = new SalaryHistory(newSalary, "DOWN", new Date());
        worker.getSalaryHistoryList().add(salaryHistory);
    }

    // Lấy lịch sử đổi lương của tất cả worker, sắp xếp theo mã worker
    public List<ResponseDTO> getInfomationSalary() throws Exception {
        List<Worker> workerList = workerRepository.getWorkerList();
        if (workerList.isEmpty()) {
            throw new Exception(Message.EMPTY_WORKER_ERROR);
        }

        Collections.sort(workerList);
        List<ResponseDTO> responseList = new ArrayList<>();
        for (Worker worker : workerList) {
            for (SalaryHistory salaryHistory : worker.getSalaryHistoryList()) {
                ResponseDTO response = new ResponseDTO();
                response.setId(worker.getId());
                response.setName(worker.getName());
                response.setAge(worker.getAge());
                response.setStatus(salaryHistory.getStatus());
                response.setSalary(salaryHistory.getSalary());
                response.setDate(salaryHistory.getDate());
                responseList.add(response);
            }
        }
        if (responseList.isEmpty()) {
            throw new Exception(Message.EMPTY_HISTORY_ERROR);
        }
        return responseList;
    }
}