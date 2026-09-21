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

/**
 *
 * @author Tuan Tran
 */
public class WorkerService {

    private WorkerRepository repo;

    public WorkerService() {
        this.repo = new WorkerRepository();
    }

    public boolean addWorker(WorkerDTO dto) throws Exception {
        Worker newWorker = new Worker(dto.getId(), dto.getName(), dto.getAge(),
                dto.getSalary(), dto.getWorkLocation());
        
        // Thêm bản ghi lương ban đầu tại Service layer
        SalaryHistory initialHistory = new SalaryHistory(dto.getSalary(), "INITIAL", new Date());
        newWorker.getHistory().add(initialHistory);

        return repo.add(newWorker);
    }

    public boolean updateSalary(WorkerDTO dto) throws Exception {
        if (repo.isEmpty()) {
            throw new Exception(Message.EMPTY_ERROR);
        }

        Worker worker = repo.getWorkerById(dto.getId());
        if (worker == null) {
            throw new Exception(Message.NOT_FOUND_ID_ERROR);
        }

        double salaryUpdate;
        if (dto.getStatus().equalsIgnoreCase("UP")) {
            salaryUpdate = worker.getCurrentSalary() + dto.getAmount();
        } else {
            salaryUpdate = Math.max(0, worker.getCurrentSalary() - dto.getAmount());
        }

        worker.setCurrentSalary(salaryUpdate);
        SalaryHistory history = new SalaryHistory(salaryUpdate, dto.getStatus(), new Date());
        return worker.getHistory().add(history);
    }

    public List<ResponseDTO> getSalaryHistory() throws Exception {
        List<Worker> list = repo.getAll();
        if (list.isEmpty()) {
            throw new Exception(Message.EMPTY_ERROR2);
        }

        Collections.sort(list);
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
        if (result.isEmpty()) {
            throw new Exception(Message.EMPTY_ERROR2);
        }
        return result;
    }
}