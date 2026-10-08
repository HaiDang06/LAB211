package view;

import dto.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp giao diện (View) đảm nhiệm việc hiển thị dữ liệu và thông báo ra màn hình.
 */
public class WorkerView {
    private List<ResponseDTO> responseDTO;
    private String mess;
    private String error;

    public WorkerView() {
        responseDTO = new ArrayList<>();
    }

    /**
     * Thiết lập thông báo thành công.
     * @param mess Chuỗi thông báo
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Thiết lập thông báo lỗi.
     * @param error Chuỗi lỗi
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Phương thức để Controller đẩy dữ liệu lịch sử lương vào View.
     * @param responseDTO Danh sách ResponseDTO chứa lịch sử lương
     */
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    /**
     * In danh sách lịch sử lương dưới dạng bảng.
     */
    public void printWorkers() {
        /* Cài đặt Header cho bảng */
        System.out.println(String.format("%7s%10s%10s%10s%10s%15s",
                "Code", "Name", "Age", "Salary", "Status", "Date"));

        /* Duyệt qua danh sách ResponseDTO để hiển thị nội dung Body */
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }

    /**
     * In thông báo thành công.
     */
    public void printMess() {
        System.out.println(mess);
    }

    /**
     * In thông báo lỗi.
     */
    public void printError() {
        System.out.println(error);
    }
}
