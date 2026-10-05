package view;

import dto.ResponseDto;

/**
 * Lớp View chịu trách nhiệm hiển thị giao diện và kết quả cho người dùng.
 * Phân tách rõ ràng với tầng xử lý (Controller/Service), chỉ làm nhiệm vụ nhận dữ liệu (từ Controller)
 * và in ra màn hình (Console).
 */
public class BaseView {
    // Đối tượng chứa dữ liệu đầu ra cần hiển thị (chứa cả thành công lẫn lỗi)
    private ResponseDto responseDto;

    /**
     * Khởi tạo đối tượng BaseView với một ResponseDto rỗng ban đầu.
     */
    public BaseView() {
        this.responseDto = new ResponseDto();
    }

    /**
     * Cung cấp dữ liệu (ResponseDto) cho View.
     * Controller sẽ gọi hàm này để cập nhật đối tượng chứa kết quả trước khi ra lệnh in.
     * 
     * @param responseDto Đối tượng chứa thông báo hoặc kết quả trả về.
     */
    public void setResponseDto(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    /**
     * Phương thức in thông báo lỗi.
     * Kiểm tra xem trong ResponseDto có tồn tại lỗi hay không, nếu có thì in ra Console.
     */
    public void displayErrorMessages() {
        if (responseDto != null && responseDto.getError() != null) {
            System.err.println(responseDto.getError());
        }
    }

    /**
     * Phương thức in thông báo thành công.
     * Kiểm tra xem trong ResponseDto có tồn tại thông điệp thành công (kết quả chuyển đổi) hay không,
     * nếu có thì in ra Console.
     */
    public void displayMessages() {
        if (responseDto != null && responseDto.getMess() != null) {
            System.out.println(responseDto.getMess());
        }
    }

}
