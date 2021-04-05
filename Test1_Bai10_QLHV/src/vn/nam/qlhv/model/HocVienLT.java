/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlhv.model;

/**
 *
 * @author duato
 */
public class HocVienLT extends HocVien{
    private int soBuoiHoc;
    private double donGiaLT = 700000;

    public HocVienLT() {
        setChuongTrinh("Lập trình");
        
    }

    public HocVienLT(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
        setChuongTrinh("Lập trình");
    }

    public HocVienLT(int id, String hoTen, String diaChi, byte loaiUT, int soBuoiHoc) {
        super(id, hoTen, diaChi, loaiUT, "Lập trình");
        this.soBuoiHoc = soBuoiHoc;
    }
    
    public HocVienLT(int id, String hoTen, String diaChi, byte loaiUT, String chuongTrinh, int soBuoiHoc) {
        super(id, hoTen, diaChi, loaiUT, chuongTrinh);
        this.soBuoiHoc = soBuoiHoc;
    }

    public int getSoBuoiHoc() {
        return soBuoiHoc;
    }

    public void setSoBuoiHoc(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
    }

    public double getDonGiaDH() {
        return donGiaLT;
    }

    public void setDonGiaDH(double donGiaLT) {
        this.donGiaLT = donGiaLT;
    }

    @Override
    public double hocPhi() {
        double hocPhi = 0;
        double uuTien = 0;
        if (getLoaiUT() == 1) {
            uuTien = 1000000;
        } else if (getLoaiUT() == 2) {
            uuTien = 80000;
        }
        hocPhi = soBuoiHoc * donGiaLT - uuTien;

        return hocPhi;
    }

    
    @Override
    public String toString() {
        String info = String.format("%5d %10f %10f", soBuoiHoc, donGiaLT, hocPhi());
        return super.toString()+info; //To change body of generated methods, choose Tools | Templates.
    }
    
}
