/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.nam.qlsv;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author IT Supporter
 */
public class SinhVienController {

    private Scanner scanner = new Scanner(System.in, "UTF-8");
    private List<SinhVien> list = null;
    private CSDL csdl = null;

    public SinhVienController() {
        csdl = new CSDL();
        list = csdl.read();
        //test data

    }

    public int add(SinhVien sv) {
        list = csdl.read();
        int id = (list.size() > 0) ? (list.size() + 1) : 1;
        list.add(sv);
        csdl.write(list);
        return id;
    }
    
    public int setDiem(String msv, Diem diem)
    {
        list = csdl.read();
        boolean isExisted = false;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getMsv().equals(msv)) {
                isExisted = true;
                list.get(i).setDiem(diem);
                break;
            }
        }
        if (!isExisted) {
            return -1;
        } else {
            csdl.write(list);
            return 1;
        }
    }
    
    public double maxGPA() {
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.getDiem().diemTrungBinh() > max) {
                max = sv.getDiem().diemTrungBinh();
            }
        }
        return max;
    }
    public double minGPA() {
        double min = list.get(0).getDiem().diemTrungBinh();
        for (int i = 1; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.getDiem().diemTrungBinh() < min) {
                min = sv.getDiem().diemTrungBinh();
            }
        }
        return min;
    }

    public String show() {
        String all = "";
        for (int i = 0; i < list.size(); i++) {
            all += list.get(i).toString()+"\n";
        }
        return all;
    }

}
