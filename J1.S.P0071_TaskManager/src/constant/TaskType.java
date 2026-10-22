package constant;

/**
 * Enum định nghĩa các loại công việc (Task Type) được hỗ trợ trong hệ thống:
 * 1. CODE: Lập trình / Viết mã nguồn
 * 2. TEST: Kiểm thử phần mềm
 * 3. DESIGN: Thiết kế hệ thống, cơ sở dữ liệu hoặc giao diện
 * 4. REVIEW: Đánh giá, soát lỗi mã nguồn hoặc tài liệu
 *
 * @author Tuan Tran
 */
public enum TaskType {
    /** Công việc lập trình / viết code (Tương ứng ID 1) */
    CODE,

    /** Công việc kiểm thử phần mềm (Tương ứng ID 2) */
    TEST,

    /** Công việc thiết kế hệ thống / giao diện (Tương ứng ID 3) */
    DESIGN,

    /** Công việc đánh giá, rà soát mã nguồn (Tương ứng ID 4) */
    REVIEW
}