package view;

import constant.Message;
import dto.ResponseDTO;
import java.util.List;

public class ShapeView {
    private List<ResponseDTO> responses;

    public void displayTitle() {
        System.out.println(Message.HEADER);
    }

    public void setResponses(List<ResponseDTO> responses) {
        this.responses = responses;
    }

    public void printResult() {
        if (responses == null) return;
        for (ResponseDTO res : responses) {
            System.out.println(res.toString());
        }
    }
}
