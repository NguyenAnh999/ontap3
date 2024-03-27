package ra.business;

import ra.entity.Categories;

import java.util.Scanner;

public class CategoriesBusiness {
    public static int lengthOfCategory=5;
    public static Categories[] categoriesArr = new Categories[100];
    public static Scanner sc = new Scanner(System.in);

    static {
        categoriesArr[0] = new Categories(1,"nước lọc","nước",true);
        categoriesArr[1] = new Categories(2,"nước ngọt","nước",true);
        categoriesArr[2] = new Categories(3,"nước chè","nước",true);
        categoriesArr[3] = new Categories(4,"cà phê","nước",true);
        categoriesArr[4] = new Categories(5,"bia","nước",true);
    }
    public static void categoriesAdd() {
        System.out.println("mời bạn nhập vào số danh mục muốn tạo");
        int productQuantity= isNumber();
        for (int i = lengthOfCategory; i < productQuantity; i++) {
            Categories categories = new Categories();
            categories.inputData(sc,categoriesArr,true);
            categoriesArr[lengthOfCategory]=categories;
            lengthOfCategory++;
        }
    }

    public static void outputData() {
        for (int i = 0; i < lengthOfCategory; i++) {
            if (categoriesArr[i]==null){break;}
            categoriesArr[i].displayData();
            System.out.println();
        }
    }

    public static void updateCategory(Scanner sc) {
        while (true){
            System.out.println("mời bạn nhập vào id muốn sửa");
            int CategoryIdUpdate =  isNumber();
            int index = getIndexByID(CategoryIdUpdate);
            if (index!=-1){
                categoriesArr[index].inputData(sc,categoriesArr,false);
                return;
            }else {
                System.out.println("id bạn nhập vào chưa đúng mời nhập lại");
            }
        }

    }
    public static void updateCategoryStatus(Scanner sc) {
        while (true){
            System.out.println("mời bạn nhập vào id muốn sửa");
            int CategoryIdUpdate =  isNumber();
            int index = getIndexByID(CategoryIdUpdate);
            if (index!=-1){
                System.out.println("mời bạn nhạp vào treang thái mới(true=hoạt dộng,false=không hoạt dộng)");
                boolean status= Boolean.parseBoolean(sc.nextLine());
                categoriesArr[index].setCatalogStatus(status);
                return;
            }else {
                System.out.println("id bạn nhập vào chưa đúng mời nhập lại");
            }
        }

    }

    public static int getIndexByID(int id) {
        for (int i = 0; i < categoriesArr.length; i++) {
            if (categoriesArr[i].getCatalogId()==id){
                return i;
            }
        }
        return -1;
    }
    public  static void deleteCategory(){
        while (true){
            System.out.println("mời bạn nhập vào id muốn xóa");
            int CategoryIdDelete =  isNumber();
            int index = getIndexByID(CategoryIdDelete);
            if (index!=-1){
                categoriesArr[index]=null;

                for (int i = index; i < lengthOfCategory; i++) {
                    categoriesArr[index]=categoriesArr[index+1];
                }
                categoriesArr[lengthOfCategory]=null;
                lengthOfCategory--;
                return;
            }else {
                System.out.println("id bạn nhập vào chưa đúng mời nhập lại");
            }
        }

    }
    static int isNumber() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("hãy nhập vào số:");
            try {
                int quantity = Integer.parseInt(sc.nextLine());
                if (quantity > 0) {
                    return quantity;
                } else {
                    System.out.println("số bạn nhập phai lớn hơn 0");
                }
            } catch (Exception e) {
                System.out.println("bạn phải nhập vào 1 số");
            }
        }
    }

}
