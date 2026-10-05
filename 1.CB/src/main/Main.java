/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import constant.Base;
import constant.Constants;
import constant.Message;
import controller.BaseController;
import dto.BaseDto;
import utils.Validation;

import java.util.Scanner;

/**
 * Lớp khởi chạy chương trình chính, đóng vai trò như View chính để giao tiếp với người dùng qua Console.
 * Nó nhận input vòng lặp, sau đó truyền vào BaseController để xử lý.
 *
 * @author Admin
 */
public class Main {

    /**
     * Hàm main thực thi chương trình.
     * Quản lý luồng chính: Nhập số ban đầu -> Chọn cơ số đích liên tục -> Chuyển đổi và in kết quả.
     * @param args Các đối số truyền vào từ dòng lệnh.
     */
    public static void main(String[] args) {
        // Khởi tạo Controller chịu trách nhiệm xử lý chuyển đổi
        BaseController controller = new BaseController();
        Scanner scanner = new Scanner(System.in);

        // Bước 1: Yêu cầu người dùng nhập thông tin về số ban đầu (hệ cơ số gốc và giá trị)
        BaseDto inputData = inputBaseNumber(scanner);
        controller.setDto(inputData); // Truyền dữ liệu ban đầu cho controller
        
        // Bước 2: Vòng lặp cho phép người dùng liên tục chuyển số vừa nhập sang nhiều hệ cơ số khác nhau
        while (true) {
            try {
                // Nhập hệ cơ số đích
                Base targetBase = inputTargetBase(scanner);
                
                // Nếu hàm trả về null, nghĩa là người dùng đã chọn thoát chương trình
                if (targetBase == null) {
                    break;
                }
                
                // Cập nhật hệ cơ số đích vào DTO
                inputData.setTargetBase(targetBase);
                
                // Gọi Controller thực hiện quy trình tính toán và in kết quả ra màn hình
                controller.convertNumber();
            } catch (Exception e) {
                // In ra thông báo lỗi (như nhập sai lựa chọn, ...)
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Hiển thị menu cho phép người dùng nhập hệ cơ số đích để chuyển đổi sang.
     * @param scanner Đối tượng Scanner dùng để đọc dữ liệu.
     * @return Hệ cơ số đích (Enum Base), hoặc trả về null nếu người dùng chọn tùy chọn thoát.
     * @throws Exception Nếu lựa chọn không hợp lệ (không phải số hoặc ngoài phạm vi).
     */
    public static Base inputTargetBase(Scanner scanner) throws Exception {
        System.out.println(Message.CONVERT_MENU);
        // Đọc giá trị người dùng nhập, đảm bảo là số nguyên nằm trong đoạn từ 1 đến 4
        int choice = Validation.getInt(scanner.nextLine(), 1, 4);
        switch (choice) {
            case 1:
                return Base.BIN;
            case 2:
                return Base.DEC;
            case 3:
                return Base.HEX;
            case 4:
                return null; // Trả về null báo hiệu thoát chương trình
            default:
                throw new IllegalArgumentException(Message.ERROR_INVALID_TARGET);
        }

    }

    /**
     * Cho phép người dùng nhập hệ cơ số đầu vào và sau đó là giá trị tương ứng của nó.
     * Lặp vô hạn cho đến khi nhận được dữ liệu hợp lệ (vượt qua kiểm tra Regex).
     * @param scanner Đối tượng Scanner dùng để đọc dữ liệu.
     * @return Đối tượng BaseDto chứa thông tin đã được validate hoàn chỉnh.
     */
    public static BaseDto inputBaseNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.print(Message.INPUT_BASE_MENU);
                // Người dùng phải nhập đúng số từ 1 đến 3 để chọn hệ cơ số
                int baseChoice = Validation.getInt(scanner.nextLine(), 1, 3);
                BaseDto dto = new BaseDto();
                String numberStr;
                
                // Dựa trên lựa chọn hệ đếm nguồn, chọn regex phù hợp để xác thực chuỗi đầu vào
                switch (baseChoice) {
                    case 1:
                        dto.setBase(Base.BIN);
                        System.out.print(Message.ENTER_BIN);
                        // Validation.getString sẽ văng lỗi (Exception) nếu input không đúng cấu trúc Binary
                        numberStr = Validation.getString(scanner.nextLine(), Constants.REGEX_BINARY);
                        break;
                    case 2:
                        dto.setBase(Base.DEC);
                        System.out.print(Message.ENTER_DEC);
                        numberStr = Validation.getString(scanner.nextLine(), Constants.REGEX_DECIMAL);
                        break;
                    case 3:
                        dto.setBase(Base.HEX);
                        System.out.print(Message.ENTER_HEX);
                        numberStr = Validation.getString(scanner.nextLine(), Constants.REGEX_HEXADECIMAL);
                        break;
                    default:
                        continue; // Nếu rơi vào default, bắt đầu lại vòng lặp
                }
                
                // Nếu vượt qua kiểm tra Validation, lưu chuỗi vào DTO
                dto.setPresentation(numberStr);
                return dto; // Trả về DTO hoàn chỉnh và kết thúc hàm
            } catch (Exception e) {
                // Hiển thị lỗi do nhập sai kiểu dữ liệu hoặc không khớp Regex, sau đó vòng lặp sẽ quay lại cho nhập lại
                System.err.println(e.getMessage());
            }
        }
    }
}
