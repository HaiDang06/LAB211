package controller;

import constant.Base;
import constant.Message;
import dto.BaseDto;
import dto.ResponseDto;
import service.BaseService;
import view.BaseView;

/**
 * Lớp Controller điều khiển luồng thực thi chính, đóng vai trò cầu nối giữa Service (xử lý logic) và View (hiển thị).
 * Nó nhận dữ liệu đầu vào (đã được đóng gói vào DTO), gọi Service để thực hiện thuật toán,
 * và đưa kết quả cho View để in ra cho người dùng.
 */
public class BaseController {
    private BaseService baseService;
    private BaseView view;
    private BaseDto dto;

    /**
     * Khởi tạo BaseController, đồng thời tạo mới đối tượng BaseView để hiển thị kết quả.
     */
    public BaseController() {
        this.view = new BaseView();
    }

    /**
     * Cung cấp dữ liệu đầu vào (DTO) cho Controller.
     * @param dto Đối tượng BaseDto chứa dữ liệu cần xử lý (bao gồm số ban đầu, hệ số cũ, hệ số mới).
     */
    public void setDto(BaseDto dto) {
        this.dto = dto;
    }

    /**
     * Thực hiện luồng chuyển đổi hệ cơ số dựa trên DTO đã được cung cấp và cập nhật View để hiển thị.
     * Thuật toán sử dụng cơ số 10 làm trung gian: 
     * - Nếu chuyển sang cơ số 10 thì gọi convertToDec().
     * - Nếu chuyển sang cơ số khác thì gọi convertDecOut() (bên trong sẽ tự động convert sang cơ số 10 trước).
     */
    public void convertNumber() {
        ResponseDto response = new ResponseDto();
        // Cập nhật ResponseDto vào View để chuẩn bị in kết quả
        view.setResponseDto(response);
        try {
            // Khởi tạo Service với dữ liệu DTO. Service sẽ lưu dữ liệu vào Repository
            baseService = new BaseService(dto);
            String resultPresentation;
            
            // Xử lý chuyển đổi tùy thuộc vào hệ cơ số đích
            if (dto.getTargetBase() == Base.DEC) {
                // Nếu đích đến là hệ Thập phân (10), chỉ cần gọi chuyển đổi sang Decimal
                resultPresentation = baseService.convertToDec(Base.DEC);
            } else {
                // Nếu đích đến là hệ khác (Nhị phân, Thập lục phân), gọi hàm convertDecOut 
                // để chuyển số (đã ngầm định qua trung gian hệ 10) sang hệ mong muốn
                resultPresentation = baseService.convertDecOut(dto.getTargetBase());
            }
            
            // Gán kết quả thành công vào ResponseDto
            response.setMess(String.format(Message.CONVERT_SUCCESS, resultPresentation));
            
            // Yêu cầu View hiển thị thông báo thành công
            view.displayMessages();
        } catch (Exception e) {
            // Ghi nhận thông báo lỗi nếu có Exception xảy ra trong quá trình tính toán hoặc khởi tạo
            response.setError(e.getMessage());
            
            // Yêu cầu View hiển thị thông báo lỗi
            view.displayErrorMessages();
        }
    }
}
