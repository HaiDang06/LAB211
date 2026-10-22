/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import constant.Message;
import controller.Controller;
import dto.MatrixDTO;
import java.util.Scanner;
import utils.Validation;

/**
 *
 * @author win
 */
public class Main {

    public static void main(String[] args) {
        Controller control = new Controller();
        MatrixDTO dto = new MatrixDTO();
        control.setDto(dto);
        while (true) {
            // Show menu from Controller
            System.out.println(Message.MENU_HEADER.concat(Message.MENU_BODY));
            // Validate choice
            int choice = getSafeInt(Message.PROMPT_CHOICE, 1, 4);

            if (choice == 4) {
                break;
            }

            // Collect Matrix data via Scanner
            int[][] m1 = inputSingleMatrix(1);
            int[][] m2 = inputSingleMatrix(2);

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

    /**
     * Helper method to repeatedly prompt user until a valid integer is entered.
     *
     * @param prompt the message to display
     * @param min minimum value
     * @param max maximum value
     * @return a valid integer
     */
    private static int getSafeInt(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                // Calling your Validation logic
                return Validation.getInt(input, min, max);
            } catch (Exception e) {
                // Printing the specific error message from Validation class
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Handles single matrix input flow using the safe integer helper.
     *
     * @param matrixNumber the identifier for matrix (1 or 2)
     * @return 2D array data
     */
    private static int[][] inputSingleMatrix(int matrixNumber) {
        int rows = getSafeInt(String.format(Message.PROMPT_ROW, matrixNumber), 1, 10);
        int cols = getSafeInt(String.format(Message.PROMPT_COL, matrixNumber), 1, 10);

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
