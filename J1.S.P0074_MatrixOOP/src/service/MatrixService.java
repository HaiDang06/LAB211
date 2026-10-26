package service;

import dto.MatrixDTO;
import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import model.Matrix;
import repository.MatrixRepository;

public class MatrixService {

    private MatrixRepository repo;

    public MatrixService() {
        this.repo = new MatrixRepository();
    }

    // Nghiệp vụ Cộng 2 ma trận
    public List<ResponseDTO> add(MatrixDTO dto) {
        initMatrices(dto);

        Matrix m1 = repo.getMatrix(0);
        Matrix m2 = repo.getMatrix(1);

        int rows = m1.getRows();
        int cols = m1.getCols();
        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = m1.getData()[i][j] + m2.getData()[i][j];
            }
        }

        saveResult(res);
        return getResponseList();
    }

    // Nghiệp vụ Trừ 2 ma trận
    public List<ResponseDTO> subtract(MatrixDTO dto) {
        initMatrices(dto);

        Matrix m1 = repo.getMatrix(0);
        Matrix m2 = repo.getMatrix(1);

        int rows = m1.getRows();
        int cols = m1.getCols();
        int[][] res = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[i][j] = m1.getData()[i][j] - m2.getData()[i][j];
            }
        }

        saveResult(res);
        return getResponseList();
    }

    // Nghiệp vụ Nhân 2 ma trận
    public List<ResponseDTO> multiply(MatrixDTO dto) {
        initMatrices(dto);

        Matrix m1 = repo.getMatrix(0);
        Matrix m2 = repo.getMatrix(1);

        int rows1 = m1.getRows();
        int cols1 = m1.getCols();
        int cols2 = m2.getCols();
        int[][] res = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    res[i][j] += m1.getData()[i][k] * m2.getData()[k][j];
                }
            }
        }

        saveResult(res);
        return getResponseList();
    }

    // Xóa dữ liệu cũ và truyền trực tiếp MatrixDTO xuống Repository
    private void initMatrices(MatrixDTO dto) {
        repo.clear();
        repo.createMatrices(dto);
    }

    // Đóng gói mảng kết quả vào ResponseDTO và truyền xuống Repository
    private void saveResult(int[][] res) {
        ResponseDTO resultDto = new ResponseDTO();
        resultDto.setData(res);
        repo.createResultMatrix(resultDto);
    }

    // Chuyển đổi danh sách Matrix trong Repo sang List<ResponseDTO>
    private List<ResponseDTO> getResponseList() {
        List<ResponseDTO> result = new ArrayList<>();
        for (Matrix matrix : repo.getAll()) {
            ResponseDTO response = new ResponseDTO();
            response.setData(matrix.getData());
            result.add(response);
        }
        return result;
    }
}