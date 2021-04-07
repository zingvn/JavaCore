/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.nam.qlsv;

import java.util.Scanner;

/**
 *
 * @author IT Supporter
 */
public class Main {
    public static Scanner scanner = new Scanner(System.in, "UTF-8");

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
                    svController.showKetQuaHocTap();
                    break;
                case "4":
                    svController.sortStudentByName();
                    break;
                case "5":
                    svController.listSvHasMaxMinGPA();
                    break;
                case "6":
                    svController.xoaSinhVienTruot();
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
        System.out.println("3. Kết quả học tập.");
        System.out.println("4. Sắp xếp danh sách theo tên.");
        System.out.println("5. Sinh viên có điểm TB cao nhất/thấp nhất.");
        System.out.println("6. Xóa sinh viên trượt, hiển thị sinh viên đỗ.");
        System.out.println("---------------------------");
        System.out.print("Bạn chọn? ");
    }
}
