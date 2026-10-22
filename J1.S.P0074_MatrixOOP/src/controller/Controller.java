package controller;

import dto.MatrixDTO;
import dto.ResponseDTO;
import java.util.List;
import service.MatrixService;
import view.MatrixView;

public class Controller {

    private MatrixDTO dto;
    private MatrixView view;
    private MatrixService service;

    public Controller() {
        this.dto = new MatrixDTO();
        this.view = new MatrixView();
        this.service = new MatrixService();
    }

    public void setDto(MatrixDTO dto) {
        this.dto = dto;
    }

    public void executeAddition() {
        calculate("+");
    }

    public void executeSubtraction() {
        calculate("-");
    }

    public void executeMultiplication() {
        calculate("*");
    }

    private void calculate(String operator) {
        List<ResponseDTO> response;
        try {
            switch (operator) {
                case "+":
                    response = service.add(dto);
                    break;
                case "-":
                    response = service.subtract(dto);
                    break;
                case "*":
                    response = service.multiply(dto);
                    break;
                default:
                    throw new Exception("Invalid operator");
            }
            view.setOperator(operator);
            view.setResponseDTO(response);
            view.printResult();
        } catch (Exception e) {
            view.setError(e.getMessage());
            view.displayErrorMessages();
        }
    }
}
