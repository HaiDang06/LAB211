/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import constant.Message;
import dto.ResponseDTO;
import dto.WorkerDTO;
import java.util.List;
import service.WorkerService;
import view.WorkerView;

/**
 *
 * @author win
 */
public class Controller {

    private WorkerService service;
    private WorkerDTO dto;
    private WorkerView view;

    public Controller() {
        this.service = new WorkerService();
        this.dto = new WorkerDTO();
        this.view = new WorkerView();
    }

    public WorkerView getView() {
        return view;
    }

    public void setDto(WorkerDTO dto) {
        this.dto = dto;
    }

    public void addWorker() {
        try {
            if (service.addWorker(dto)) {
                view.setMess(Message.SUCCESS_MESSAGE);
                view.printMess();
            }
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.printError();
        }
    }

    public void updateSalary() {
        try {
            if (service.updateSalary(dto)) {
                view.setMess(Message.SUCCESS_MESSAGE);
                view.printMess();
            }
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }

    public void showSalaryHistory() {
        try {
            List<ResponseDTO> response = service.getSalaryHistory();
            view.setResponseDTO(response);
            view.printWorkers();
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }
}
