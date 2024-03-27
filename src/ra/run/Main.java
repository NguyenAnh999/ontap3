package ra.run;

import java.util.Scanner;

import static ra.run.CategoryManage.CategoryMenu;
import static ra.run.ProductManage.ProductMenu;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("******************SHOP MENU******************* \n" +
                    "1. Quản lý danh mục sản phẩm \n" +
                    "2. Quản lý sản phẩm \n" +
                    "3. Thoát");

            System.out.println("Nhập lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice) {
                case 1:
                    CategoryMenu();
                    break;
                case 2:
                    ProductMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("lựa trọn không đúng");
            }
        }
    }
}
