package controller;

import constant.Base;
import constant.Message;
import dto.BaseDTO;
import dto.ResponseDTO;
import service.BaseService;
import view.BaseView;

public class Controller {

    private BaseService baseService;
    private BaseView view;
    private BaseDTO dto;

    public Controller() {
        this.view = new BaseView();
    }

    public void setDto(BaseDTO dto) {
        this.dto = dto;
    }

    public void convertNumber() {
        ResponseDTO response = new ResponseDTO();
        view.setResponseDTO(response);

        try {
            baseService = new BaseService(dto);
            String resultPresentation;

            // Neu target la thap phan thi dung method chuyen doi rieng
            if (dto.getTargetBase() == Base.DEC) {
                resultPresentation = baseService.convertToDec(Base.DEC);
            } else {
                // Nguoc lai dung method chuyen doi chung
                resultPresentation = baseService.convertDecOut(dto.getTargetBase());
            }

            // Dat ket qua vao response roi day sang View
            response.setMess(String.format(Message.CONVERT_SUCCESS, resultPresentation));
            view.displayMessages();

        } catch (Exception e) {
            // Bat loi va day thong bao loi sang View
            response.setError(e.getMessage());
            view.displayErrorMessages();
        }
    }
}