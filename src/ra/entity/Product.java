package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;

    private String productName;

    private float price;

    private String description;
    private Date created;
    private int catalogId;
    private int productStatus;

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.created = created;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, Categories[] arrCategories,boolean isAdd) {
        if (isAdd){
            this.productId = getInputProductId(arrProduct);
        }
        this.productName = getInputProductName(arrProduct);
        this.price=getPriceProduct();
        System.out.println("mời bạn nhập mô tả sản phẩm");
        this.description=scanner.nextLine();
        this.created=getDateProduct();
        this.catalogId=getCategoriId(arrCategories);
        this.productStatus=getInputProductStatus();

    }
    public void displayData() {
        System.out.printf("ID: %-6s | Tên sản phẩm : %-10s | Giá sản phẩm : %-10f | Mô tả sản phẩm : %s" +
                " | Ngày nhập sản phẩm : %s | Mã danh mục : %-5s | Trạng thái : %s",this.productId,this.productName,
                this.price,this.description,this.created.toString(),this.catalogId,this.productStatus==0?"đang bán":(this.productStatus==1?"hết hàng":"không bán"));
    }
    private  int getInputProductStatus(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("mời bạn chọn trạng thái");
            System.out.println("0: Đang bán , 1: Hết hàng , 2: Không bán");
            int choice = sc.nextInt();
            if(choice>=0&&choice<=3){
                return choice;
            }else {
                System.out.println("lựa chọn của bạn chưa đúng mời chọn lại");
            }
        }
    }
    private int getCategoriId(Categories[] arrCategories){
        Scanner sc = new Scanner(System.in);

      while (true){
          int count = 1;
          for (Categories arrCategory : arrCategories) {
              System.out.println("danh mục thứ : "+count);
              arrCategory.displayData();
              count++;
          }
          System.out.println("mời bạn nhập vào số thứ tự của danh mục muốn chọn");
          int choice=sc.nextInt();
          if (choice>count){
              System.out.println("bạn chọn chưa đúng mời chọn lại");
          }else {return arrCategories[count].getCatalogId();}
      }
    }
    private Date getDateProduct(){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        while (true){
            System.out.println("mời bạn nhập vào ngày nhập sản phẩm");
            String geInputDateProduct = sc.nextLine();
            try {
               return sdf.parse(geInputDateProduct);
            } catch (ParseException e) {
                System.out.println("bạn nhập ko đúng định dạng dd/MM/yyyy");
            }
        }


    }
    private float getPriceProduct(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("mời bạn nhập vào giá sản phẩm");
            float princeProduct = sc.nextFloat();
            if (princeProduct>0){
                return princeProduct;
            }else {
                System.out.println("giá sản phẩm cần phải lơn hơn 0");
            }
        }
    }

    private String getInputProductId(Product[] arrProduct) {
        final String regex = "^[C|A|S]\\w{3}$";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào mã sản phẩm");
            String productIdInput = sc.nextLine();
            if (productIdInput.matches(regex)) {
                boolean flag = true;
                // đúng định dạng -> kiểm tra trùng lặp

                for (Product product : arrProduct) {
                    if (product != null && product.getProductId().equals(productIdInput)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return productIdInput;
                } else {
                    System.err.println("Id đã tồn tại, vui long nhập giá trị khác");
                }
            } else {
                System.err.println("Không đúng định dạng (C___)|(S___)|(A___)");
            }
        }
    }

    private String getInputProductName(Product[] arrProduct) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào tên sản phẩm");
            String getInputProductName = sc.nextLine();
            if (getInputProductName.length() > 10 && getInputProductName.length() < 50) {
                // đúng định dạng -> kiểm tra trùng lặp
                boolean flag = true;
                for (Product product : arrProduct) {
                    if (product.getProductName().equals(getInputProductName)) {
                        flag = false;
                    }
                }
                if (flag) {
                    return getInputProductName;
                } else {
                    System.out.println("tên đã được sử dụng");
                }
            } else {
                System.err.println("lớn hơn 10 và không quá 50 kí tự ");
            }
        }
    }
}
