package service;

import constant.Base;
import dto.BaseDto;
import model.BaseNumber;
import repository.BaseRepository;

import java.math.BigInteger;

/**
 * Lớp Service chứa các logic nghiệp vụ (Business Logic) chính để xử lý việc chuyển đổi hệ cơ số.
 * Tính toán dựa trên BigInteger để có thể xử lý các con số vô cùng lớn mà không bị tràn kiểu dữ liệu (Overflow).
 */
public class BaseService {
    private BaseRepository repo;

    /**
     * Khởi tạo Service, chuyển đổi DTO thành đối tượng Model thực thụ (BaseNumber) và lưu vào Repository.
     * Quá trình này giúp mô hình hóa dữ liệu và lưu trữ trạng thái của hệ thống.
     * @param dto DTO chứa dữ liệu đầu vào thu thập được từ người dùng.
     */
    public BaseService(BaseDto dto) {
        this.repo = new BaseRepository();
        // Tạo đối tượng Model từ DTO và lưu giữ vào kho chứa (Repository)
        repo.save(new BaseNumber(dto.getBase(), dto.getPresentation()));
    }

    /**
     * Trả về giá trị int tương ứng với Enum Base để hỗ trợ tính toán.
     * @param base Enum Base cần chuyển đổi.
     * @return Số nguyên của cơ số tương ứng (2, 10, 16) hoặc -1 nếu không hợp lệ.
     */
    private int getBaseIntValue(Base base) {
        if (base == null) {
            return -1;
        }
        switch (base) {
            case BIN:
                return 2;
            case DEC:
                return 10;
            case HEX:
                return 16;
            default:
                return -1;
        }
    }

    /**
     * Chuyển đổi số gốc (từ Repository) sang hệ thập phân (Base 10).
     * Thuật toán: Dùng phương pháp nhân đa thức. 
     * Duyệt từng chữ số từ phải sang trái (hàng đơn vị trở lên), nhân với lũy thừa tăng dần của hệ cơ số.
     * @param targetBase Hệ cơ số đích (thực chất hàm này luôn chuyển qua DEC).
     * @return Chuỗi biểu diễn giá trị ở hệ thập phân.
     * @throws Exception Nếu xảy ra lỗi trong quá trình chuyển đổi.
     */
    public String convertToDec(Base targetBase) throws Exception {
        // Lấy số gốc ra khỏi Repository
        BaseNumber originalNumber = repo.get();
        BigInteger decNum = BigInteger.ZERO; // Khởi tạo tổng bằng 0
        
        // Lấy giá trị nguyên của hệ cơ số ban đầu (ví dụ: nhị phân -> 2)
        BigInteger baseValue = BigInteger.valueOf(this.getBaseIntValue(originalNumber.getBase()));
        
        BigInteger power = BigInteger.ONE; // Biến lưu lũy thừa, bắt đầu bằng (base^0 = 1)
        String numberStr = originalNumber.getPresentation();

        // Duyệt từng chữ số từ phải sang trái, tính giá trị theo vị trí
        for (int i = numberStr.length() - 1; i >= 0; i--) {
            char digit = numberStr.charAt(i);
            
            // Lấy giá trị số tương ứng của ký tự (Kể cả 'A'-'F' thì getNumericValue cũng tự hiệu chỉnh thành 10-15)
            BigInteger digitValue = BigInteger.valueOf(Character.getNumericValue(digit));
            
            // Nhân chữ số với lũy thừa vị trí hiện tại rồi cộng dồn vào tổng thập phân
            decNum = decNum.add(digitValue.multiply(power));
            
            // Tăng lũy thừa cho vị trí tiếp theo (power = power * baseValue)
            power = power.multiply(baseValue);
        }

        // Trả về chuỗi hiển thị của số thập phân vừa tính được
        return decNum.toString();
    }

    /**
     * Chuyển đổi từ hệ thập phân (lấy từ hàm convertToDec) sang hệ cơ số đích do người dùng yêu cầu.
     * Thuật toán: Dùng phép chia liên tiếp.
     * Lấy số hệ thập phân chia cho cơ số đích liên tục, giữ lại phần dư, xếp ngược phần dư sẽ ra kết quả.
     * @param targetBase Hệ cơ số đích cần chuyển sang.
     * @return Chuỗi kết quả sau khi chuyển đổi.
     * @throws Exception Nếu xảy ra lỗi.
     */
    public String convertDecOut(Base targetBase) throws Exception {
        // Lấy số trung gian hệ thập phân
        BigInteger decNum = new BigInteger(this.convertToDec(Base.DEC));
        StringBuilder reserveResult = new StringBuilder(); // Dùng StringBuilder để chèn chuỗi hiệu quả hơn
        
        // Cơ số đích chuyển sang số nguyên để chia (ví dụ: HEX -> 16)
        BigInteger baseTarget = BigInteger.valueOf(this.getBaseIntValue(targetBase));

        // Nếu số ban đầu là 0, trả về luôn "0"
        if (decNum.compareTo(BigInteger.ZERO) == 0) {
            return "0";
        }

        // Lặp chia liên tiếp cho đến khi thương bằng 0
        while (decNum.compareTo(BigInteger.ZERO) != 0) {
            // Lấy phần dư của phép chia
            int remainNum = decNum.mod(baseTarget).intValue();
            
            // Cập nhật thương mới để chia tiếp
            decNum = decNum.divide(baseTarget);
            
            if (remainNum >= 10) {
                // Nếu dư từ 10 trở lên, chuyển thành chữ cái (A, B, C, D, E, F) (cho hệ 16)
                // Chèn vào vị trí đầu tiên của kết quả (vì phải lấy ngược)
                reserveResult.insert(0, (char) ('A' + (remainNum - 10)));
            } else {
                // Nếu dư nhỏ hơn 10 thì chèn thẳng số vào đầu
                reserveResult.insert(0, remainNum);
            }
        }

        return reserveResult.toString();
    }
}
