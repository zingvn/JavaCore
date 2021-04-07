/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.nam.qlsv;

import java.util.Comparator;

/**
 *
 * @author IT Supporter
 */
public class SortSinhVienByName implements Comparator<SinhVien> {

    @Override
    public int compare(SinhVien sv1, SinhVien sv2) {
        if (sv1.getTen().compareTo(sv2.getTen()) != 0) {
            return sv1.getTen().compareTo(sv2.getTen());
        } else {
            if (sv1.getDiem().getDiem1()> sv2.getDiem().getDiem1()) {
                return 1;
            } else {
                if (sv1.getDiem().getDiem2() > sv2.getDiem().getDiem2()) {
                    return 1;
                } else {
                    if (sv1.getDiem().getDiem3() > sv2.getDiem().getDiem3()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }
    
}
