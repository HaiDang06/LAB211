/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constant;

/**
 *
 * @author win
 */
public enum TaskType{
    // Dinh nghia cac hang so loai task kem theo ma id va ten hien thi
    CODE(1, "Code"),
    TEST(2, "Test"),
    DESIGN(3, "Design"),
    REVIEW(4, "Review");
    
    private int id;
    private String name;

    // Ham khoi tạo cho enum de gan gia tri id va ten
    private TaskType(int id, String name) {
        this.id = id;
        this.name = name;
    }
    // Phuong thức tim kiem va tra ve loai TaskType dua vao ma id truyen vao
    public static TaskType getTaskTypeById(int Id){
        switch (Id) {
            case 1:
                return CODE;
            case 2:
                return TEST;
            case 3:
                return DESIGN;
            case 4:
                return REVIEW;
                
            default:
                throw new AssertionError();
        }
        
        
    }
    //// Lay gia tri id cua loai task
    public int getId() {
        return id;
    }

    // Lay ten cua loai task
    public String getName() {
        return name;
    }
}