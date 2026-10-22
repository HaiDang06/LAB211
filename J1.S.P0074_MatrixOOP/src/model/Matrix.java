package model;

public class Matrix {
    private int[][] data;

    public Matrix(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public int getRows() {
        return data.length;
    }

    public int getCols() {
        return data[0].length;
    }
}
