package repository;

import dto.MatrixDTO;
import dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import model.Matrix;

public class MatrixRepository {

    private List<Matrix> storage;

    public MatrixRepository() {
        this.storage = new ArrayList<>();
    }

    // CREATE: Nhận MatrixDTO để tạo và lưu 2 ma trận đầu vào
    public void createMatrices(MatrixDTO dto) {
        if (dto != null) {
            if (dto.getMatrix1() != null) {
                storage.add(new Matrix(dto.getMatrix1()));
            }
            if (dto.getMatrix2() != null) {
                storage.add(new Matrix(dto.getMatrix2()));
            }
        }
    }

    // CREATE: Nhận ResponseDTO để tạo và lưu ma trận kết quả
    public void createResultMatrix(ResponseDTO responseDto) {
        if (responseDto != null && responseDto.getData() != null) {
            storage.add(new Matrix(responseDto.getData()));
        }
    }

    // READ: Lấy 1 ma trận theo vị trí
    public Matrix getMatrix(int index) {
        if (index >= 0 && index < storage.size()) {
            return storage.get(index);
        }
        return null;
    }

    // READ: Lấy toàn bộ danh sách ma trận
    public List<Matrix> getAll() {
        return storage;
    }

    // DELETE: Xóa toàn bộ dữ liệu cũ
    public void clear() {
        storage.clear();
    }
}