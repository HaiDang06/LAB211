package repository;

import dto.BaseDTO;
import model.BaseNumber;

public class BaseRepository {

    // Bien thanh vien luu doi tuong so goc
    private BaseNumber originalNumber;

    /**
     * Luu so goc tu DTO truyen vao (Create / Update)
     * @param dto Doi tuong DTO chua thong tin base va chuoi so
     */
    public void save(BaseDTO dto) {
        // Khoi tao BaseNumber tu DTO va gan truc tiep vao bien thanh vien cua lop
        this.originalNumber = new BaseNumber(dto.getBase(), dto.getPresentation());
    }

    /**
     * Lay so goc ra khoi bo nho (Read)
     * @return Doi tuong BaseNumber da duoc luu
     */
    public BaseNumber get() {
        // Tra ve doi tuong so goc
        return this.originalNumber;
    }
}