package main;

import constant.Base;
import constant.Constants;
import constant.Message;
import controller.Controller;
import dto.BaseDTO;
import java.util.Scanner;
import utils.Validation;
 
// Diem khoi dau: xu ly nhap lieu, validate hoan toan truoc khi truyen vao DTO
public class Main {
    public static void main(String[] args) {
        Controller control = new Controller();
        Scanner scanner = new Scanner(System.in);
 
        // Buoc 1: Nhap va validate so nguon, dam bao DTO hop le truoc khi truyen
        BaseDTO inputData = inputBaseNumber(scanner);
        control.setDto(inputData);
 
        // Buoc 2: Vong lap chuyen doi, nguoi dung chon he dich den khi thoat
        while (true) {
            try {
                Base targetBase = inputTargetBase(scanner);
                // Neu nguoi dung chon 4 (exit) thi thoat vong lap
                if (targetBase == null) { break; }
                inputData.setTargetBase(targetBase);
                control.convertNumber();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }
 
    // Hien thi menu chon he dich va tra ve Base tuong ung
    // Tra ve null neu nguoi dung chon exit (lua chon 4)
    public static Base inputTargetBase(Scanner scanner) throws Exception {
        System.out.print(Message.CONVERT_MENU);
        int choice = Validation.getInt(scanner.nextLine(), 1, 4);
        switch (choice) {
            case 1: return Base.BIN;
            case 2: return Base.DEC;
            case 3: return Base.HEX;
            case 4: return null;
            default: throw new IllegalArgumentException(Message.ERROR_INVALID_TARGET);
        }
    }
 
    // Nhap va validate so nguon: loop den khi du lieu hop le moi thoat
    // Dam bao DTO luon chua du lieu hop le truoc khi tra ve
    public static BaseDTO inputBaseNumber(Scanner scanner) {
        while (true) {
            try {
                System.out.print(Message.INPUT_BASE_MENU);
                int baseChoice = Validation.getInt(scanner.nextLine(), 1, 3);
                BaseDTO dto = new BaseDTO();
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
