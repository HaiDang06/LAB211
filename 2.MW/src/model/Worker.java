package model;

import constant.Constants;
import constant.Messages;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp thực thể (Entity Model) đại diện cho thông tin một Công nhân (Worker).
 * 
 * Lớp này cài đặt giao diện {@link Comparable} nhằm hỗ trợ sắp xếp danh sách công nhân
 * theo thứ tự tự nhiên (tăng dần theo mã ID) khi sử dụng phương thức Collections.sort().
 */
public class Worker implements Comparable<Worker> {

    /**
     * Mã định danh duy nhất của công nhân (Ví dụ: W1, W002).
     */
    private String id;

    /**
     * Họ và tên đầy đủ của công nhân.
     */
    private String name;

    /**
     * Tuổi của công nhân (Nằm trong khoảng từ 18 đến 50).
     */
    private int age;

    /**
     * Mức lương hiện tại của công nhân (luôn cập nhật sau mỗi lần tăng/giảm lương).
     */
    private double currentSalary;

    /**
     * Nơi làm việc / địa điểm công tác của công nhân.
     */
    private String workLocation;

    /**
     * Danh sách lưu trữ toàn bộ lịch sử các lần thay đổi lương (khởi tạo, tăng, giảm) của công nhân này.
     */
    List<SalaryHistory> historyList;

    /**
     * Hàm khởi tạo đối tượng công nhân với các thông tin cơ bản ban đầu.
     * Tự động khởi tạo một danh sách ArrayList rỗng để chứa lịch sử biến động lương.
     * 
     * @param id Mã công nhân duy nhất.
     * @param name Họ và tên công nhân.
     * @param age Tuổi của công nhân.
     * @param currentSalary Mức lương cơ bản khởi đầu.
     * @param workLocation Nơi làm việc.
     */
    public Worker(String id, String name, int age, double currentSalary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.currentSalary = currentSalary;
        this.workLocation = workLocation;
        this.historyList = new ArrayList<>();
    }

    /**
     * Lấy mã công nhân.
     * 
     * @return Chuỗi mã công nhân (ID).
     */
    public String getId() {
        return id;
    }

    /**
     * Cập nhật mã công nhân.
     * 
     * @param id Mã công nhân mới cần gán.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Lấy họ tên công nhân.
     * 
     * @return Tên công nhân.
     */
    public String getName() {
        return name;
    }

    /**
     * Cập nhật họ tên công nhân.
     * 
     * @param name Họ tên mới.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lấy độ tuổi của công nhân.
     * 
     * @return Tuổi (kiểu int).
     */
    public int getAge() {
        return age;
    }

    /**
     * Cập nhật độ tuổi công nhân.
     * 
     * @param age Độ tuổi mới.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Lấy mức lương hiện tại của công nhân.
     * 
     * @return Mức lương hiện tại (kiểu double).
     */
    public double getCurrentSalary() {
        return currentSalary;
    }

    /**
     * Cập nhật mức lương hiện tại của công nhân.
     * 
     * @param currentSalary Mức lương mới.
     */
    public void setCurrentSalary(double currentSalary) {
        this.currentSalary = currentSalary;
    }

    /**
     * Lấy địa điểm làm việc của công nhân.
     * 
     * @return Chuỗi địa điểm làm việc.
     */
    public String getWorkLocation() {
        return workLocation;
    }

    /**
     * Cập nhật địa điểm làm việc của công nhân.
     * 
     * @param workLocation Địa điểm làm việc mới.
     */
    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    /**
     * Lấy danh sách toàn bộ lịch sử thay đổi lương của công nhân này.
     * 
     * @return Danh sách các bản ghi {@link SalaryHistory}.
     */
    public List<SalaryHistory> getHistory() {
        return historyList;
    }

    /**
     * Thiết lập hoặc thay thế toàn bộ danh sách lịch sử lương.
     * 
     * @param history Danh sách lịch sử mới.
     */
    public void setHistory(List<SalaryHistory> history) {
        this.historyList = history;
    }

    /**
     * Phương thức so sánh 2 đối tượng Worker phục vụ việc sắp xếp theo ID (tăng dần theo thứ tự từ điển).
     * 
     * @param o Đối tượng công nhân khác cần so sánh với đối tượng hiện tại.
     * @return Một số âm nếu ID hiện tại nhỏ hơn ID của đối tượng o,
     *         0 nếu 2 ID bằng nhau,
     *         một số dương nếu ID hiện tại lớn hơn ID của đối tượng o.
     */
    @Override
    public int compareTo(Worker o) {
        return id.compareTo(o.id);
    }

    /**
     * Định dạng chuỗi hiển thị toàn bộ lịch sử thay đổi lương của công nhân này thành dạng bảng.
     * Mỗi dòng tương ứng với một lần biến động lương (Mã, Tên, Tuổi, Lương tại thời điểm đó, Trạng thái, Ngày giờ).
     * 
     * @return Chuỗi đã được định dạng cột ngay ngắn.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // Định dạng ngày tháng theo chuẩn quy định trong Constants (dd/MM/yyyy)
        SimpleDateFormat df = new SimpleDateFormat(Constants.DATE_REGEX);
        // Duyệt qua từng bản ghi lịch sử trong danh sách của công nhân
        for (SalaryHistory sh : historyList) {
            sb.append(String.format("%7s%10s%10s%10s%10s%15s\n",
                    this.id,
                    this.name,
                    this.age,
                    sh.getSalaryHistory(),
                    sh.getStatus(),
                    df.format(sh.getDate())));
        }
        return sb.toString();
    }
}
