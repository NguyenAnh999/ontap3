package ra.entity;

import java.util.List;
import java.util.Scanner;

public class Categories {
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories,boolean isAdd) {
        if (isAdd){
            this.catalogId = getIdCategori(arrCategories);
        }
        this.catalogName = getInputCategoliName(arrCategories);

        System.out.println("mời bạn nhập vào mô tả");
        this.descriptions = scanner.nextLine();

        System.out.println("mời bạn nhập vào trạng thái(true=mở/false=khóa)");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    public void displayData() {
        System.out.printf("ID danh mục: %-5d | Tên danh mục %-10s | Mô tả danh mục %-20S | Trạng thái %-5s\n",
                this.catalogId, this.catalogName,this.descriptions,this.catalogStatus?"Mở":"khóa");
    }

    private int getIdCategori(Categories[] arrCategories) {
        int max = 0;
        for (Categories arrCategory : arrCategories) {
            if (arrCategory != null && arrCategory.getCatalogId() > max) {
                max = arrCategory.getCatalogId();
            }
        }
        return max+1;
    }

    private String getInputCategoliName(Categories[] arrCategories) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào tên danh muc");
            String getInputCategoliName = sc.nextLine();
            if (!getInputCategoliName.isBlank() && getInputCategoliName.length() < 50) {
                // đúng định dạng -> kiểm tra trùng lặp
                boolean flag = true;
                for (Categories categories : arrCategories) {
                    if(categories!=null){
                    if (categories.getCatalogName().equals(getInputCategoliName)) {
                        flag = false;
                        break;
                    }
                    }
                }
                if (flag) {
                    return getInputCategoliName;
                } else {
                    System.out.println("teen cuar banj ddax dduowcj suwr dungj");
                }
            } else {
                System.err.println("Không được để trống,hoặc quá 50 kí tự ");
            }
        }
    }

}
