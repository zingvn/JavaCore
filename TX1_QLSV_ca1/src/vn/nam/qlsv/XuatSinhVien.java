/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.nam.qlsv;

import java.util.Scanner;

/**
 *
 * @author duato
 */
public class XuatSinhVien {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        SinhVienController svController = new SinhVienController();
        int id;
        byte program;
        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    String inputChoice = null;
                    do {                        
                        svController.add();
                        System.out.println("!!Bạn có muốn nhập tiếp (Y/N)?");
                        inputChoice = scanner.nextLine();
                    } while (inputChoice.toLowerCase().equals("n") != true);
                    break;
                case "2":
                    svController.show();
                    break;
                case "3":
                    svController.listSvHasMaxGPA();
                    break;
                case "4":
                    //svController.sortStudentByGPA();
                    break;
                case "5":
                    //svController.sortStudentByName();
                    break;
                case "6":
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
        System.out.println("1. Thêm sinh viên.");
        System.out.println("2. Danh sách sinh viên.");
        System.out.println("3. Sinh viên có điểm trung bình cao nhất.");
        System.out.println("0. Thoát.");
        System.out.println("---------------------------");
        System.out.print("Bạn chọn? ");
    }
}
