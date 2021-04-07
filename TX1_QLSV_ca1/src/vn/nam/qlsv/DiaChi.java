/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlsv;

import java.io.Serializable;

/**
 *
 * @author duato
 */
public class DiaChi implements Serializable{
    private String duong;
    private String quan;
    private String thanhPho;
    private long maVung;

    public DiaChi() {
    }

    public DiaChi(String Duong, String Quan, String ThanhPho, long MaVung) {
        this.duong = Duong;
        this.quan = Quan;
        this.thanhPho = ThanhPho;
        this.maVung = MaVung;
    }

    public String getDuong() {
        return duong;
    }

    public void setDuong(String Duong) {
        this.duong = duong;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String Quan) {
        this.quan = Quan;
    }

    public String getThanhPho() {
        return thanhPho;
    }

    public void setThanhPho(String ThanhPho) {
        this.thanhPho = ThanhPho;
    }

    public long getMaVung() {
        return maVung;
    }

    public void setMaVung(long MaVung) {
        this.maVung = MaVung;
    }

    @Override
    public String toString() {
        return String.format("Đường/Xã %s, Quận/Huyện %s, Tỉnh/Thành Phố %s, %s", duong, quan, thanhPho, maVung);
    }
    
    
}
