
package view;

import dto.ResponseDTO;


public class BaseView {
    private ResponseDTO responseDTO;

    public BaseView() {
        responseDTO = new ResponseDTO();
    }

    // Phương thức để Controller đẩy dữ liệu vào View
    public void setResponseDTO(ResponseDTO responseDTO) {
        this.responseDTO = responseDTO;
    }

    public void displayMessages() {
        if (responseDTO != null) {
            System.out.println(responseDTO.getMess());
        }
    }

    public void displayErrorMessages() {
        if (responseDTO != null) {
            System.out.println(responseDTO.getError());
        }
    }

    public void displayMenu() {
        if (responseDTO != null) {
            System.out.println(responseDTO.getMenu());
        }
    }
}
