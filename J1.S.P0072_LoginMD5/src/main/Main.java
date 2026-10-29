package main;

import constant.Constants;
import constant.Message;
import controller.AccountController;
import dto.AccountDTO;
import java.util.Scanner;
import utils.MD5Util;
import utils.Validation;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountController manager = new AccountController();

        while (true) {
            System.out.print(Message.MENU_HEADER + Message.MENU_BODY);
            System.out.print(Message.INPUT_CHOICE);

            try {
                int choice = Validation.getInt(sc.nextLine(), 1, 3);
                switch (choice) {
                    // Add User
                    case 1:
                        AccountDTO addDto = new AccountDTO();
                        manager.setDto(addDto);
                        System.out.println("---------- Add User --------");

                        String username;
                        while (true) {
                            System.out.print(Message.INPUT_USERNAME);
                            username = Validation.getString(sc.nextLine(), Constants.REGEX_USERNAME);
                            if (manager.getService().getAccountRepo().findByUsername(username) != null) {
                                System.out.println(Message.ERROR_ACCOUNT_EXIST);
                            } else {
                                break;
                            }
                        }
                        addDto.setUsername(username);

                        System.out.print(Message.INPUT_PASSWORD);
                        // Lấy mật khẩu người dùng nhập và mã hóa MD5 ngay lập tức
                        String rawPass = Validation.getString(sc.nextLine(), Constants.REGEX_PASSWORD);
                        addDto.setPassword(MD5Util.encrypt(rawPass));

                        System.out.print(Message.INPUT_NAME);
                        addDto.setName(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        System.out.print(Message.INPUT_PHONE);
                        addDto.setPhone(Validation.getString(sc.nextLine(), Constants.REGEX_PHONE));

                        System.out.print(Message.INPUT_EMAIL);
                        addDto.setEmail(Validation.getString(sc.nextLine(), Constants.REGEX_EMAIL));

                        System.out.print(Message.INPUT_ADDRESS);
                        addDto.setAddress(Validation.getString(sc.nextLine(), Constants.REGEX_ADDRESS));

                        System.out.print(Message.INPUT_DOB);
                        addDto.setDob(Validation.getDate(sc.nextLine(), Constants.DATE_FORMAT));

                        manager.addAccount();
                        break;

                   // Login
                    case 2:
                        AccountDTO loginDto = new AccountDTO();
                        manager.setDto(loginDto);
                        System.out.println("------------- Login ----------------");

                        System.out.print(Message.INPUT_USERNAME);
                        loginDto.setUsername(Validation.getString(sc.nextLine(), Constants.REGEX_USERNAME));

                        System.out.print(Message.INPUT_PASSWORD);
                        String rawLoginPass = Validation.getString(sc.nextLine(), Constants.REGEX_PASSWORD);
                        loginDto.setPassword(MD5Util.encrypt(rawLoginPass));

                        // Nếu login() trả về true, View bên trong Controller đã in lời chào kèm câu hỏi Y/N
                        if (manager.login()) {
                            String changeChoice = Validation.getString(sc.nextLine(), Constants.REGEX_YN);

                            if (changeChoice.equalsIgnoreCase("Y")) {
                                while (true) {
                                    System.out.print("Old password: ");
                                    String rawOld = Validation.getString(sc.nextLine(), Constants.REGEX_PASSWORD);
                                    loginDto.setOldPassword(MD5Util.encrypt(rawOld));

                                    System.out.print("New password: ");
                                    String rawNew = Validation.getString(sc.nextLine(), Constants.REGEX_PASSWORD);
                                    loginDto.setNewPassword(MD5Util.encrypt(rawNew));

                                    System.out.print("Renew password: ");
                                    String rePass = Validation.getString(sc.nextLine(), Constants.REGEX_PASSWORD);

                                    if (!rawNew.equals(rePass)) {
                                        System.out.println(Message.ERROR_PASSWORD_MISMATCH);
                                        continue;
                                    }

                                    manager.changePassword();
                                    break;
                                }
                            }
                        }
                        break;

                    // Exit
                    case 3:
                        System.out.println("Exiting program...");
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}