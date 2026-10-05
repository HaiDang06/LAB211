package constant;

/**
 * Enum đại diện cho các hệ cơ số hỗ trợ (Thập phân, Thập lục phân, Nhị phân).
 * Cung cấp một tập hợp hằng số cố định để đảm bảo tính nhất quán khi thao tác
 * chuyển đổi giữa các hệ đếm trong toàn bộ chương trình.
 */
public enum Base {
    /** Hệ cơ số 10 (Thập phân - Decimal). Sử dụng các chữ số từ 0 đến 9. */
    DEC, 
    
    /** Hệ cơ số 16 (Thập lục phân - Hexadecimal). Sử dụng chữ số từ 0-9 và chữ cái A-F. */
    HEX, 
    
    /** Hệ cơ số 2 (Nhị phân - Binary). Chỉ sử dụng hai chữ số 0 và 1. */
    BIN
}
