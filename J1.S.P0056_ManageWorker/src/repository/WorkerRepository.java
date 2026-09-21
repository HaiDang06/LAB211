/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import constant.Message;
import java.util.ArrayList;
import java.util.List;
import model.Worker;

/**
 *
 * @author Tuan Tran
 */
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

    public boolean add(Worker worker) throws Exception {
        // Logic kiểm tra trùng ID
        if (getWorkerById(worker.getId()) != null) {
            throw new Exception(String.format(Message.DUPLICATE_ERROR, worker.getId()));
        }
        return workerList.add(worker);
    }

    public List<Worker> getAll() {
        return new ArrayList<>(workerList);
    }

    public boolean isEmpty() {
        return workerList.isEmpty();
    }
}