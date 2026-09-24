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
 * Lớp khởi chạy chương trình chính, xử lý giao tiếp người dùng qua console.
 *
 * @author Admin
 */
public class Main {

    /**
     * Hàm main thực thi chương trình.
     * @param args Các đối số truyền vào từ dòng lệnh.
     */
    public static void main(String[] args) {
        BaseController controller = new BaseController();
        Scanner scanner = new Scanner(System.in);

        BaseDto inputData = inputBaseNumber(scanner);
        controller.setDto(inputData);
        while (true) {
            try {
                Base targetBase = inputTargetBase(scanner);
                if (targetBase == null) {
                    break;
                }
                inputData.setTargetBase(targetBase);
                controller.convertNumber();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * Cho phép người dùng nhập hệ cơ số đích để chuyển đổi sang.
     * @param scanner Đối tượng Scanner dùng để đọc dữ liệu.
     * @return Hệ cơ số đích, hoặc null nếu người dùng chọn thoát.
     * @throws Exception Nếu lựa chọn không hợp lệ.
     */
    public static Base inputTargetBase(Scanner scanner) throws Exception {
        System.out.println(Message.CONVERT_MENU);
        int choice = Validation.getInt(scanner.nextLine(), 1, 4);
        switch (choice) {
            case 1:
                return Base.BIN;
            case 2:
                return Base.DEC;
            case 3:
                return Base.HEX;
            case 4:
                return null;
            default:
                throw new IllegalArgumentException(Message.ERROR_INVALID_TARGET);
        }

    }

    /**
     * Cho phép người dùng nhập hệ cơ số đầu vào và giá trị tương ứng.
     * @param scanner Đối tượng Scanner dùng để đọc dữ liệu.
     * @return Đối tượng BaseDto chứa thông tin đầu vào.
     */
    public static BaseDto inputBaseNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.print(Message.INPUT_BASE_MENU);
                int baseChoice = Validation.getInt(scanner.nextLine(), 1, 3);
                BaseDto dto = new BaseDto();
                String numberStr;
                // Chon regex phu hop voi he so dem nguon de validate chuoi nhap
                switch (baseChoice) {
                    case 1:
                        dto.setBase(Base.BIN);
                        System.out.print(Message.ENTER_BIN);
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
                        continue;
                }
                dto.setPresentation(numberStr);
                return dto; // Chi tra ve khi du lieu da hop le
            } catch (Exception e) {
                System.err.println(e.getMessage());
                // Loop lai de nhap lai, khong bao gio tra ve null
            }
        }
    }
}
