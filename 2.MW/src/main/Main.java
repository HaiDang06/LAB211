/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import constant.Constants;
import constant.Messages;
import controller.WorkerController;
import dto.WorkerDTO;
import utils.Validation;

import java.util.Scanner;

/**
 * Lớp Main, chứa phương thức khởi chạy chương trình.
 * Hiển thị menu chức năng và tiếp nhận các lựa chọn từ người dùng.
 *
 * @author Admin
 */
public class Main {

    /**
     * Phương thức chạy chính của chương trình quản lý công nhân.
     * Vòng lặp hiển thị menu để người dùng thao tác.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WorkerController control = new WorkerController();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(Messages.MENU_HEADER.concat(Messages.MENU_BODY));
            try {
                System.out.print(Messages.CHOICE_PROMPT);
                int choice = Validation.getInt(sc.nextLine(), 1, 5);
                switch (choice) {

                    // Thêm Worker
                    case 1:
                        // Tạo DTO mới cho mỗi luồng xử lý để tránh dính dữ liệu cũ
                        WorkerDTO addDto = new WorkerDTO();
                        control.setDto(addDto);

                        System.out.print(Messages.ID_PROMPT);
                        addDto.setId(Validation.getString(sc.nextLine(), Constants.ID_REGEX));

                        System.out.print(Messages.NAME_PROMPT);
                        addDto.setName(Validation.getString(sc.nextLine(), Constants.NAME_REGEX));

                        System.out.print(Messages.AGE_PROMPT);
                        addDto.setAge(Validation.getInt(sc.nextLine(), 18, 50));

                        System.out.print(Messages.SALARY_PROMPT);
                        addDto.setSalary(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        System.out.print(Messages.LOCATION_PROMPT);
                        addDto.setWorkLocation(Validation.getString(sc.nextLine(), Constants.LOCATION_REGEX));

                        control.addWorker();
                        break;

                    // Tăng lương
                    case 2:
                        WorkerDTO upDto = new WorkerDTO();
                        control.setDto(upDto);

                        System.out.print(Messages.ID_PROMPT);
                        upDto.setId(Validation.getString(sc.nextLine(), Constants.ID_REGEX));

                        System.out.print(Messages.AMOUNT_PROMPT);
                        upDto.setAmount(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        upDto.setStatus("UP");
                        control.updateSalary();
                        break;

                    // Giảm lương
                    case 3:
                        WorkerDTO downDto = new WorkerDTO();
                        control.setDto(downDto);

                        System.out.print(Messages.ID_PROMPT);
                        downDto.setId(Validation.getString(sc.nextLine(), Constants.ID_REGEX));

                        System.out.print(Messages.AMOUNT_PROMPT);
                        downDto.setAmount(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        downDto.setStatus("DOWN");
                        control.updateSalary();
                        break;

                    // Hiển thị lịch sử
                    case 4:
                        control.showSalaryHistory();
                        break;

                    // Thoát
                    case 5:
                        System.exit(0);
                        return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
    

