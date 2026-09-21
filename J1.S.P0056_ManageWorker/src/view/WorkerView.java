/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tuan Tran
 */
public class WorkerView {

    private List<ResponseDTO> responseDTO;
    private String mess;
    private String error;

    public WorkerView() {
        responseDTO = new ArrayList<>();
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public void setError(String error) {
        this.error = error;
    }

    // Phương thức để Controller đẩy dữ liệu vào View
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    public void printWorkers() {
        /* Cài đặt Header cho bảng */
        System.out.println(String.format("%7s%10s%10s%10s%10s%15s",
                "Code", "Name", "Age", "Salary", "Status", "Date"));

        /* Duyệt qua danh sách ResponseDTO để hiển thị nội dung Body */
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }

    public void printMess() {
        System.out.println(mess);
    }

    public void printError() {
        System.out.println(error);
    }

}
