/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.gui.qlsv;

import java.io.Serializable;

/**
 *
 * @author duato
 */
public class Nguoi implements Serializable{
    private String ho;
    private String ten;
    private String gioiTinh;
    private int namSinh;

    public Nguoi() {
    }

    public Nguoi(String ho, String ten, String gioiTinh, int namSinh) {
        this.ho = ho;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    

    @Override
    public String toString() {
        return String.format("Họ tên: %20s%10s\n"
                + "Năm sinh: %4d \nGiới tính: %3s",
                ho, ten, namSinh, gioiTinh);
    }
    
    
}
