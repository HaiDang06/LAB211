package dto;

/**
 * Lớp DTO (Data Transfer Object) dùng cho đầu ra (Response).
 * Được sử dụng để đóng gói kết quả trả về từ Controller xuống View (gồm thông báo thành công hoặc lỗi).
 */
public class ResponseDto {
    // Biến lưu trữ thông điệp (chẳng hạn như kết quả tính toán thành công)
    private String mess;
    
    // Biến lưu trữ thông báo lỗi (nếu có lỗi xảy ra trong quá trình thực thi)
    private String error;

    // --- Getters and Setters ---

    /**
     * Lấy thông báo thành công (hoặc kết quả trả về).
     * @return Chuỗi thông báo.
     */
    public String getMess() {
        return mess;
    }

    /**
     * Thiết lập thông báo thành công sau khi xử lý xong thuật toán.
     * @param mess Chuỗi thông báo cần thiết lập (Ví dụ: "Number after convert: 1010").
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Lấy thông báo lỗi (exception message).
     * @return Chuỗi lỗi.
     */
    public String getError() {
        return error;
    }

    /**
     * Thiết lập thông báo lỗi nếu xảy ra sự cố trong quá trình validation hoặc tính toán.
     * @param error Chuỗi lỗi cần thiết lập.
     */
    public void setError(String error) {
        this.error = error;
    }
}
