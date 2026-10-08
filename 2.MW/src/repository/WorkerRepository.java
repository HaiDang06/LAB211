package repository;

import constant.Messages;
import model.Worker;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp kho lưu trữ (Repository) quản lý danh sách công nhân trong bộ nhớ.
 */
public class WorkerRepository {
    private List<Worker> workerList;

    public WorkerRepository(){
        this.workerList = new ArrayList<>();
    }

    /**
     * Tìm kiếm công nhân theo ID.
     * @param id Mã công nhân cần tìm
     * @return Đối tượng Worker nếu tìm thấy, ngược lại trả về null
     * @throws Exception nếu có lỗi xảy ra
     */
    public Worker getWorkerById(String id) throws Exception{
        for (Worker worker: workerList){
            if (worker.getId().equalsIgnoreCase(id)){
                return worker;
            }
        }
        return null;
    }

    /**
     * Thêm công nhân mới vào danh sách.
     * @param worker Đối tượng công nhân cần thêm
     * @return true nếu thêm thành công
     * @throws Exception nếu công nhân đã tồn tại (trùng ID)
     */
    public boolean add(Worker worker) throws Exception{
        if (getWorkerById(worker.getId()) != null){
            throw new Exception(String.format(Messages.DUPLICATE_ERROR, worker.getId()));
        }
        return workerList.add(worker);
    }

    /**
     * Lấy toàn bộ danh sách công nhân.
     * @return Danh sách công nhân (bản sao)
     */
    public List<Worker> getAll(){
        return new ArrayList<>(workerList);
    }

    /**
     * Kiểm tra danh sách công nhân có trống không.
     * @return true nếu trống, false nếu có dữ liệu
     */
    public boolean isEmpty(){
        return workerList.isEmpty();
    }
}
