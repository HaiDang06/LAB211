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

    // Yêu cầu 4: Gọi thẳng hàm service.addWorker(dto), không dùng if
    public void addWorker() {
        try {
            service.addWorker(dto);
            view.setMessage(Message.SUCCESS_MESSAGE);
            view.printMessage();
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.printError();
        }
    }

    // Yêu cầu 5: Tách riêng hàm upSalary ở Controller
    public void upSalary() {
        try {
            service.upSalary(dto);
            view.setMessage(Message.SUCCESS_MESSAGE);
            view.printMessage();
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }

    // Yêu cầu 5: Tách riêng hàm downSalary ở Controller
    public void downSalary() {
        try {
            service.downSalary(dto);
            view.setMessage(Message.SUCCESS_MESSAGE);
            view.printMessage();
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }

    // Lấy lịch sử đổi lương từ Service và hiển thị bảng qua View
    public void displaySalaryInformation() {
        try {
            List<ResponseDTO> responseList = service.getInfomationSalary();
            view.setResponseList(responseList);
            view.printSalaryInformation();
        } catch (Exception ex) {
            view.setError(ex.getMessage());
            view.printError();
        }
    }
}