/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dto.MatrixDTO;
import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import model.Matrix;
import repository.MatrixRepository;

/**
 *
 * @author Tuan Tran
 */
public class MatrixService {

    private MatrixRepository repo;

    public MatrixService() {
        this.repo = new MatrixRepository();
    }

    public List<ResponseDTO> add(MatrixDTO dto) throws Exception {
        repo.clear();
        Matrix m1 = new Matrix(dto.getMatrix1());
        Matrix m2 = new Matrix(dto.getMatrix2());
        repo.createNewMatrix(m1);
        repo.createNewMatrix(m2);
        repo.add();
        List<ResponseDTO> result = new ArrayList<>();
        for (Matrix matrix : repo.getAll()) {
            ResponseDTO response = new ResponseDTO();
            response.setData(matrix.getData());
            result.add(response);
        }
        return result;
    }

    public List<ResponseDTO> subtract(MatrixDTO dto) throws Exception {
        repo.clear();
        Matrix m1 = new Matrix(dto.getMatrix1());
        Matrix m2 = new Matrix(dto.getMatrix2());
        repo.createNewMatrix(m1);
        repo.createNewMatrix(m2);
        repo.subtract();
        List<ResponseDTO> result = new ArrayList<>();
        for (Matrix matrix : repo.getAll()) {
            ResponseDTO response = new ResponseDTO();
            response.setData(matrix.getData());
            result.add(response);
        }
        return result;
    }

    public List<ResponseDTO> multiply(MatrixDTO dto) throws Exception {
        repo.clear();
        Matrix m1 = new Matrix(dto.getMatrix1());
        Matrix m2 = new Matrix(dto.getMatrix2());
        repo.createNewMatrix(m1);
        repo.createNewMatrix(m2);
        repo.multiply();
        List<ResponseDTO> result = new ArrayList<>();
        for (Matrix matrix : repo.getAll()) {
            ResponseDTO response = new ResponseDTO();
            response.setData(matrix.getData());
            result.add(response);
        }
        return result;
    }
}
