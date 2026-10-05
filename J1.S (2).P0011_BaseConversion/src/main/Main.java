package main;

import constant.Base;
import constant.Constants;
import constant.Message;
import controller.Controller;
import dto.BaseDTO;
import java.util.Scanner;
import utils.Validation;

/**
 * Lop Main: Diem bat dau cua chuong trinh, chiu trach nhiem hien thi menu
 * va xu ly luong nhap xuat du lieu tu ban phim.
 */
public class Main {

    /**
     * Phuong thuc main dieu khien toan bo luong hoat dong
     * @param args Tham so dong lenh mac dinh
     */
    public static void main(String[] args) {
        // Khoi tao Controller de dieu phoi xu ly
        Controller controller = new Controller();
        // Khoi tao Scanner de doc du lieu nhap tu ban phim
        Scanner scanner = new Scanner(System.in);

        // Buoc 1: Hien thi menu nhap so goc va kiem tra tinh hop le
        BaseDTO inputData = promptForInputBaseNumber(scanner);

        // Buoc 2: Day DTO sang Controller de Repo thuc hien luu tru (CRUD)
        controller.saveNumber(inputData);

        // Buoc 3: Vong lap hien thi menu chon he co so dich den khi nguoi dung thoat
        while (true) {
            // Khoi bat dau try-catch de bat va xu ly loi trong qua trinh chuyen doi
            try {
                // Hien thi menu chon co so dich va lay lua chon
                Base targetBase = promptForTargetBase(scanner);

                // Kiem tra neu nguoi dung chon chuc nang Exit (tra ve null)
                if (targetBase == null) {
                    // Ket thuc vong lap va thoat chuong trinh
                    break;
                } else {
                    // Goi Controller thuc hien tinh toan nghiep vu va in ket qua
                    controller.convertNumber(targetBase);
                }
            } catch (Exception ex) {
                // In thong bao loi ra man hinh neu co loi xay ra
                System.err.println(ex.getMessage());
            }
        }
    }

    /**
     * Hien thi Menu chon co so dich va tra ve Enum Base tuong ung
     * @param scanner Doi tuong Scanner de nhap lua chon
     * @return Base dich duoc chon hoac null neu chon thoat
     * @throws Exception Khi nguoi dung nhap lua chon khong nam trong pham vi
     */
    public static Base promptForTargetBase(Scanner scanner) throws Exception {
        // In ra menu lua chon co so dich
        System.out.print(Message.CONVERT_MENU);
        // Lay lua chon so nguyen hop le tu 1 den 4
        int userChoice = Validation.getInt(scanner.nextLine(), 1, 4);

        // Kiem tra lua chon bang switch-case de tra ve doi tuong Base phu hop
        switch (userChoice) {
            case 1:
                // Lua chon 1: Chuyen sang he Nhi phan (Binary)
                return Base.BIN;
            case 2:
                // Lua chon 2: Chuyen sang he Thap phan (Decimal)
                return Base.DEC;
            case 3:
                // Lua chon 3: Chuyen sang he Thap luc phan (Hexadecimal)
                return Base.HEX;
            case 4:
                // Lua chon 4: Nguoi dung chon thoat
                return null;
            default:
                // Nem ra ngoai le neu lua chon khong hop le
                throw new IllegalArgumentException(Message.ERROR_INVALID_TARGET);
        }
    }

    /**
     * Hien thi menu chon co so nguon, nhap chuoi so va validate day du vao BaseDTO
     * @param scanner Doi tuong Scanner de nhap du lieu
     * @return BaseDTO chua day du thong tin co so va chuoi bieu dien hop le
     */
    public static BaseDTO promptForInputBaseNumber(Scanner scanner) {
        // Vong lap lap lai cho toi khi nguoi dung nhap du lieu hoan toan hop le
        while (true) {
            // Khoi try-catch kiem soat ngoai le khi nhap lieu
            try {
                // In ra menu lua chon he co so goc ban dau
                System.out.print(Message.INPUT_BASE_MENU);
                // Lay lua chon so nguyen hop le tu 1 den 3
                int baseOption = Validation.getInt(scanner.nextLine(), 1, 3);

                // Khoi tao DTO de chua du lieu nguon
                BaseDTO inputDto = new BaseDTO();
                String rawNumberString;

                // Kiem tra he co so nguon da chon va yeu cau nhap chuoi so tuong ung
                switch (baseOption) {
                    case 1:
                        // Gan co so nguon la Binary
                        inputDto.setBase(Base.BIN);
                        // In thong bao yeu cau nhap so Binary
                        System.out.print(Message.ENTER_BIN);
                        // Validate chuoi so nhap vao theo bieu thuc Regex Binary
                        rawNumberString = Validation.getString(scanner.nextLine(), Constants.REGEX_BINARY);
                        break;
                    case 2:
                        // Gan co so nguon la Decimal
                        inputDto.setBase(Base.DEC);
                        // In thong bao yeu cau nhap so Decimal
                        System.out.print(Message.ENTER_DEC);
                        // Validate chuoi so nhap vao theo bieu thuc Regex Decimal
                        rawNumberString = Validation.getString(scanner.nextLine(), Constants.REGEX_DECIMAL);
                        break;
                    case 3:
                        // Gan co so nguon la Hexadecimal
                        inputDto.setBase(Base.HEX);
                        // In thong bao yeu cau nhap so Hexadecimal
                        System.out.print(Message.ENTER_HEX);
                        // Validate chuoi so nhap vao theo bieu thuc Regex Hexadecimal
                        rawNumberString = Validation.getString(scanner.nextLine(), Constants.REGEX_HEXADECIMAL);
                        break;
                    default:
                        // Bo qua va yeu cau nhap lai neu lua chon khong khop
                        continue;
                }

                // Luu chuoi bieu dien hop le vao doi tuong DTO
                inputDto.setPresentation(rawNumberString);
                // Tra ve DTO hoan chinh de san sang truyen sang tang duoi
                return inputDto;

            } catch (Exception ex) {
                // In thong bao loi nhap lieu va vong lap tiep tuc de nguoi dung nhap lai
                System.err.println(ex.getMessage());
            }
        }
    }
}