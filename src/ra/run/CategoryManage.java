package ra.run;

import ra.business.CategoriesBusiness;

import java.util.Scanner;

import static ra.business.CategoriesBusiness.sc;

public class CategoryManage {
    public static void  CategoryMenu() {
        while (true) {
            System.out.println("********************CATEGORIES MENU*********** \n" +
                    "1. Nhập thông tin các danh mục \n" +
                    "2. Hiển thị thông tin các danh mục \n" +
                    "3. Cập nhật thông tin danh mục \n" +
                    "4. Xóa danh mục \n" +
                    "5. Cập nhật trạng thái danh mục \n" +
                    "6. Thoát ");

            System.out.println("Nhập lựa chọn");
            byte choice = Byte.parseByte(sc.nextLine());
            switch (choice) {
                case 1:
                    CategoriesBusiness.categoriesAdd();
                    break;
                case 2:
                    CategoriesBusiness.outputData();
                    break;
                case 3:
                    CategoriesBusiness.updateCategory(sc);
                    break;
                case 4:
                    CategoriesBusiness.deleteCategory();
                    break;
                case 5:
                    return;
                default:

            }
        }
    }
}
