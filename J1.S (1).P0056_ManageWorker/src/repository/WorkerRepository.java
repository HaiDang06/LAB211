package repository;

import constant.Message;
import dto.WorkerDTO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.SalaryHistory;
import model.Worker;

public class WorkerRepository {
    private List<Worker> workerList;

    public WorkerRepository() {
        this.workerList = new ArrayList<>();
    }

    public Worker getWorkerById(String id) {
        for (Worker worker : workerList) {
            if (worker.getId().equalsIgnoreCase(id)) return worker;
        }
        return null;
    }

    // Nhận DTO và xử lý add (Create)
    public boolean addWorker(WorkerDTO dto) throws Exception {
        if (getWorkerById(dto.getId()) != null) {
            throw new Exception(String.format(Message.DUPLICATE_ERROR, dto.getId()));
        }
        
        // Map DTO sang Model ngay tại Repo
        Worker newWorker = new Worker(dto.getId(), dto.getName(), dto.getAge(),
                dto.getSalary(), dto.getWorkLocation());
        
        SalaryHistory initialHistory = new SalaryHistory(dto.getSalary(), "INITIAL", new Date());
        newWorker.getHistory().add(initialHistory);

        return workerList.add(newWorker);
    }

    // Tách riêng hàm upSalary (Update)
    public boolean upSalary(WorkerDTO dto) throws Exception {
        Worker worker = getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Message.NOT_FOUND_ID_ERROR);
        }
        double newSalary = worker.getCurrentSalary() + dto.getAmount();
        worker.setCurrentSalary(newSalary);
        
        SalaryHistory history = new SalaryHistory(newSalary, "UP", new Date());
        return worker.getHistory().add(history);
    }

    // Tách riêng hàm downSalary (Update)
    public boolean downSalary(WorkerDTO dto) throws Exception {
        Worker worker = getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Message.NOT_FOUND_ID_ERROR);
        }
        double newSalary = Math.max(0, worker.getCurrentSalary() - dto.getAmount());
        worker.setCurrentSalary(newSalary);
        
        SalaryHistory history = new SalaryHistory(newSalary, "DOWN", new Date());
        return worker.getHistory().add(history);
    }

    public List<Worker> getAll() {
        return new ArrayList<>(workerList);
    }

    public boolean isEmpty() {
        return workerList.isEmpty();
    }
}