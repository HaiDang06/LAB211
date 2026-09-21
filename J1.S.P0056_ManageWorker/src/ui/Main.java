/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import constant.Message;
import controller.Controller;
import dto.WorkerDTO;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author win
 */
public class Main {

    public static void main(String[] args) {
        Controller control = new Controller();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            try {
                System.out.print(Message.CHOICE_PROMPT);
                int choice = Validation.getInt(sc.nextLine(), 1, 5);
                switch (choice) {

                    // Thêm Worker
                    case 1:
                        // Tạo DTO mới cho mỗi luồng xử lý để tránh dính dữ liệu cũ
                        WorkerDTO addDto = new WorkerDTO();
                        control.setDto(addDto);

                        System.out.print(Message.ID_PROMPT);
                        addDto.setId(Validation.getString(sc.nextLine(), Message.ID_REGEX));

                        System.out.print(Message.NAME_PROMPT);
                        addDto.setName(Validation.getString(sc.nextLine(), Message.NAME_REGEX));

                        System.out.print(Message.AGE_PROMPT);
                        addDto.setAge(Validation.getInt(sc.nextLine(), 18, 50));

                        System.out.print(Message.SALARY_PROMPT);
                        addDto.setSalary(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        System.out.print(Message.LOCATION_PROMPT);
                        addDto.setWorkLocation(Validation.getString(sc.nextLine(), Message.LOCATION_REGEX));

                        control.addWorker();
                        break;

                    // Tăng lương
                    case 2:
                        WorkerDTO upDto = new WorkerDTO();
                        control.setDto(upDto);

                        System.out.print(Message.ID_PROMPT);
                        upDto.setId(Validation.getString(sc.nextLine(), Message.ID_REGEX));

                        System.out.print(Message.AMOUNT_PROMPT);
                        upDto.setAmount(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        upDto.setStatus("UP");
                        control.updateSalary();
                        break;

                    // Giảm lương
                    case 3:
                        WorkerDTO downDto = new WorkerDTO();
                        control.setDto(downDto);

                        System.out.print(Message.ID_PROMPT);
                        downDto.setId(Validation.getString(sc.nextLine(), Message.ID_REGEX));

                        System.out.print(Message.AMOUNT_PROMPT);
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
