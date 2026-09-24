package service;

import constant.Base;
import dto.BaseDto;
import model.BaseNumber;
import repository.BaseRepository;

import java.math.BigInteger;

/**
 * Lớp Service chứa các logic nghiệp vụ xử lý chuyển đổi hệ cơ số.
 */
public class BaseService {
    private BaseRepository repo;

    // Nhan DTO tu Controller, tu tao BaseNumber va luu vao Repository
    /**
     * Khởi tạo Service, chuyển đổi DTO thành đối tượng model và lưu vào repository.
     * @param dto DTO chứa dữ liệu đầu vào.
     */
    public BaseService(BaseDto dto) {
        this.repo = new BaseRepository();
        repo.save(new BaseNumber(dto.getBase(), dto.getPresentation()));
    }

    // Chuyen so goc sang thap phan (Base 10)
    /**
     * Chuyển đổi số gốc sang hệ thập phân (Base 10).
     * @param targetBase Hệ cơ số đích.
     * @return Chuỗi biểu diễn giá trị ở hệ thập phân.
     * @throws Exception Nếu xảy ra lỗi trong quá trình chuyển đổi.
     */
    public String convertToDec(Base targetBase) throws Exception {
        BaseNumber originalNumber = repo.get();
        BigInteger decNum = BigInteger.ZERO;
        BigInteger baseValue = BigInteger.valueOf(model.BaseModel.getValue(originalNumber.getBase()));
        BigInteger power = BigInteger.ONE;
        String numberStr = originalNumber.getPresentation();

        // Duyet tung chu so tu phai sang trai, tinh gia tri theo vi tri
        for (int i = numberStr.length() - 1; i >= 0; i--) {
            char digit = numberStr.charAt(i);
            BigInteger digitValue = BigInteger.valueOf(Character.getNumericValue(digit));
            // Nhan chu so voi luy thua vi tri roi cong vao tong
            decNum = decNum.add(digitValue.multiply(power));
            // Tang luy thua cho vi tri tiep theo
            power = power.multiply(baseValue);
        }

        // Trả về chuỗi hiển thị thay vì đối tượng BaseNumber
        return decNum.toString();
    }

    /**
     * Chuyển đổi từ hệ thập phân sang hệ cơ số đích.
     * @param targetBase Hệ cơ số đích cần chuyển sang.
     * @return Chuỗi kết quả sau khi chuyển đổi.
     * @throws Exception Nếu xảy ra lỗi.
     */
    public String convertDecOut(Base targetBase) throws Exception {
        BigInteger decNum = new BigInteger(this.convertToDec(Base.DEC));
        StringBuilder reserveResult = new StringBuilder();
        BigInteger baseTarget = BigInteger.valueOf(model.BaseModel.getValue(targetBase));

        while (decNum.compareTo(BigInteger.ZERO) != 0) {
            int remainNum = decNum.mod(baseTarget).intValue();
            decNum = decNum.divide(baseTarget);
            if (remainNum >= 10) {
                reserveResult.insert(0, (char) ('A' + (remainNum - 10)));
            } else {
                reserveResult.insert(0, remainNum);
            }
        }

        if (reserveResult.length() == 0) {
            reserveResult.append("0");
        }

        return reserveResult.toString();
    }
}
