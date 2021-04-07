/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.nam.qlsv;

import java.io.Serializable;

/**
 *
 * @author IT Supporter
 */
public class Diem implements Serializable{
    private double diem1, diem2, diem3;

    public Diem() {
    }

    public Diem(double diem1, double diem2, double diem3) {
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public double getDiem1() {
        return diem1;
    }

    public void setDiem1(double diem1) {
        this.diem1 = diem1;
    }

    public double getDiem2() {
        return diem2;
    }

    public void setDiem2(double diem2) {
        this.diem2 = diem2;
    }

    public double getDiem3() {
        return diem3;
    }

    public void setDiem3(double diem3) {
        this.diem3 = diem3;
    }
    
    public double diemTrungBinh()
    {
        return (diem1+diem2+diem3)/3;
    }

    @Override
    public String toString() {
        return String.format("%5.2f %5.2f %5.2f %5.2f", diem1, diem2, diem3, diemTrungBinh());
    }
    
    
}
