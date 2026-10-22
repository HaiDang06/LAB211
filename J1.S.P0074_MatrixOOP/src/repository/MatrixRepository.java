/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository;

import model.Matrix;

/**
 *
 * @author Tuan Tran
 */
import java.util.ArrayList;
import java.util.List;
import utils.Validation;

public class MatrixRepository {

    private List<Matrix> storage;

    public MatrixRepository() {
        this.storage = new ArrayList<>();
    }

    public void createNewMatrix(Matrix matrix) {
        if (matrix != null) {
            storage.add(matrix);
        }
    }

    public Matrix getMatrix(int index) {
        if (index >= 0 && index < storage.size()) {
            return storage.get(index);
        }
        return null;
    }

    public void add() throws Exception {
        Matrix m1 = storage.get(0);
        Matrix m2 = storage.get(1);
        if (Validation.isValidAdd(m1, m2)) {
            throw new Exception("Size must be the same for addition.");
        }
        int[][] res = new int[m1.getRows()][m1.getCols()];
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getCols(); j++) {
                res[i][j] = m1.getData()[i][j] + m2.getData()[i][j];
            }
        }
        Matrix m3 = new Matrix(res);
        createNewMatrix(m3);
    }

    public void subtract() throws Exception {
        Matrix m1 = storage.get(0);
        Matrix m2 = storage.get(1);
        if (Validation.isValidAdd(m1, m2)) {
            throw new Exception("Size must be the same for subtraction.");
        }
        int[][] res = new int[m1.getRows()][m1.getCols()];
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m1.getCols(); j++) {
                res[i][j] = m1.getData()[i][j] - m2.getData()[i][j];
            }
        }
        Matrix m3 = new Matrix(res);
        createNewMatrix(m3);
    }

    public void multiply() throws Exception {
        Matrix m1 = storage.get(0);
        Matrix m2 = storage.get(1);
        if (Validation.isValidMul(m1, m2)) {
            throw new Exception("Matrix 1 columns must equal Matrix 2 rows.");
        }
        int[][] res = new int[m1.getRows()][m2.getCols()];
        for (int i = 0; i < m1.getRows(); i++) {
            for (int j = 0; j < m2.getCols(); j++) {
                for (int k = 0; k < m1.getCols(); k++) {
                    res[i][j] += m1.getData()[i][k] * m2.getData()[k][j];
                }
            }
        }
        Matrix m3 = new Matrix(res);
        createNewMatrix(m3);
    }

    public List<Matrix> getAll() {
        return storage;
    }
    
    public void clear(){
        storage.clear();
    }
}
