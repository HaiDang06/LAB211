package controller;

import constant.Base;
import constant.Message;
import dto.BaseDto;
import dto.ResponseDto;
import service.BaseService;
import view.BaseView;

/**
 * Lớp Controller điều khiển luồng thực thi chính, đóng vai trò cầu nối giữa Service và View.
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
     * @param dto Đối tượng BaseDto chứa dữ liệu cần xử lý.
     */
    public void setDto(BaseDto dto) {
        this.dto = dto;
    }

    /**
     * Thực hiện chuyển đổi hệ cơ số dựa trên DTO đã được cung cấp và cập nhật View để hiển thị.
     */
    public void convertNumber() {
        ResponseDto response = new ResponseDto();
        view.setResponseDto(response);
        try {
            baseService = new BaseService(dto);
            String resultPresentation;
            if (dto.getTargetBase() == Base.DEC) {
                resultPresentation = baseService.convertToDec(Base.DEC);
            } else {
                resultPresentation = baseService.convertDecOut(dto.getTargetBase());
            }
            response.setMess(String.format(Message.CONVERT_SUCCESS, resultPresentation));
            view.displayMessages();
        } catch (Exception e) {
            response.setError(e.getMessage());
            view.displayErrorMessages();
        }
    }
}
