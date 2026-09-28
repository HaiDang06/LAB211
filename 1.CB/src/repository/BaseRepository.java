package repository;

import model.BaseNumber;

/**
 * Lớp Repository quản lý việc lưu trữ và truy xuất số gốc trong bộ nhớ tạm thời.
 */
public class BaseRepository {
    private BaseNumber originalNumber;

    // Luu so goc vao repository
    /**
     * Lưu trữ số gốc vào repository.
     * @param number Đối tượng BaseNumber chứa số gốc.
     */
    public void save(BaseNumber number) {
        this.originalNumber = number;
    }

    // Lay so goc ra de Service su dung
    /**
     * Truy xuất số gốc từ repository.
     * @return Đối tượng BaseNumber chứa số gốc.
     */
    public BaseNumber get() {
        return originalNumber;
    }
}
