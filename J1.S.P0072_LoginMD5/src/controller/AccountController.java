package controller;

import constant.Message;
import dto.AccountDTO;
import dto.ResponseDTO;
import service.AccountService;
import view.AccountView;

public class AccountController {

    private AccountService service;
    private AccountView view;
    private AccountDTO dto;
    private ResponseDTO loggedInUser; // Lưu kết quả trả về từ login bằng ResponseDTO

    public AccountController() {
        this.service = new AccountService();
        this.view = new AccountView();
        this.dto = new AccountDTO();
    }

    public AccountService getService() {
        return service;
    }

    public void setDto(AccountDTO dto) {
        this.dto = dto;
    }

    public ResponseDTO getLoggedInUser() {
        return loggedInUser;
    }

    // Không dùng if(service.addAccount(dto)) và không truyền thẳng chuỗi vào printMessage()
    public void addAccount() {
        try {
            service.addAccount(dto);
            view.setMessage(Message.SUCCESS_ADD_MESSAGE);
            view.printMessage();
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.printError();
        }
    }

    // Login nhận ResponseDTO, đẩy sang View để in lời chào nếu đăng nhập thành công
    public boolean login() {
        try {
            loggedInUser = service.login(dto);
            view.setResponseDTO(loggedInUser);
            view.printWelcome();
            return true;
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.printError();
            return false;
        }
    }

    // Đổi sang gọi hàm void từ Service, bỏ if thừa
    public void changePassword() {
        try {
            if (loggedInUser != null) {
                service.changePassword(loggedInUser.getUsername(), dto);
                view.setMessage(Message.SUCCESS_CHANGE_PASSWORD);
                view.printMessage();
            }
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.printError();
        }
    }
}