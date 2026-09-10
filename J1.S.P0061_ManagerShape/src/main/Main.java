package main;

import constant.Message;
import controller.ShapeController;
import dto.ShapeDTO;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShapeController controller = new ShapeController();
        ShapeDTO dto = new ShapeDTO();

        // 2. Nhập và validate dữ liệu cho Rectangle
        double width = inputDouble(sc, Message.WIDTH_PROMPT, Double.MIN_VALUE, 100);
        double length = inputDouble(sc, Message.LENGTH_PROMPT, width, 100); // Thường length >= width
        
        dto.setWidth(width);
        dto.setLength(length);

        // 3. Nhập và validate dữ liệu cho Circle
        double radius = inputDouble(sc, Message.RADIUS_PROMPT, Double.MIN_VALUE, 100);
        dto.setRadius(radius);

        // 4. Nhập và validate dữ liệu cho Triangle (Kiểm tra điều kiện 3 cạnh)
        while (true) {
            try {
                double sideA = inputDouble(sc, Message.SIDE_A_PROMPT, Double.MIN_VALUE, 100);
                double sideB = inputDouble(sc, Message.SIDE_B_PROMPT, Double.MIN_VALUE, 100);
                double sideC = inputDouble(sc, Message.SIDE_C_PROMPT, Double.MIN_VALUE, 100);

                if (sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA) {
                    dto.setSideA(sideA);
                    dto.setSideB(sideB);
                    dto.setSideC(sideC);
                    break;
                } else {
                    System.out.println(Message.TRIANGLE_SIDE_SUM_ERROR);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // 5. Truyền DTO vào Controller và thực thi logic xử lý + hiển thị
        controller.setDto(dto);
        controller.processShape();
    }

    private static double inputDouble(Scanner sc, String prompt, double min, double max) {
        while (true) {
            try {
                System.out.print(prompt);
                return utils.Validation.getDouble(sc.nextLine(), min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}