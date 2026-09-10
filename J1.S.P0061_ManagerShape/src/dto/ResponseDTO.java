/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Tuan Tran
 */
public class ResponseDTO {

    private String shapeName;
    private String info;
    private double area;
    private double perimeter;

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public String toString() {
        StringBuilder db = new StringBuilder();
        db.append(String.format("-----------%s-----------\n", shapeName));
        db.append(info);
        db.append(String.format("\nArea: %.2f", area));
        db.append(String.format("\nPerimeter: %.2f", perimeter));
        return db.toString();
    }
}
