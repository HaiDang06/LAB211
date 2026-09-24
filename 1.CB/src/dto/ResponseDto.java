package dto;

/**
 * Lớp ResponseDto dùng để chứa dữ liệu trả về sau khi xử lý (thông báo hoặc lỗi).
 */
public class ResponseDto {
    private String mess;
    private String error;

    // Getters and Setters

    /**
     * Lấy thông báo thành công.
     * @return Chuỗi thông báo.
     */
    public String getMess() {
        return mess;
    }

    /**
     * Thiết lập thông báo thành công.
     * @param mess Chuỗi thông báo cần thiết lập.
     */
    public void setMess(String mess) {
        this.mess = mess;
    }

    /**
     * Lấy thông báo lỗi.
     * @return Chuỗi lỗi.
     */
    public String getError() {
        return error;
    }

    /**
     * Thiết lập thông báo lỗi.
     * @param error Chuỗi lỗi cần thiết lập.
     */
    public void setError(String error) {
        this.error = error;
    }


}
