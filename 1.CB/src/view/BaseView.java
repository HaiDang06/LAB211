package view;

import dto.ResponseDto;

/**
 * Lớp View chịu trách nhiệm hiển thị kết quả cho người dùng.
 */
public class BaseView {
    private ResponseDto responseDto;

    /**
     * Khởi tạo đối tượng BaseView với một ResponseDto mặc định.
     */
    public BaseView() {
        this.responseDto = new ResponseDto();
    }

    /**
     * Truyền ResponseDto vào View để chuẩn bị hiển thị.
     * @param responseDto Đối tượng chứa thông báo/kết quả trả về.
     */
    public void setResponseDto(ResponseDto responseDto) {
        this.responseDto = responseDto;
    }

    /**
     * Hiển thị thông báo lỗi.
     */
    public void displayErrorMessages() {
        if (responseDto != null) {
            System.out.println(responseDto.getError());
        }
    }

    /**
     * Hiển thị thông báo thành công hoặc kết quả xử lý.
     */
    public void displayMessages() {
        if (responseDto != null) {
            System.out.println(responseDto.getMess());
        }
    }

}
