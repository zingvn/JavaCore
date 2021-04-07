/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.gui.qlsv;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author duato
 */
public class SinhVienController {
    private Scanner scanner = new Scanner(System.in);
    private List<SinhVien> list = null;
    private SinhVienDAO sinhvienDAO = null;

    public SinhVienController() {
        sinhvienDAO = new SinhVienDAO();
        list = sinhvienDAO.read();
    }
    
    public int add(SinhVien sv)
    {
        int id = (list.size() > 0) ? (list.size() + 1) : 1;
        list.add(sv);
        sinhvienDAO.write(list);
        return id;
    }
    
    public double maxGPA()
    {
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.diemTrungBinh() > max) {
                max = sv.diemTrungBinh();
            }
        }
        return max;
    }

}
