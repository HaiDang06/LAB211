package main;

import constant.Constants;
import constant.Message;
import controller.Controller;
import dto.TaskDTO;
import constant.TaskType;
import java.util.Scanner;
import utils.Validation;

/**
 * Lớp khởi chạy chính (Entry Point) của chương trình Quản lý Task (J1.S.P0071).
 * Quản lý vòng lặp ứng dụng, hiển thị giao diện menu chức năng cho người dùng,
 * tiếp nhận dữ liệu đầu vào từ bàn phím, xác thực và điều hướng xử lý đến Controller.
 *
 * @author Tuan Tran
 */
public class Main {

    /**
     * Phương thức main - Điểm bắt đầu thực thi chương trình.
     * Khởi tạo Controller, Scanner và duy trì vòng lặp hiển thị menu cho đến khi người dùng chọn thoát (Quit).
     *
     * @param args tham số dòng lệnh truyền vào (không sử dụng)
     */
    public static void main(String[] args) {
        // Khởi tạo đối tượng Controller điều khiển luồng nghiệp vụ
        Controller control = new Controller();
        // Khởi tạo đối tượng Scanner để đọc dữ liệu nhập từ bàn phím
        Scanner sc = new Scanner(System.in);

        // Vòng lặp duy trì chương trình chạy liên tục cho đến khi người dùng chọn thoát
        while (true) {
            // Hiển thị tiêu đề và các mục chức năng của menu
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            try {
                // Nhập lựa chọn chức năng từ 1 đến 4
                System.out.print(Message.INPUT_CHOICE);
                int choice = Validation.getInt(sc.nextLine(), 1, 4);

                switch (choice) {
                    case 1:
                        // --- CHỨC NĂNG 1: THÊM MỚI TASK (ADD TASK) ---
                        TaskDTO addDto = new TaskDTO();
                        control.setDto(addDto);

                        // 1. Nhập Requirement Name (kiểm tra theo REGEX chữ và số)
                        System.out.print(Message.INPUT_REQUIREMENT_NAME);
                        addDto.setRequirementName(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        // 2. Nhập lựa chọn Task Type (1: Code, 2: Test, 3: Design, 4: Review)
                        System.out.print(Message.INPUT_TASK_TYPE_CHOICE);
                        int typeChoice = Validation.getInt(sc.nextLine(), 1, 4);
                        addDto.setTaskType(TaskType.values()[typeChoice - 1]);

                        // 3. Nhập ngày thực hiện (theo định dạng dd-MM-yyyy)
                        System.out.print(Message.INPUT_DATE);
                        addDto.setDate(Validation.getDate(sc.nextLine(), Constants.DATE_FORMAT_PATTERN));

                        // 4. Nhập thời gian bắt đầu (từ 8.0 đến 17.0, bước nhảy 0.5)
                        System.out.print(Message.INPUT_PLAN_FROM);
                        double planFrom = Validation.getDouble(sc.nextLine(), 8.0, 17.0);
                        addDto.setPlanFrom(planFrom);

                        // 5. Nhập thời gian kết thúc (phải lớn hơn planFrom ít nhất 0.5 và tối đa 17.5)
                        System.out.print(Message.INPUT_PLAN_TO);
                        double planTo = Validation.getDouble(sc.nextLine(), planFrom + 0.5, 17.5);
                        addDto.setPlanTo(planTo);

                        // 6. Nhập tên người thực hiện (Assignee)
                        System.out.print(Message.INPUT_ASSIGNEE);
                        addDto.setAssign(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        // 7. Nhập tên người nghiệm thu / kiểm tra (Reviewer)
                        System.out.print(Message.INPUT_REVIEWER);
                        addDto.setReviewer(Validation.getString(sc.nextLine(), Constants.REGEX_NAME));

                        // Gọi Controller để thực hiện thêm Task vào hệ thống
                        control.addTask();
                        break;

                    case 2:
                        // --- CHỨC NĂNG 2: XÓA TASK (DELETE TASK) ---
                        TaskDTO deleteDto = new TaskDTO();
                        control.setDto(deleteDto);

                        // Nhập ID của Task cần xóa (số nguyên >= 1)
                        System.out.print(Message.INPUT_TASK_ID);
                        deleteDto.setId(Validation.getInt(sc.nextLine(), 1, Integer.MAX_VALUE));

                        // Gọi Controller để thực hiện xóa Task
                        control.deleteTask();
                        break;

                    case 3:
                        // --- CHỨC NĂNG 3: HIỂN THỊ DANH SÁCH TASK (DISPLAY TASK) ---
                        control.showTasks();
                        break;

                    case 4:
                        // --- CHỨC NĂNG 4: THOÁT CHƯƠNG TRÌNH (QUIT) ---
                        System.exit(0);
                        return;
                }
            } catch (Exception e) {
                // Bắt các ngoại lệ xác thực dữ liệu và in thông báo lỗi ra màn hình mà không làm dừng chương trình
                System.out.println(e.getMessage());
            }
        }
    }
}
