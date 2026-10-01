package repository;

import model.BaseNumber;

/**
 * Lớp Repository quản lý việc lưu trữ và truy xuất số gốc trong bộ nhớ tạm thời.
 * Theo mô hình MVC hoặc n-tier, Repository chịu trách nhiệm làm việc trực tiếp với dữ liệu 
 * (ở đây dữ liệu được lưu trên RAM qua biến instance, thay vì lưu database).
 */
public class BaseRepository {
    // Biến lưu trữ trạng thái của số ban đầu người dùng nhập
    private BaseNumber originalNumber;

    /**
     * Lưu trữ số gốc vào repository.
     * Phương thức này được gọi một lần khi khởi tạo Service để giữ lại thông tin số nguồn.
     * 
     * @param number Đối tượng BaseNumber chứa số gốc và hệ cơ số tương ứng.
     */
    public void save(BaseNumber number) {
        this.originalNumber = number;
    }

    /**
     * Truy xuất số gốc từ repository.
     * Service sẽ gọi hàm này mỗi khi cần lấy lại số nguồn để thực hiện các phép tính chuyển đổi.
     * 
     * @return Đối tượng BaseNumber chứa số gốc.
     */
    public BaseNumber get() {
        return originalNumber;
    }
}
