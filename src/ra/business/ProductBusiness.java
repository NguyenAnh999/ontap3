package ra.business;

import ra.entity.Categories;
import ra.entity.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static ra.business.CategoriesBusiness.*;

public class ProductBusiness {


    public static int lengthOfProduct = 6;
    public static Product[] productArr = new Product[100];

    static {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = df.parse("12/12/2022");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        productArr[0] = new Product("C123","cà phê",120,"ca phê chồn",date,3,0);
        productArr[2] = new Product("C124","cà phê 2",140,"ca phê mèo",date,3,0);
        productArr[3] = new Product("C125","cà phê 4",110,"ca phê chó",date,3,0);
        productArr[4] = new Product("C126","cà phê 6",105,"ca phê gà",date,3,0);
        productArr[5] = new Product("C127","cà phê 8",160,"ca phê voi",date,3,0);
        productArr[1] = new Product("C129","cà phê 007",160,"ca phê rùa",date,3,0);

    }

    public static void productAdd() {
        System.out.println("mời bạn nhập vào số sản phẩm muốn tạo");
        int productQuantity = isNumber();
        for (int i = lengthOfProduct; i < productQuantity; i++) {
            Product product = new Product();
            product.inputData(sc, productArr, categoriesArr, true);
            productArr[lengthOfProduct] = product;
            lengthOfProduct++;
        }
    }

    public static void productOutputData() {
        for (int i = 0; i < lengthOfProduct; i++) {
            productArr[i].displayData();
            System.out.println();
        }
    }

    public static void updateProduct(Scanner sc) {
        while (true) {
            System.out.println("mời bạn nhập vào id muốn sửa");
            String CategoryIdUpdate = sc.nextLine();
            int index = getIndexByID(CategoryIdUpdate);
            if (index != -1) {
                productArr[index].inputData(sc, productArr, categoriesArr, false);
                return;
            } else {
                System.out.println("id bạn nhập vào chưa đúng mời nhập lại");
            }
        }

    }

    public static int getIndexByID(String id) {
        for (int i = 0; i < lengthOfProduct; i++) {
            if (productArr[i].getProductId().equals(id) ) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteProduct() {
        while (true) {
            System.out.println("mời bạn nhập vào id muốn xóa");
            String CategoryIdDelete = sc.nextLine();
            int index = getIndexByID(CategoryIdDelete);
            if (index != -1) {
                for (int i = index; i < lengthOfProduct-2; i++) {
                    productArr[i] = productArr[i+1];
                }
                productArr[lengthOfProduct-1] = null;
                lengthOfProduct--;
                return;
            } else {
                System.out.println("id bạn nhập vào chưa đúng mời nhập lại");
            }
        }
    }

    public static void sortByPrice() {
        Product temp;
        for (int i = 0; i < lengthOfProduct; i++) {
            for (int j = 0; j < lengthOfProduct; j++) {
                if (productArr[i].getPrice() > productArr[j].getPrice()) {
                    temp = productArr[i];
                    productArr[i] = productArr[j];
                    productArr[j] = temp;
                }
            }
        }
    }

    public static void searchByName() {
        System.out.println("mờ bạn nhập vào tên sản phẩm muốn tìm");
        String productName = sc.nextLine();
        for (int i = 0; i < lengthOfProduct; i++) {
            if (productName.contains(productArr[i].getProductName())) {
                productArr[i].displayData();
            }
        }

    }

    public static void searchByPrice() {
        System.out.println("mờ bạn nhập vào tên sản khoảng giá muốn tìm");
        System.out.println("bắt đầu từ");
        int productPriceFrom = isNumber();
        System.out.println("đến");
        int productPriceTo = isNumber();

        for (int i = 0; i < lengthOfProduct; i++) {
            if (productPriceFrom >= productArr[i].getPrice() && productPriceTo <= productArr[i].getPrice()) {
                productArr[i].displayData();
            }
        }

    }
}
