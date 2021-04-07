/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.nam.qlsv;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author IT Supporter
 */
public class SinhVienController {

    private Scanner scanner = new Scanner(System.in, "UTF-8");
    private List<SinhVien> list = null;
    private CSDL csdl = null;

    private String titleShow = String.format("%-5s %-20s %15s %10s %15s %15s %15s %-20s", 
            "MSV", "Họ tên", "Ngày sinh", "GT", "Ngành", "Email", "SĐT", "  Đ1   Đ2   Đ3   TB");
    public SinhVienController() {
        csdl = new CSDL();
        list = csdl.read();
        //test data
//        list.add(new SinhVien("1", "Pham Thanh Nam", "10/03/2000", "Nam", "KTPM", "nam@a.com", "0943840321", new Diem(8, 9, 8)));
//        list.add(new SinhVien("2", "Hoang Van An", "22/10/2000", "Nam", "KTPM", "an@a.com", "0123456852", new Diem(8, 9, 8)));
//        list.add(new SinhVien("3", "Nguyen Van An", "11/08/2000", "Nam", "CNTT", "an2@a.com", "0147852369", new Diem(7, 8, 5)));
//        list.add(new SinhVien("4", "Le Thi Chi", "03/06/2000", "Nu", "CNTT", "chi@a.com", "0254789361", new Diem(4, 3, 3)));
//        list.add(new SinhVien("5", "Hoang Le Linh", "01/01/2000", "Nam", "KHMT", "linh@a.com", "0452178963", new Diem(4, 6, 5)));
//        list.add(new SinhVien("6", "Hoang Le Lan", "19/09/2000", "Nu", "KHMT", "lan@a.com", "0321478569", new Diem(4, 5, 5)));
//        list.add(new SinhVien("7", "Hoang Le Ly", "15/05/2000", "Nu", "KTPM", "sa@a.com", "0145287412", new Diem(4, 5, 5)));
//        csdl.write(list);
    }

    public void add() {
        int id = (list.size() > 0) ? (list.size() + 1) : 1;
        String msv = String.format("%3d", id);
        String hoTen = inputString("họ tên");
        String ngaySinh = inputString("ngày sinh (vd 21/03/2000)");
        String gioiTinh = inputGender();
        String nganhHoc = inputString("ngành học");
        String email = inputString("địa chỉ email");
        String soDienThoai = inputString("số điện thoại");
        Diem diem = inputDiem();

        SinhVien sv = new SinhVien(msv, hoTen, ngaySinh, gioiTinh, nganhHoc, email, soDienThoai, diem);
        list.add(sv);
        csdl.write(list);
    }

    public void edit(String msv) {
        boolean isExisted = false;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).getMsv()== msv) {
                isExisted = true;
                list.get(i).setHoTen(inputString("họ tên"));
                list.get(i).setNgaySinh(inputString("ngày sinh (vd 21/03/2000)"));
                list.get(i).setGioiTinh(inputGender());
                list.get(i).setNganhHoc(inputString("ngành học"));
                list.get(i).setNganhHoc(inputString("địa chỉ email"));
                list.get(i).setNganhHoc(inputString("số điện thoại"));
                list.get(i).setDiem(inputDiem());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("msv = %d not existed.\n", msv);
        } else {
            csdl.write(list);
        }
    }
    
    public double maxGPA() {
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.getDiem().diemTrungBinh() > max) {
                max = sv.getDiem().diemTrungBinh();
            }
        }
        return max;
    }

    public void listSvHasMaxMinGPA() {
        double maxGPA = maxGPA();
        double minGPA = minGPA();
        System.out.println("============SINH VIÊN CÓ ĐIỂM TRUNG BÌNH CAO NHẤT============");
        System.out.println(titleShow);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDiem().diemTrungBinh() == maxGPA) {
                System.out.println(list.get(i).toString());
            }
        }
        System.out.println("============SINH VIÊN CÓ ĐIỂM TRUNG BÌNH THẤP NHẤT============");
        System.out.println(titleShow);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getDiem().diemTrungBinh() == minGPA) {
                System.out.println(list.get(i).toString());
            }
        }
    }
    public double minGPA() {
        double min = list.get(0).getDiem().diemTrungBinh();
        for (int i = 1; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.getDiem().diemTrungBinh() < min) {
                min = sv.getDiem().diemTrungBinh();
            }
        }
        return min;
    }

    public void show() {
        System.out.println("============DANH SÁCH SINH VIÊN============");
        System.out.println(titleShow);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void showKetQuaHocTap()
    {
        System.out.println("============KẾT QUẢ HỌC TẬP============");
        String titlePlus = String.format("%10s", "Kết quả");
        System.out.println(titleShow+titlePlus);
        for (int i = 0; i < list.size(); i++) {
            String ketQua = null;
            if(list.get(i).getDiem().diemTrungBinh() >=5)
                ketQua = String.format("%10s", "Đậu");
            else 
                ketQua = String.format("%10s", "Trượt");
            System.out.println(list.get(i).toString() + ketQua);
        }
    }
    
    public void xoaSinhVienTruot()
    {
        int dem = 0;
        
        for (int i = 0; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.getDiem().diemTrungBinh() < 5) {
                deleteSinhVien(sv);
                i--;
                dem++;
            }
        }
        System.out.println("Đã xóa "+dem+" sinh viên trượt!");
        showKetQuaHocTap();
        
    }
    public void deleteSinhVien(SinhVien sv) {
        int size = list.size();
        if (sv != null) {
            list.remove(sv);
            csdl.write(list);
        } else {
            System.out.printf("Object not existed.\n");
        }
    }
    
    public void sortStudentByName() {
        Collections.sort(list, new SortSinhVienByName());
        // save
        csdl.write(list);
        System.out.println("============DANH SÁCH SINH VIÊN ĐƯỢC SẮP XẾP============");
        System.out.println(titleShow);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        
    }
    private String inputString(String title) {
        System.out.print("Nhập " + title + ": ");
        return scanner.nextLine();
    }
    
    private String inputGender() {
        System.out.print("Nhập giới tính (1.Nam 2.Nữ): ");
        while (true) {
            try {
                int type = Integer.parseInt(scanner.nextLine());
                if (type != 1 && type != 2) {
                    throw new NumberFormatException();
                } else if (type == 1) {
                    return "Nam";
                } else if (type == 2) {
                    return "Nữ";
                } else 
                    return "NaN";
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }
    
    private double inputDouble(String title) {
        System.out.print("Nhập " + title + ": ");
        while (true) {
            try {
                double type = Double.parseDouble(scanner.nextLine());
                if (type <= 0 || type > 10) {
                    throw new NumberFormatException();
                }
                return type;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }

    private long inputLong(String title) {
        System.out.print(title + ": ");
        while (true) {
            try {
                long type = Long.parseLong(scanner.nextLine());
                if (type <= 0) {
                    throw new NumberFormatException();
                }
                return type;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }

    private Diem inputDiem() {
        System.out.println("Nhập điểm thành phần:");
        double diem1 = inputDouble("điểm 1");
        double diem2 = inputDouble("điểm 2");
        double diem3 = inputDouble("điểm 3");
        return new Diem(diem1, diem2, diem3);
    }
}
