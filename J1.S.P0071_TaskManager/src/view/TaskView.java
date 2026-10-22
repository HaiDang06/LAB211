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
 * Tầng giao diện (View) trong mô hình MVC cho chức năng quản lý Task.
 * Chịu trách nhiệm nhận dữ liệu từ Controller và hiển thị kết quả ra màn hình Console:
 * in bảng danh sách Task với các cột có độ rộng chuẩn, in các thông báo lỗi và thông báo thành công.
 *
 * @author Tuan Tran
 */
public class TaskView {

    /** Danh sách các đối tượng ResponseDTO dùng để hiển thị dữ liệu bảng */
    private List<ResponseDTO> responseDTO;

    /**
     * Khởi tạo đối tượng TaskView với danh sách responseDTO rỗng ban đầu.
     */
    public TaskView() {
        responseDTO = new ArrayList<>();
    }

    /**
     * Nhận danh sách dữ liệu ResponseDTO từ Controller để chuẩn bị hiển thị.
     *
     * @param responseDTO danh sách dữ liệu kết quả cần hiển thị
     */
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    /**
     * In một thông điệp (thông báo lỗi hoặc thông báo thành công) ra màn hình Console.
     *
     * @param message chuỗi thông điệp cần in
     */
    public void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * Hiển thị toàn bộ danh sách công việc ra màn hình Console theo định dạng bảng.
     * Bao gồm dòng tiêu đề (Header) và các dòng dữ liệu chi tiết của từng task (Body).
     */
    public void printTask() {
        // In dòng tiêu đề (Header) của bảng với các cột có độ rộng tương ứng
        System.out.println(String.format("%-5s%-15s%-15s%-15s%-15s%-15s%-15s",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer"));

        // Duyệt qua từng đối tượng ResponseDTO trong danh sách để in dòng dữ liệu
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }
}