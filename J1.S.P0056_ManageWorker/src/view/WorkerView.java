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

    private List<ResponseDTO> responseList;
    private String message;
    private String error;

    // Khởi tạo View với danh sách hiển thị rỗng
    public WorkerView() {
        responseList = new ArrayList<>();
    }

    // Controller đẩy thông báo thành công/thất bại vào View
    public void setMessage(String message) {
        this.message = message;
    }

    // Controller đẩy thông báo lỗi vào View
    public void setError(String error) {
        this.error = error;
    }

    // Phương thức để Controller đẩy dữ liệu vào View
    public void setResponseList(List<ResponseDTO> responseList) {
        this.responseList = responseList;
    }

    // In bảng lịch sử đổi lương gồm dòng tiêu đề và các dòng dữ liệu
    public void printSalaryInformation() {
        /* Cài đặt Header cho bảng */
        System.out.println(String.format("%7s%10s%10s%10s%10s%15s",
                "Code", "Name", "Age", "Salary", "Status", "Date"));

        /* Duyệt qua danh sách ResponseDTO để hiển thị nội dung Body */
        for (ResponseDTO res : responseList) {
            System.out.println(res.toString());
        }
    }

    // In thông báo kết quả
    public void printMessage() {
        System.out.println(message);
    }

    // In thông báo lỗi
    public void printError() {
        System.out.println(error);
    }

}
