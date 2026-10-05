package controller;

import constant.Base;
import constant.Message;
import dto.BaseDTO;
import dto.ResponseDTO;
import service.BaseService;
import view.BaseView;

/**
 * Controller: Dieu phoi giua Main, Service va View
 */
public class Controller {

    private final BaseService baseService;
    private final BaseView baseView;

    public Controller() {
        // Khoi tao tang Service va View
        this.baseService = new BaseService();
        this.baseView = new BaseView();
    }

    /**
     * Chuyen giao BaseDTO sang Service de kiem tra va luu vao Repo
     * @param inputDto Du lieu truyen tu Main
     */
    public void saveNumber(BaseDTO inputDto) {
        ResponseDTO responseDTO = new ResponseDTO();
        baseView.setResponseDTO(responseDTO);

        // Khoi bat dau try-catch de bat loi nghiep vu khi luu
        try {
            // Goi service thuc hien kiem tra va luu
            baseService.save(inputDto);
        } catch (Exception ex) {
            // Day thong bao loi sang View
            responseDTO.setError(ex.getMessage());
            baseView.displayErrorMessages();
        }
    }

    /**
     * Yeu cau Service chuyen doi co so va day ket qua sang View
     * @param targetBase Co so can chuyen doi sang
     */
    public void convertNumber(Base targetBase) {
        ResponseDTO responseDTO = new ResponseDTO();
        baseView.setResponseDTO(responseDTO);

        // Khoi try-catch bat loi khi tinh toan
        try {
            // Goi service thuc hien chuyen doi
            String convertedResult = baseService.convert(targetBase);

            // Dat thong bao ket qua va hien thi ra man hinh
            responseDTO.setMess(String.format(Message.CONVERT_SUCCESS, convertedResult));
            baseView.displayMessages();
        } catch (Exception ex) {
            // Dat thong bao loi va hien thi ra man hinh
            responseDTO.setError(ex.getMessage());
            baseView.displayErrorMessages();
        }
    }
}