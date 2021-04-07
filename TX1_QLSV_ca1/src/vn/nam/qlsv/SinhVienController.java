/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlsv;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author duato
 */
public class SinhVienController {
    private Scanner scanner = new Scanner(System.in);
    private List<SinhVien> list = null;
    private SinhVienDAO sinhvienDAO = null;

    public SinhVienController() {
        sinhvienDAO = new SinhVienDAO();
        list = sinhvienDAO.read();
    }
    
    public void add()
    {
        String ho = inputString("họ");
        String ten = inputString("tên");
        System.out.println("Nhập địa chỉ nhà: ");
        DiaChi diaChiNha = inputAddress();
        System.out.println("Nhập địa chỉ trường học: ");
        DiaChi diaChiTruong = inputAddress();
        String tenCN = inputString("chuyên ngành");
        double diem1 = inputDouble("điểm 1");
        double diem2 = inputDouble("điểm 2");
        double diem3 = inputDouble("điểm 3");
        
        SinhVien sv = new SinhVien(ho, ten, diaChiNha, diaChiTruong, diem1, diem2, diem3, tenCN);
        list.add(sv);
        sinhvienDAO.write(list);
    }
    
    public double maxGPA()
    {
        double max = 0;
        for (int i = 0; i < list.size(); i++) {
            SinhVien sv = list.get(i);
            if (sv.diemTrungBinh() > max) {
                max = sv.diemTrungBinh();
            }
        }
        return max;
    }
    
    public void listSvHasMaxGPA()
    {
        double maxGPA = maxGPA();
        System.out.println("============SINH VIÊN CÓ ĐIỂM TRUNG BÌNH CAO NHẤT============");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).diemTrungBinh() == maxGPA) {
                System.out.println(list.get(i).toString());
                System.out.println("_______________________________");
            }
        }
    }
    
    public void show(){
        System.out.println("============DANH SÁCH SINH VIÊN============");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
            System.out.println("_______________________________");
        }
    }
    
    private String inputString(String title)
    {
        System.out.print("Nhập "+title+": ");
        return scanner.nextLine();
    }
    
    private double inputDouble(String title)
    {
        System.out.print("Nhập "+title+": ");
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
    private long inputLong(String title)
    {
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
    private DiaChi inputAddress(){
        System.out.print(" - Nhập tên Đường/Xã: ");
        String duong = scanner.nextLine();
        System.out.print(" - Nhập tên Quận/Huyện: ");
        String quan = scanner.nextLine();
        System.out.print(" - Nhập tên Tỉnh/Thành Phố: ");
        String thanhPho = scanner.nextLine();
        long maVung = inputLong(" - Nhập mã vùng");
        return new DiaChi(duong, quan, thanhPho, maVung);
    }
}
