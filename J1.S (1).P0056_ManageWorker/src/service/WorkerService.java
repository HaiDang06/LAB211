package service;

import constant.Message;
import dto.ResponseDTO;
import dto.WorkerDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.SalaryHistory;
import model.Worker;
import repository.WorkerRepository;

public class WorkerService {

    private WorkerRepository repo;

    public WorkerService() {
        this.repo = new WorkerRepository();
    }

    public boolean addWorker(WorkerDTO dto) throws Exception {
        return repo.addWorker(dto);
    }

    public boolean upSalary(WorkerDTO dto) throws Exception {
        if (repo.isEmpty()) {
            throw new Exception(Message.EMPTY_ERROR);
        }
        return repo.upSalary(dto);
    }

    public boolean downSalary(WorkerDTO dto) throws Exception {
        if (repo.isEmpty()) {
            throw new Exception(Message.EMPTY_ERROR);
        }
        return repo.downSalary(dto);
    }

    // Hàm này không phải là chuẩn CRUD của Worker (nó tổng hợp data), nên nằm ở Service là chuẩn nhất
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