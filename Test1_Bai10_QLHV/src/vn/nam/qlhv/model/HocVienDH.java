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
public class HocVienDH extends HocVien{
    private int soBuoiHoc;
    private double donGiaDH = 500000;

    public HocVienDH() {
        setChuongTrinh("Đồ hoạ");
    }

    public HocVienDH(int soBuoiHoc) {
        this.soBuoiHoc = soBuoiHoc;
        setChuongTrinh("Đồ hoạ");
    }

    public HocVienDH(int id, String hoTen, String diaChi, byte loaiUT, int soBuoiHoc) {
        super(id, hoTen, diaChi, loaiUT, "Đồ hoạ");
        this.soBuoiHoc = soBuoiHoc;
    }
    
    public HocVienDH(int id, String hoTen, String diaChi, byte loaiUT, String chuongTrinh, int soBuoiHoc) {
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
        return donGiaDH;
    }

    public void setDonGiaDH(double donGiaDH) {
        this.donGiaDH = donGiaDH;
    }


    @Override
    public double hocPhi() {
        double hocPhi = 0;
        double uuTien = 0;
        if (getLoaiUT() == 1) {
            uuTien = 1000000;
        } else if(getLoaiUT() == 2) {
            uuTien = 50000;
        }
        hocPhi = soBuoiHoc*donGiaDH-uuTien;
        
        return hocPhi;
    }

    @Override
    public String toString() {
        String info = String.format("%5d %10f %10f", soBuoiHoc, donGiaDH, hocPhi());
        return super.toString()+info; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
