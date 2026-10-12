package controller;

import constant.Message;
import dto.ResponseDTO;
import dto.WorkerDTO;
import java.util.List;
import service.WorkerService;
import view.WorkerView;

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
            boolean isSuccess = false;
            
            // Điều hướng gọi hàm theo status ở Controller
            if (dto.getStatus().equalsIgnoreCase("UP")) {
                isSuccess = service.upSalary(dto);
            } else if (dto.getStatus().equalsIgnoreCase("DOWN")) {
                isSuccess = service.downSalary(dto);
            }

            if (isSuccess) {
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