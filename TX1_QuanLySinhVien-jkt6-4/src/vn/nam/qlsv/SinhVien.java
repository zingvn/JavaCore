/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.nam.qlsv;

/**
 *
 * @author IT Supporter
 */
public class SinhVien extends Nguoi{
    private String msv;
    private String nganhHoc;
    private String email;
    private String soDienThoai;
    private Diem diem;

    public SinhVien() {
    }

    public SinhVien(String msv, String nganhHoc, String email, String soDienThoai, Diem diem) {
        this.msv = msv;
        this.nganhHoc = nganhHoc;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diem = diem;
    }

    public SinhVien(String msv, String hoTen, String ngaySinh, String gioiTinh, String nganhHoc, String email, String soDienThoai, Diem diem) {
        super(hoTen, ngaySinh, gioiTinh);
        this.msv = msv;
        this.nganhHoc = nganhHoc;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diem = diem;
    }

    public String getMsv() {
        return msv;
    }

    public void setMsv(String msv) {
        this.msv = msv;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Diem getDiem() {
        return diem;
    }

    public void setDiem(Diem diem) {
        this.diem = diem;
    }


    @Override
    public String toString() {
        return String.format("%-5s %s %15s %15s %15s %s", 
                msv, super.toString(), nganhHoc, email, soDienThoai, diem.toString());
    }

    
    
}
