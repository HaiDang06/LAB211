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
public class TaskView {

    // Khai bao danh sach chua du lieu response dto de hien thi
    private List<ResponseDTO> responseDTO;

    // Khoi tao task view voi danh sach response dto rong
    public TaskView() {
        responseDTO = new ArrayList<>();
    }

    // Phuong thuc de controller day du lieu vao view
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    // Phuong thuc dung de in cac thong bao loi hoac thanh cong ra man hinh
    public void printMessage(String message) {
        System.out.println(message);
    }

    // In danh sach task ra man hinh theo dinh dang bang
    public void printTask() {
        /* Cai dat Header cho bang */
        System.out.println(String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer"));

        /* Duyet qua danh sach ResponseDTO de hien thi noi dung Body */
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }
}