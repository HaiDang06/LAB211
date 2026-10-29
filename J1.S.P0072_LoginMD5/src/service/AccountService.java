package service;

import constant.Message;
import dto.AccountDTO;
import dto.ResponseDTO;
import model.Account;
import repository.AccountRepository;

public class AccountService {

    private AccountRepository accountRepo;

    public AccountService() {
        this.accountRepo = new AccountRepository();
    }

    public AccountRepository getAccountRepo() {
        return accountRepo;
    }

    // Đổi sang void: nếu trùng username thì ném Exception, không trùng thì thêm thẳng
    public void addAccount(AccountDTO dto) throws Exception {
        Account existAccount = accountRepo.findByUsername(dto.getUsername());
        if (existAccount != null) {
            throw new Exception(Message.ERROR_USERNAME_EXIST_DB);
        }

        Account newAcc = new Account(dto.getUsername(), dto.getPassword(), dto.getName(),
                dto.getPhone(), dto.getEmail(), dto.getAddress(), dto.getDob());

        accountRepo.addAccount(newAcc);
    }

    // Trả về ResponseDTO thay vì AccountDTO
    public ResponseDTO login(AccountDTO dto) throws Exception {
        Account existAccount = accountRepo.findByUsername(dto.getUsername());
        if (existAccount == null) {
            throw new Exception(Message.ERROR_ACCOUNT_NOT_FOUND);
        }

        if (!existAccount.getPassword().equals(dto.getPassword())) {
            throw new Exception(Message.ERROR_INCORRECT_PASSWORD);
        }

        return new ResponseDTO(existAccount.getUsername(), existAccount.getName());
    }

    // Đổi sang void: nếu sai mật khẩu cũ thì ném Exception, đúng thì cập nhật mật khẩu mới
    public void changePassword(String username, AccountDTO dto) throws Exception {
        Account acc = accountRepo.findByUsername(username);
        if (acc == null) {
            throw new Exception(Message.ERROR_ACCOUNT_NOT_FOUND);
        }

        if (!acc.getPassword().equals(dto.getOldPassword())) {
            throw new Exception(Message.ERROR_OLD_PASSWORD_INCORRECT);
        }

        acc.setPassword(dto.getNewPassword());
    }
}