/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import dto.ResponseDTO;
import dto.ShapeDTO;
import java.util.ArrayList;
import java.util.List;
import model.Circle;
import model.Rectangle;
import model.Shape;
import model.Triangle;

/**
 *
 * @author Tuan Tran
 */
public class ShapeRepository {

    private List<Shape> shapeList;

    public ShapeRepository() {
        this.shapeList = new ArrayList<>();
    }

    public void addShapes(ShapeDTO dto) {
        shapeList.add(new Rectangle(dto.getWidth(), dto.getLength()));
        shapeList.add(new Circle(dto.getRadius()));
        shapeList.add(new Triangle(dto.getSideA(), dto.getSideB(), dto.getSideC()));
    }

    public List<ResponseDTO> getAllResults() {
        List<ResponseDTO> results = new ArrayList<>();
        for (Shape s : shapeList) {
            ResponseDTO res = new ResponseDTO();
            res.setArea(s.getArea());
            res.setPerimeter(s.getPerimeter());
            if (s instanceof Rectangle) {
                Rectangle r = (Rectangle) s;
                res.setShapeName("Rectangle");
                res.setInfo(String.format("Width: %.1f\nLength: %.1f", r.getWidth(), r.getLength()));
            } else if (s instanceof Circle) {
                Circle c = (Circle) s;
                res.setShapeName("Circle");
                res.setInfo(String.format("Radius: %.1f", c.getRadius()));
            } else if (s instanceof Triangle) {
                Triangle t = (Triangle) s;
                res.setShapeName("Triangle");
                res.setInfo(String.format("Side A: %.1f\nSide B: %.1f\nSide C: %.1f",
                        t.getSideA(), t.getSideB(), t.getSideC()));
            }
            results.add(res);
        }
        return results;
    }
}
