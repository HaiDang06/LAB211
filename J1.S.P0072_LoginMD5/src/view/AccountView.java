package view;

import dto.ResponseDTO;

public class AccountView {

    private String message;
    private String error;
    private ResponseDTO responseDTO;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setResponseDTO(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }

    // In thông báo thành công (không truyền tham số trực tiếp)
    public void printMessage() {
        System.out.println(this.message);
    }

    // In thông báo lỗi (không truyền tham số trực tiếp)
    public void printError() {
        System.out.println(this.error);
    }

    // In lời chào sau khi đăng nhập thành công dựa trên ResponseDTO
    public void printWelcome() {
        System.out.println("------------ Welcome -----------");
        System.out.print("Hi " + responseDTO.getUsername() + ", do you want change password now? Y/N: ");
    }
}