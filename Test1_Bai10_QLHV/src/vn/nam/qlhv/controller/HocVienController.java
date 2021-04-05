/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlhv.controller;

import java.util.List;
import java.util.Scanner;
import vn.nam.qlhv.dao.HocVienDHDao;
import vn.nam.qlhv.dao.HocVienLTDao;
import vn.nam.qlhv.model.HocVienDH;
import vn.nam.qlhv.model.HocVienLT;

/**
 *
 * @author duato
 */
public class HocVienController {
    private static Scanner scanner = new Scanner(System.in);
    private List<HocVienDH> listHocVienDH;
    private HocVienDHDao hocvienDHDao;
    private List<HocVienLT> listHocVienLT;
    private HocVienLTDao hocvienLTDao;

    public HocVienController() {
        hocvienDHDao = new HocVienDHDao();
        listHocVienDH = hocvienDHDao.read();
        hocvienLTDao = new HocVienLTDao();
        listHocVienLT = hocvienLTDao.read();
    }
    
    public void add() {
        String hoTen = inputName();
        String diaChi = inputAddress();
        byte loaiUT = inputType();
        byte chuongTrinh = inputStudy();
        int soBuoiHoc = inputSession();
        if(chuongTrinh == 1)
        {
            int id = (listHocVienDH.size() > 0) ? (listHocVienDH.size() + 1) : 1;
            HocVienDH hocvienDH = new HocVienDH(id, hoTen, diaChi, loaiUT, soBuoiHoc);
            listHocVienDH.add(hocvienDH);
            hocvienDHDao.write(listHocVienDH);
        } else if (chuongTrinh == 2) {
            int id = (listHocVienLT.size() > 0) ? (listHocVienLT.size() + 1) : 1;
            HocVienLT hocvienLT = new HocVienLT(id, hoTen, diaChi, loaiUT, soBuoiHoc);
            listHocVienLT.add(hocvienLT);
            hocvienLTDao.write(listHocVienLT);
        }
    }
    
    public void edit(int id, byte chuongTrinh) {
        boolean isExisted = false;
        if (chuongTrinh == 1) {
            int size = listHocVienDH.size();
            for (int i = 0; i < size; i++) {
                if (listHocVienDH.get(i).getId() == id) {
                    isExisted = true;
                    listHocVienDH.get(i).setHoTen(inputName());
                    listHocVienDH.get(i).setDiaChi(inputAddress());
                    listHocVienDH.get(i).setLoaiUT(inputType());
                    listHocVienDH.get(i).setSoBuoiHoc(inputSession());
                    break;
                }
            }
            if (!isExisted) {
                System.out.printf("id = %d not existed.\n", id);
            } else {
                hocvienDHDao.write(listHocVienDH);
            }
        } else if (chuongTrinh == 2) {
            int size = listHocVienLT.size();
            for (int i = 0; i < size; i++) {
                if (listHocVienLT.get(i).getId() == id) {
                    isExisted = true;
                    listHocVienLT.get(i).setHoTen(inputName());
                    listHocVienLT.get(i).setDiaChi(inputAddress());
                    listHocVienLT.get(i).setLoaiUT(inputType());
                    listHocVienLT.get(i).setSoBuoiHoc(inputSession());
                    break;
                }
            }
            if (!isExisted) {
                System.out.printf("id = %d not existed.\n", id);
            } else {
                hocvienLTDao.write(listHocVienLT);
            }
        }

    }

    public void delete(int id, byte chuongTrinh) {
        if (chuongTrinh == 1) {
            HocVienDH hocvienDH = null;
            int size = listHocVienDH.size();
            for (int i = 0; i < size; i++) {
                if (listHocVienDH.get(i).getId() == id) {
                    hocvienDH = listHocVienDH.get(i);
                    break;
                }
            }
            if (hocvienDH != null) {
                listHocVienDH.remove(hocvienDH);
                hocvienDHDao.write(listHocVienDH);
            } else {
                System.out.printf("id = %d not existed.\n", id);
            }
        } else if (chuongTrinh == 2) {
            HocVienLT hocvienLT = null;
            int size = listHocVienLT.size();
            for (int i = 0; i < size; i++) {
                if (listHocVienLT.get(i).getId() == id) {
                    hocvienLT = listHocVienLT.get(i);
                    break;
                }
            }
            if (hocvienLT != null) {
                listHocVienLT.remove(hocvienLT);
                hocvienLTDao.write(listHocVienLT);
            } else {
                System.out.printf("id = %d not existed.\n", id);
            }
        }
    }
    
    public void show()
    {
        System.out.println("==============Học viên Đồ Hoạ==============");
        System.out.println(String.format("%5s %15s %15s %5s %10s %5s %10s %10s",
                "ID", "Họ tên", "Địa chỉ", "Loại UT", "CTrình", "Số buổi", "Đơn giá", "Học phí"));
        listHocVienDH.forEach(hocvienDH -> {
            System.out.println(hocvienDH.toString());
        });
        System.out.println("==============Học viên Lập Trình==============");
        System.out.println(String.format("%5s %15s %15s %5s %10s %5s %10s %10s",
                "ID", "Họ tên", "Địa chỉ", "Loại UT", "CTrình", "Số buổi", "Đơn giá", "Học phí"));
        listHocVienLT.forEach(hocvienLT -> {
            System.out.println(hocvienLT.toString());
        });
    }
    
    public int inputId() {
        System.out.print("Nhập mã học viên: ");
        while (true) {
            try {
                int id = Integer.parseInt((scanner.nextLine()));
                return id;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }
    
    private String inputName() {
        System.out.print("Nhập họ tên học viên: ");
        return scanner.nextLine();
    }

    private String inputAddress() {
        System.out.print("Nhập địa chỉ học viên: ");
        return scanner.nextLine();
    }
    
    private byte inputType() {
        System.out.print("Nhập loại ưu tiên (0, 1 hoặc 2): ");
        while (true) {
            try {
                byte type = Byte.parseByte(scanner.nextLine());
                if (type != 0 && type != 1 && type != 2) {
                    throw new NumberFormatException();
                }
                return type;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }
    
    public byte inputStudy() {
        System.out.print("Nhập chương trình học (1. Đồ hoạ, 2. Lập trình): ");
        while (true) {
            try {
                byte study = Byte.parseByte(scanner.nextLine());
                if (study != 1 && study != 2) {
                    throw new NumberFormatException();
                }
                return study;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }
    
    private int inputSession() {
        System.out.print("Nhập số buổi học: ");
        while (true) {
            try {
                int session = Integer.parseInt(scanner.nextLine());
                if (session < 0) {
                    throw new NumberFormatException();
                }
                return session;
            } catch (NumberFormatException ex) {
                System.out.print("invalid! Input again: ");
            }
        }
    }
    
}
