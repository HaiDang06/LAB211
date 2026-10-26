package ui;

import constant.Message;
import controller.Controller;
import dto.MatrixDTO;
import java.util.Scanner;
import utils.Validation;

public class Main {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Controller control = new Controller();
        MatrixDTO dto = new MatrixDTO();
        control.setDto(dto);

        while (true) {
            // Show menu
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            // Validate choice
            int choice = getSafeInt(Message.PROMPT_CHOICE, 1, 4);

            if (choice == 4) {
                break;
            }

            // Nhập Ma trận 1 bình thường
            int[][] m1 = inputMatrix1();
            // Nhập Ma trận 2 có kiểm tra điều kiện kích thước dựa theo phép tính (choice) và Ma trận 1
            int[][] m2 = inputMatrix2(choice, m1.length, m1[0].length);

            // Wrap in DTO
            dto.setMatrix1(m1);
            dto.setMatrix2(m2);

            // Switch-case logic at Main
            switch (choice) {
                case 1:
                    control.executeAddition();
                    break;
                case 2:
                    control.executeSubtraction();
                    break;
                case 3:
                    control.executeMultiplication();
                    break;
            }
        }
    }

    private static int getSafeInt(String prompt, int min, int max) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = SCANNER.nextLine();
                return Validation.getInt(input, min, max);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Hàm hỗ trợ bắt nhập đúng kích thước khớp với Ma trận 1
    private static int getSafeDimension(String prompt, int expectedSize, String errorMsg) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = SCANNER.nextLine();
                return Validation.getMatrixDimension(input, expectedSize, errorMsg);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int[][] inputMatrix1() {
        int rows = getSafeInt(String.format(Message.PROMPT_ROW, 1), 1, 10);
        int cols = getSafeInt(String.format(Message.PROMPT_COL, 1), 1, 10);
        return inputElements(1, rows, cols);
    }

    private static int[][] inputMatrix2(int choice, int row1, int col1) {
        int rows;
        int cols;

        if (choice == 1 || choice == 2) {
            // Phép cộng & trừ: Dòng 2 = Dòng 1, Cột 2 = Cột 1
            rows = getSafeDimension(
                    String.format(Message.PROMPT_ROW, 2),
                    row1,
                    "Row of Matrix 2 must be equal to Row of Matrix 1 (" + row1 + ")."
            );
            cols = getSafeDimension(
                    String.format(Message.PROMPT_COL, 2),
                    col1,
                    "Column of Matrix 2 must be equal to Column of Matrix 1 (" + col1 + ")."
            );
        } else {
            // Phép nhân: Dòng 2 = Cột 1, Cột 2 tự do (1 -> 10)
            rows = getSafeDimension(
                    String.format(Message.PROMPT_ROW, 2),
                    col1,
                    "Row of Matrix 2 must be equal to Column of Matrix 1 (" + col1 + ")."
            );
            cols = getSafeInt(String.format(Message.PROMPT_COL, 2), 1, 10);
        }

        return inputElements(2, rows, cols);
    }

    private static int[][] inputElements(int matrixNumber, int rows, int cols) {
        int[][] data = new int[rows][cols];
        System.out.println(String.format(Message.PROMPT_ELEMENTS, matrixNumber));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = getSafeInt(
                        String.format(Message.PROMPT_MATRIX_CELL, matrixNumber, i + 1, j + 1),
                        Integer.MIN_VALUE, Integer.MAX_VALUE
                );
            }
        }
        return data;
    }
}