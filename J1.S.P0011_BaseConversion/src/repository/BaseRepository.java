/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author Admin
 */
import model.BaseNumber;

// Tang luu tru: giu so goc (originalNumber) de Service lay ra xu ly
public class BaseRepository {

    private BaseNumber originalNumber;

    // Luu so goc vao repository
    public void save(BaseNumber number) {
        this.originalNumber = number;
    }

    // Lay so goc ra de Service su dung
    public BaseNumber get() {
        return originalNumber;
    }
}
