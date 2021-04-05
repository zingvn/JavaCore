/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlhv.model;

import java.io.Serializable;

/**
 *
 * @author duato
 */
public abstract class HocVien implements Serializable{
    private int id;
    private String hoTen, diaChi;
    private byte loaiUT;
    private String chuongTrinh;

    public HocVien() {
    }

    public HocVien(int id, String hoTen, String diaChi, byte loaiUT, String chuongTrinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.loaiUT = loaiUT;
        this.chuongTrinh = chuongTrinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public byte getLoaiUT() {
        return loaiUT;
    }

    public void setLoaiUT(byte loaiUT) {
        this.loaiUT = loaiUT;
    }

    public String getChuongTrinh() {
        return chuongTrinh;
    }

    public void setChuongTrinh(String chuongTrinh) {
        this.chuongTrinh = chuongTrinh;
    }

    public abstract double hocPhi();
    
    @Override
    public String toString() {
        return String.format("%5d %15s %15s %5d %10s", id, hoTen, diaChi, loaiUT, chuongTrinh);
    }
    
}
