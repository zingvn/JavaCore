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
public class Nguoi implements Serializable{
    private String hoTen;
    private String ngaySinh;
    private String gioiTinh;

    public Nguoi() {
    }

    public Nguoi(String hoTen, String ngaySinh, String gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public String getTen() {
        this.hoTen = this.hoTen.trim();
        int i = this.hoTen.lastIndexOf(" ");
        String ten = this.hoTen.substring(i+1);
        return ten;
    }
    
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return String.format("%-50s %-15s %-10s", hoTen, ngaySinh, gioiTinh);
    }
    
    
}
