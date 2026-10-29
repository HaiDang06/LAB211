package repository;

import java.util.ArrayList;
import java.util.List;
import model.Account;

public class AccountRepository {

    private List<Account> accountList;

    public AccountRepository() {
        this.accountList = new ArrayList<>();
    }

    public Account findByUsername(String username) {
        for (Account a : accountList) {
            if (a.getUsername().equalsIgnoreCase(username)) {
                return a;
            }
        }
        return null;
    }

    // Đổi từ boolean sang void
    public void addAccount(Account acc) {
        accountList.add(acc);
    }
}