package repository;

import constant.Message;
import dto.WorkerDTO;
import java.util.ArrayList;
import java.util.List;
import model.Worker;

public class WorkerRepository {

    private List<Worker> workerList;

    public WorkerRepository() {
        this.workerList = new ArrayList<>();
    }

    // Tìm worker theo mã (không phân biệt hoa thường), không thấy thì trả về null
    public Worker getWorkerById(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    // Yêu cầu 1 & 4: Chỉ tạo và thêm Worker vào list, dùng void thay vì boolean
    public void addWorker(WorkerDTO dto) throws Exception {
        if (getWorkerById(dto.getId()) != null) {
            throw new Exception(String.format(Message.DUPLICATE_ERROR, dto.getId()));
        }

        // Constructor của Worker đã tự động add SalaryHistory "INITIAL"
        Worker newWorker = new Worker(dto.getId(), dto.getName(), dto.getAge(),
                dto.getSalary(), dto.getWorkLocation());

        workerList.add(newWorker);
    }

    // Lấy bản sao danh sách worker
    public List<Worker> getWorkerList() {
        return new ArrayList<>(workerList);
    }

    // Kiểm tra kho dữ liệu có rỗng hay không
    public boolean isEmpty() {
        return workerList.isEmpty();
    }
}