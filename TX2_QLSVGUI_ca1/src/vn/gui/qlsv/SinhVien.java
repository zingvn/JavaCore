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
public class SinhVien extends Nguoi implements ChuyenNganh, Serializable{
    private long stt;
    private DiaChi diaChiNha;
    private DiaChi diaChiTruong;
    private double diem1;
    private double diem2;
    private double diem3;
    private String tenCN;
    private String ngoaiNgu;

    public SinhVien() {
    }

    public SinhVien(long stt, DiaChi diaChiNha, DiaChi diaChiTruong, double diem1, double diem2, double diem3, String tenCN, String ngoaiNgu) {
        this.stt = stt;
        this.diaChiNha = diaChiNha;
        this.diaChiTruong = diaChiTruong;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.tenCN = tenCN;
        this.ngoaiNgu = ngoaiNgu;
    }

    public SinhVien(long stt, String ho, String ten, String gioiTinh, int namSinh, DiaChi diaChiNha, DiaChi diaChiTruong, double diem1, double diem2, double diem3, String tenCN, String ngoaiNgu) {
        super(ho, ten, gioiTinh, namSinh);
        this.stt = stt;
        this.diaChiNha = diaChiNha;
        this.diaChiTruong = diaChiTruong;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
        this.tenCN = tenCN;
        this.ngoaiNgu = ngoaiNgu;
    }

    public long getStt() {
        return stt;
    }

    public void setStt(long stt) {
        this.stt = stt;
    }

    public String getNgoaiNgu() {
        return ngoaiNgu;
    }

    public void setNgoaiNgu(String ngoaiNgu) {
        this.ngoaiNgu = ngoaiNgu;
    }



    public DiaChi getDiaChiNha() {
        return diaChiNha;
    }

    public void setDiaChiNha(DiaChi diaChiNha) {
        this.diaChiNha = diaChiNha;
    }

    public DiaChi getDiaChiTruong() {
        return diaChiTruong;
    }

    public void setDiaChiTruong(DiaChi diaChiTruong) {
        this.diaChiTruong = diaChiTruong;
    }
    
    public double getCotDiem(int type) {
        if (type == 1) {
            return diem1;
        } else if (type == 2) {
            return diem2;
        } else if (type == 3) {
            return diem3;
        } else {
            return 0;
        }
    }

    public void setCotDiem(int type, double value) {
        if (type == 1) {
            diem1 = value;
        } else if (type == 2) {
            diem2 = value;
        } else if (type == 3) {
            diem3 = value;
        }
    }
    
    public double diemTrungBinh()
    {
        double diemTong = 0;
        byte dauDiem = 0;
        if (diem1 != 0) {
            diemTong += diem1;
            dauDiem++;
        }
        if (diem2 != 0) {
            diemTong += diem2;
            dauDiem++;
        }
        if (diem3 != 0) {
            diemTong += diem3;
            dauDiem++;
        }
        return diemTong/dauDiem;
    }
    @Override
    public String getChuyenNganh() {
        return this.tenCN;
    }

    @Override
    public void setChuyenNganh(String nganh) {
        this.tenCN = nganh;
    }

    @Override
    public String toString() {
        return String.format("%s \nĐịa chỉ: %s \nChuyên ngành: %s\n"
                + "Học tại: %s \nĐiểm: %.2f%.2f%.2f , Trung bình: %.2f\nNgoại ngữ: %s", 
                super.toString(), diaChiNha.toString(), getChuyenNganh(), diaChiTruong.toString(),
                diem1, diem2, diem3, diemTrungBinh(), ngoaiNgu); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
