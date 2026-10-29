package main;

import constant.Constants;
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

    // Chạy chương trình: hiển thị menu lặp lại và điều hướng theo lựa chọn của người dùng
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        // Vòng lặp menu, chỉ dừng khi người dùng chọn Exit
        while (true) {
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            try {
                System.out.print(Message.CHOICE_PROMPT);
                int choice = Validation.getInt(scanner.nextLine(), 1, 5);
                // Mỗi case là một luồng xử lý theo lựa chọn menu
                switch (choice) {

                    // Thêm Worker
                    case 1:
                        // Tạo DTO mới cho mỗi luồng xử lý để tránh dính dữ liệu cũ
                        WorkerDTO addDto = new WorkerDTO();
                        controller.setDto(addDto);

                        // Nhập mã worker (định dạng W + số)
                        System.out.print(Message.ID_PROMPT);
                        addDto.setId(Validation.getString(scanner.nextLine(), Constants.ID_REGEX));

                        // Nhập tên worker (chỉ chữ cái và khoảng trắng)
                        System.out.print(Message.NAME_PROMPT);
                        addDto.setName(Validation.getString(scanner.nextLine(), Constants.NAME_REGEX));

                        // Nhập tuổi trong khoảng 18 -> 50
                        System.out.print(Message.AGE_PROMPT);
                        addDto.setAge(Validation.getInt(scanner.nextLine(), 18, 50));

                        // Nhập lương ban đầu
                        System.out.print(Message.SALARY_PROMPT);
                        addDto.setSalary(Validation.getDouble(scanner.nextLine(), 1, 999999999));

                        // Nhập nơi làm việc (chữ, số, khoảng trắng)
                        System.out.print(Message.LOCATION_PROMPT);
                        addDto.setWorkLocation(Validation.getString(scanner.nextLine(), Constants.LOCATION_REGEX));

                        // Gọi Controller thêm worker
                        controller.addWorker();
                        break;

                    // Tăng lương
                    case 2:
                        WorkerDTO upDto = new WorkerDTO();
                        controller.setDto(upDto);

                        // Nhập mã worker cần tăng lương
                        System.out.print(Message.ID_PROMPT);
                        upDto.setId(Validation.getString(scanner.nextLine(), Constants.ID_REGEX));

                        // Nhập số tiền tăng
                        System.out.print(Message.AMOUNT_PROMPT);
                        upDto.setAmount(Validation.getDouble(scanner.nextLine(), 1, 999999999));

                        // Gọi trực tiếp hàm tăng lương ở Controller
                        controller.upSalary();
                        break;

                    // Giảm lương
                    case 3:
                        WorkerDTO downDto = new WorkerDTO();
                        controller.setDto(downDto);

                        // Nhập mã worker cần giảm lương
                        System.out.print(Message.ID_PROMPT);
                        downDto.setId(Validation.getString(scanner.nextLine(), Constants.ID_REGEX));

                        // Nhập số tiền giảm
                        System.out.print(Message.AMOUNT_PROMPT);
                        downDto.setAmount(Validation.getDouble(scanner.nextLine(), 1, 999999999));

                        // Gọi trực tiếp hàm giảm lương ở Controller
                        controller.downSalary();
                        break;

                    // Hiển thị lịch sử
                    case 4:
                        controller.displaySalaryInformation();
                        break;

                    // Thoát
                    case 5:
                        System.exit(0);
                        return;
                }
            } catch (Exception e) {
                // Dữ liệu nhập không hợp lệ: in lỗi rồi quay lại menu
                System.out.println(e.getMessage());
            }
        }
    }
}