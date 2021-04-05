/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlhv;

import java.util.Scanner;
import vn.nam.qlhv.controller.HocVienController;

/**
 *
 * @author duato
 */
public class MainView {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        HocVienController hocvienController = new HocVienController();
        int id;
        byte program;
        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    hocvienController.add();
                    break;
                case "2":
                    id = hocvienController.inputId();
                    program = hocvienController.inputStudy();
                    hocvienController.edit(id, program);
                    break;
                case "3":
                    id = hocvienController.inputId();
                    program = hocvienController.inputStudy();
                    hocvienController.delete(id, program);
                    break;
                case "4":
                    //hocvienController.sortStudentByGPA();
                    break;
                case "5":
                    //hocvienController.sortStudentByName();
                    break;
                case "6":
                    hocvienController.show();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }

    }

    public static void showMenu() {
        System.out.println("-----------menu------------");
        System.out.println("1. Thêm học viên.");
        System.out.println("2. Sửa học viên.");
        System.out.println("3. Xoá học viên.");
        System.out.println("4. Sắp xếp học viên theo tên.");
        System.out.println("5. Sắp xếp học viên theo học phí.");
        System.out.println("6. Hiển thị học viên.");
        System.out.println("0. Thoát.");
        System.out.println("---------------------------");
        System.out.print("Bạn chọn? ");
    }
}
