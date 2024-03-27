package ra.run;

import java.util.Scanner;

import static ra.business.CategoriesBusiness.sc;
import static ra.business.ProductBusiness.*;

public class ProductManage {
    public static void ProductMenu() {
        while (true) {
            System.out.println("*******************PRODUCT MANAGEMENT***************** \n" +
                    "1. Nhập thông tin các sản phẩm \n" +
                    "2. Hiển thị thông tin các sản phẩm \n" +
                    "3. Sắp xếp các sản phẩm theo giá \n" +
                    "4. Cập nhật thông tin sản phẩm theo mã sản phẩm \n" +
                    "5. Xóa sản phẩm theo mã sản phẩm \n" +
                    "6. Tìm kiếm các sản phẩm theo tên sản phẩm \n" +
                    "7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn \n" +
                    "phím) \n" +
                    "8. Thoát ");

            System.out.println("Nhập lựa chọn");
            byte choice = new Scanner(System.in).nextByte();
            switch (choice) {
                case 1:
                    productAdd();
                    break;
                case 2:
                    productOutputData();
                    break;
                case 3:
                    sortByPrice();
                    break;
                case 4:
                    updateProduct(sc);
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    searchByName();
                    break;
                case 7:
                    searchByPrice();
                    break;
                case 8:
                    return;

                default:
                    System.err.println("Nhap lua chon ko chinh xác");
            }
        }
}}
