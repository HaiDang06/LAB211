package view;

import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp WorkerView thuộc tầng Hiển thị (View) trong mô hình kiến trúc MVC.
 * 
 * Nhiệm vụ và vai trò:
 * - Đảm nhiệm toàn bộ việc trực quan hóa thông tin ra màn hình console cho người dùng.
 * - Nhận dữ liệu đã qua xử lý từ Controller (dưới dạng DTO) và hiển thị theo định dạng trực quan (dạng bảng).
 * - Hiển thị các thông báo thành công hoặc thông báo lỗi tương ứng.
 * - Tuân thủ nguyên tắc phân tách trách nhiệm (Separation of Concerns), không chứa logic nghiệp vụ hay truy xuất dữ liệu.
 */
public class WorkerView {

    /**
     * Danh sách các đối tượng {@link ResponseDTO} chứa dữ liệu lịch sử biến động lương cần in ra bảng.
     */
    private List<ResponseDTO> responseDTO;

    /**
     * Chuỗi lưu trữ thông báo thực hiện thành công.
     */
    private String mess;

    /**
     * Chuỗi lưu trữ thông báo lỗi phát sinh trong quá trình xử lý.
     */
    private String error;

    /**
     * Hàm khởi tạo WorkerView, khởi tạo danh sách rỗng để lưu trữ các ResponseDTO.
     */
    public WorkerView() {
        this.responseDTO = new ArrayList<>();
    }

    /**
     * Thiết lập thông báo thành công cần hiển thị.
     * 
     * @param mess Chuỗi thông báo thành công (ví dụ: "Success!").
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Thiết lập thông báo lỗi cần hiển thị.
     * 
     * @param error Chuỗi thông báo lỗi cần in ra màn hình.
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * Phương thức tiếp nhận danh sách dữ liệu lịch sử lương từ Controller đẩy vào View.
     * 
     * @param responseDTO Danh sách các đối tượng {@link ResponseDTO}.
     */
    public void setResponseDTO(List<ResponseDTO> responseDTO) {
        this.responseDTO = responseDTO;
    }

    /**
     * In danh sách lịch sử biến động lương dưới dạng bảng có cấu trúc rõ ràng:
     * - In dòng tiêu đề (Header): Code (7 ký tự), Name (10 ký tự), Age (10 ký tự), Salary (10 ký tự), Status (10 ký tự), Date (15 ký tự).
     * - Duyệt qua từng dòng trong danh sách {@link ResponseDTO} và in ra thông tin định dạng tương ứng.
     */
    public void printWorkers() {
        /* Cài đặt và in Header cho bảng */
        System.out.println(String.format("%7s%10s%10s%10s%10s%15s",
                "Code", "Name", "Age", "Salary", "Status", "Date"));

        /* Duyệt qua danh sách ResponseDTO để hiển thị nội dung từng dòng dữ liệu (Body) */
        for (ResponseDTO res : responseDTO) {
            System.out.println(res.toString());
        }
    }

    /**
     * In thông báo thực hiện thao tác thành công ra màn hình console.
     */
    public void printMess() {
        System.out.println(mess);
    }

    /**
     * In thông báo lỗi ra màn hình console khi có ngoại lệ xảy ra.
     */
    public void printError() {
        System.out.println(error);
    }
}
