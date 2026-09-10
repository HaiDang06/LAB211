package controller;

import dto.ResponseDTO;
import dto.ShapeDTO;
import java.util.List;
import repository.ShapeRepository;
import view.ShapeView;

public class ShapeController {

    private ShapeRepository repo;
    private ShapeView view;
    private ShapeDTO dto;

    public ShapeController() {
        this.repo = new ShapeRepository();
        this.view = new ShapeView();
        this.dto = new ShapeDTO();
    }

    public void setDto(ShapeDTO dto) {
        this.dto = dto;
    }

    public void processShape() {
        view.displayTitle();
        repo.addShapes(dto);
        List<ResponseDTO> responses = repo.getAllResults();
        view.setResponses(responses);
        view.printResult();
    }
}
