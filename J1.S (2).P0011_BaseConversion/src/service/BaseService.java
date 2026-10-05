package service;

import constant.Base;
import dto.BaseDTO;
import java.math.BigInteger;
import model.BaseNumber;
import repository.BaseRepository;

/**
 * Tang nghiep vu: Kiem tra ton tai, quan ly repository va tinh toan chuyen doi
 */
public class BaseService {

    // Khoi tao Repository de thuc hien CRUD du lieu
    private final BaseRepository baseRepository;

    public BaseService() {
        // Khoi tao doi tuong repository
        this.baseRepository = new BaseRepository();
    }

    /**
     * Kiem tra ton tai va day DTO xuong Repository de luu tru
     * @param dto Du lieu nhap tu Controller
     * @throws Exception Neu DTO khong hop le hoac bi rong
     */
    public void save(BaseDTO dto) throws Exception {
        // Kiem tra du lieu dau vao co ton tai hay khong
        if (dto == null || dto.getPresentation() == null || dto.getPresentation().trim().isEmpty()) {
            // Nem ngoai le neu du lieu dau vao bi trong
            throw new Exception("Du lieu dau vao khong hop le hoac bi trong.");
        } else {
            // Goi Repository thuc hien luu tru DTO
            baseRepository.save(dto);
        }
    }

    /**
     * Kiem tra ton tai va thuc hien thuat toan chuyen doi co so
     * @param targetBase Co so dich can chuyen doi toi
     * @return Chuoi ket qua bieu dien so sau khi chuyen
     * @throws Exception Neu chua co so goc trong repository
     */
    public String convert(Base targetBase) throws Exception {
        // Kiem tra xem so goc da ton tai trong Repository hay chua
        BaseNumber originalNumber = baseRepository.get();
        if (originalNumber == null) {
            // Nem loi neu chua co du lieu
            throw new Exception("Chua co du lieu so goc de thuc hien chuyen doi.");
        }

        // Buoc 1: Chuyen so goc sang he Thap phan (Base 10)
        BigInteger decValue = convertToDecimal(originalNumber);

        // Buoc 2: Chuyen tu he Thap phan sang he co so dich
        if (targetBase == Base.DEC) {
            // Tra ve luon ket qua neu he dich la thap phan
            return decValue.toString();
        } else {
            // Chuyen sang BIN hoac HEX neu khong phai thap phan
            return convertDecimalToTarget(decValue, targetBase);
        }
    }

    /**
     * Chuyen doi tu bat ky co so nao sang Decimal
     */
    private BigInteger convertToDecimal(BaseNumber number) {
        BigInteger decimalResult = BigInteger.ZERO;
        BigInteger baseRadix = BigInteger.valueOf(number.getBase().getValue());
        BigInteger positionMultiplier = BigInteger.ONE;
        String presentation = number.getPresentation().toUpperCase();

        // Duyet qua tung ky tu tu phai sang trai
        for (int index = presentation.length() - 1; index >= 0; index--) {
            char digitChar = presentation.charAt(index);
            int digitValue;

            // Kiem tra ky tu la so hay chu cai
            if (digitChar >= '0' && digitChar <= '9') {
                // Tinh gia tri cho chu so 0 den 9
                digitValue = digitChar - '0';
            } else {
                // Tinh gia tri cho chu cai A den F
                digitValue = digitChar - 'A' + 10;
            }

            // Cong don gia tri vao ket qua
            decimalResult = decimalResult.add(BigInteger.valueOf(digitValue).multiply(positionMultiplier));
            // Nhan luy thua co so
            positionMultiplier = positionMultiplier.multiply(baseRadix);
        }
        return decimalResult;
    }

    /**
     * Chuyen doi Decimal sang BIN hoac HEX
     */
    private String convertDecimalToTarget(BigInteger decimalValue, Base targetBase) {
        // Xu ly truong hop so bang 0
        if (decimalValue.equals(BigInteger.ZERO)) {
            return "0";
        }

        StringBuilder outputBuilder = new StringBuilder();
        BigInteger targetRadix = BigInteger.valueOf(targetBase.getValue());

        // Chia lay du lien tuc cho toi khi bang 0
        while (decimalValue.compareTo(BigInteger.ZERO) > 0) {
            int remainder = decimalValue.mod(targetRadix).intValue();
            decimalValue = decimalValue.divide(targetRadix);

            // Neu phan du >= 10 thi chuyen thanh chu cai
            if (remainder >= 10) {
                // Doi sang cac ky tu tu A den F
                outputBuilder.insert(0, (char) ('A' + (remainder - 10)));
            } else {
                // Giu nguyen chu so
                outputBuilder.insert(0, remainder);
            }
        }
        return outputBuilder.toString();
    }
}