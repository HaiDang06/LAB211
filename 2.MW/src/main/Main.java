package main;

import constant.Constants;
import constant.Messages;
import controller.WorkerController;
import dto.WorkerDTO;
import utils.Validation;

import java.util.Scanner;

/**
 * Lớp Main là điểm khởi đầu (Entry Point) của chương trình Quản lý Công nhân (Worker Management).
 * 
 * Vai trò trong hệ thống:
 * - Điều khiển luồng tương tác với người dùng thông qua giao diện dòng lệnh (Console Interface).
 * - Hiển thị Menu chức năng và duy trì vòng lặp hoạt động của ứng dụng.
 * - Nhận dữ liệu thô từ bàn phím, kết hợp với lớp {@link Validation} để kiểm tra tính hợp lệ.
 * - Đóng gói dữ liệu hợp lệ vào đối tượng {@link WorkerDTO} rồi chuyển giao cho {@link WorkerController} xử lý.
 */
public class Main {

    /**
     * Phương thức thực thi chính (main method) của ứng dụng.
     * 
     * Quy trình hoạt động:
     * 1. Khởi tạo đối tượng {@link WorkerController} để quản lý các chức năng.
     * 2. Khởi tạo đối tượng {@link Scanner} để đọc dữ liệu từ bàn phím (System.in).
     * 3. Chạy vòng lặp vô tận (while true) hiển thị menu và nhận lựa chọn từ 1 đến 5:
     *    - Chức năng 1: Thêm mới công nhân (Add Worker).
     *    - Chức năng 2: Tăng lương công nhân (Up salary).
     *    - Chức năng 3: Giảm lương công nhân (Down salary).
     *    - Chức năng 4: Hiển thị lịch sử thay đổi lương (Display Information salary).
     *    - Chức năng 5: Thoát chương trình (Exit).
     * 4. Bọc toàn bộ quá trình nhập liệu trong khối try-catch để ngăn chặn chương trình bị dừng đột ngột khi xảy ra lỗi nhập liệu.
     * 
     * @param args Tham số dòng lệnh truyền vào khi chạy chương trình (nếu có).
     */
    public static void main(String[] args) {
        // Khởi tạo bộ điều khiển trung tâm
        WorkerController control = new WorkerController();
        // Khởi tạo đối tượng Scanner đọc dữ liệu từ luồng chuẩn System.in
        Scanner sc = new Scanner(System.in);

        // Vòng lặp duy trì menu điều hướng của chương trình
        while (true) {
            // Hiển thị phần đầu và các mục lựa chọn của Menu
            System.out.println(Messages.MENU_HEADER.concat(Messages.MENU_BODY));
            try {
                // Nhắc người dùng nhập lựa chọn và kiểm tra lựa chọn phải nằm trong khoảng từ 1 đến 5
                System.out.print(Messages.CHOICE_PROMPT);
                int choice = Validation.getInt(sc.nextLine(), 1, 5);

                // Điều hướng luồng xử lý theo lựa chọn của người dùng
                switch (choice) {

                    // ==========================================
                    // CHỨC NĂNG 1: THÊM MỚI CÔNG NHÂN (ADD WORKER)
                    // ==========================================
                    case 1:
                        // Tạo mới một đối tượng WorkerDTO cho mỗi lần thêm để đảm bảo không bị lưu vết dữ liệu cũ
                        WorkerDTO addDto = new WorkerDTO();
                        control.setDto(addDto);

                        // 1. Nhập và kiểm tra mã công nhân (ID) theo định dạng ID_REGEX (ví dụ: W01)
                        System.out.print(Messages.ID_PROMPT);
                        addDto.setId(Validation.getString(sc.nextLine(), Constants.ID_REGEX));

                        // 2. Nhập và kiểm tra họ tên theo NAME_REGEX (chỉ chữ cái và khoảng trắng)
                        System.out.print(Messages.NAME_PROMPT);
                        addDto.setName(Validation.getString(sc.nextLine(), Constants.NAME_REGEX));

                        // 3. Nhập và kiểm tra độ tuổi (giới hạn hợp lệ từ 18 đến 50 tuổi)
                        System.out.print(Messages.AGE_PROMPT);
                        addDto.setAge(Validation.getInt(sc.nextLine(), 18, 50));

                        // 4. Nhập và kiểm tra mức lương ban đầu (số thực > 0)
                        System.out.print(Messages.SALARY_PROMPT);
                        addDto.setSalary(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        // 5. Nhập và kiểm tra nơi làm việc theo LOCATION_REGEX (chữ, số và khoảng trắng)
                        System.out.print(Messages.LOCATION_PROMPT);
                        addDto.setWorkLocation(Validation.getString(sc.nextLine(), Constants.LOCATION_REGEX));

                        // Thực thi yêu cầu thêm công nhân qua Controller
                        control.addWorker();
                        break;

                    // ==========================================
                    // CHỨC NĂNG 2: TĂNG LƯƠNG CÔNG NHÂN (UP SALARY)
                    // ==========================================
                    case 2:
                        WorkerDTO upDto = new WorkerDTO();
                        control.setDto(upDto);

                        // 1. Nhập và kiểm tra mã công nhân cần tăng lương
                        System.out.print(Messages.ID_PROMPT);
                        upDto.setId(Validation.getString(sc.nextLine(), Constants.ID_REGEX));

                        // 2. Nhập và kiểm tra số tiền cần tăng (phải lớn hơn 0)
                        System.out.print(Messages.AMOUNT_PROMPT);
                        upDto.setAmount(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        // 3. Gán trạng thái "UP" để Controller nhận biết hành động tăng lương
                        upDto.setStatus("UP");

                        // Thực thi nghiệp vụ cập nhật lương qua Controller
                        control.updateSalary();
                        break;

                    // ==========================================
                    // CHỨC NĂNG 3: GIẢM LƯƠNG CÔNG NHÂN (DOWN SALARY)
                    // ==========================================
                    case 3:
                        WorkerDTO downDto = new WorkerDTO();
                        control.setDto(downDto);

                        // 1. Nhập và kiểm tra mã công nhân cần giảm lương
                        System.out.print(Messages.ID_PROMPT);
                        downDto.setId(Validation.getString(sc.nextLine(), Constants.ID_REGEX));

                        // 2. Nhập và kiểm tra số tiền cần giảm (phải lớn hơn 0)
                        System.out.print(Messages.AMOUNT_PROMPT);
                        downDto.setAmount(Validation.getDouble(sc.nextLine(), 1, 999999999));

                        // 3. Gán trạng thái "DOWN" để Controller nhận biết hành động giảm lương
                        downDto.setStatus("DOWN");

                        // Thực thi nghiệp vụ cập nhật lương qua Controller
                        control.updateSalary();
                        break;

                    // ==========================================
                    // CHỨC NĂNG 4: HIỂN THỊ LỊCH SỬ THAY ĐỔI LƯƠNG
                    // ==========================================
                    case 4:
                        // Yêu cầu Controller tổng hợp và hiển thị bảng lịch sử biến động lương
                        control.showSalaryHistory();
                        break;

                    // ==========================================
                    // CHỨC NĂNG 5: THOÁT KHỎI CHƯƠNG TRÌNH (EXIT)
                    // ==========================================
                    case 5:
                        // Dừng và thoát toàn bộ chương trình
                        System.exit(0);
                        return;
                }
            } catch (Exception e) {
                // Bắt và hiển thị toàn bộ lỗi phát sinh trong quá trình nhập liệu hoặc xử lý
                System.out.println(e.getMessage());
            }
        }
    }
}
