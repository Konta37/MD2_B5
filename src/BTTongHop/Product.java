package BTTongHop;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private String description;
    private String created;
    private String catagoryId;

    private int status;
    public Product(){}

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCatagoryId() {
        return catagoryId;
    }

    public void setCatagoryId(String catagoryId) {
        this.catagoryId = catagoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void inputData(Scanner sc){
        this.productId = inputProductId(sc);
        this.productName = inputProductName(sc);
        this.price = inputProductPrice(sc);
        this.description = inputProductDescription(sc);
        this.created = inputProductCreated(sc);
        this.catagoryId = inputCategoryId(sc);
        this.status = inputStatus(sc);
    }

    public String inputProductId(Scanner sc){
        System.out.println("Enter product ID (Cxx, Sxx, Axx): ");
        do{
            String productId = sc.nextLine();
            if(productId.charAt(0) == 'C' || productId.charAt(0) == 'S' || productId.charAt(0) == 'A'){
                boolean isExist = false;
                for(int i=1;i<Main.currentProductIndex;i++){
                    if(Main.productArray[i].getProductId().equals(productId)){
                        System.out.println("Product ID already exists!");
                        isExist = true;
                    }
                }
                if(isExist){
                    //Da ton tai
                    System.out.println("Product ID already exists!");
                }else {
                    return productId;
                }

            }else {
                System.out.println("Invalid product ID. First character is 'C' or 'S' or 'A'.");
            }
        }while(true);
    }

    public String inputProductName(Scanner sc){
        System.out.print("Enter product name (Sinh to ngon): ");
        do {
            String productName = sc.nextLine();
            if(productName.length()>=10 && productName.length()<=50){
                boolean isExist = false;
                for(int i=0; i<Main.currentProductIndex; i++){
                    if (Main.productArray[i].getProductName().equals(productName)){
                        isExist = true;
                        break;
                    }
                }

                if(isExist){
                    //da ton tai
                    System.out.println("Product name already exists!");
                }else {
                    return productName;
                }
            }else {
                System.err.println("Invalid product name! Name must larger than 10 characters and smaller than 50 characters!");
            }
        }while(true);
    }
    public double inputProductPrice(Scanner sc){
        System.out.print("Enter product price (200000): ");
        do {
            double price = Double.parseDouble(sc.nextLine());
            if(price >=0){

                return price;
            }else {
                System.err.println("Invalid product price! Price must greater than 0");
            }
        }while(true);
    }
    public String inputProductDescription(Scanner sc){
        System.out.print("Enter product description: ");
        String productDescription = sc.nextLine();
        return productDescription;
//        do {
//            String productDescription = sc.nextLine();
//            if(productDescription.length()>=10 && productDescription.length()<=50){
//
//            }else{
//                System.err.println("Invaild product description! Description must larger than 10 characters and smaller than 50 characters!");
//            }
//        }while(true);
    }
    public String inputProductCreated(Scanner sc){
        System.out.print("Enter product created (e.g., 3/3/2020): ");
        do {
            String created = sc.nextLine();

            SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");
            try{
                Date date = inputFormat.parse(created);
                String formattedDate = outputFormat.format(date);
                //System.out.println(formattedDate);
                return formattedDate;
            }catch (ParseException e){
                System.out.println("Invalid product created! Please enter the date M/d/yyyy");
            }
        }while(true);
    }
    public String inputCategoryId(Scanner sc){
        System.out.print("Enter category ID (S00x): ");
        do {
            Categories category = new Categories();
            String categoryId = sc.nextLine();
            if(categoryId.length()==4){
                boolean isExist = false;
                for(int i = 0; i< Main.currentCategoryIndex; i++){
                    if(Main.categoriesArray[i].getCategoryId().equals(categoryId)){
                        isExist = true;
                        
                        break;
                    }
                }
                if(isExist){
                    System.err.println("Category ID already exists!");
                }else {
                    return categoryId;
                }
            }else {
                System.err.println("Invalid category ID! Please enter a valid category ID (S00x)");
            }
        }while(true);
    }
    public int inputStatus(Scanner sc){
        System.out.print("Enter product status (0:Still has, 1:Out of stock, 2:Not for out): ");
        do {
            String status = sc.nextLine();
            if(status.equals("0") ||status.equals("1") || status.equals("2")){
                return Integer.parseInt(status);
            }else {
                System.err.println("Invalid product status! Please enter a valid product status");
            }
        }while(true);
    }
    //show list product
    public void displayData(){
        DecimalFormat formatter = new DecimalFormat("###,###,###");

        System.out.printf("product id: %s     Name: %s\nPrice: %s     Date created: %s\nDescription: \n%s\nCategoryID: %s     Product status: %s\n",productId,productName,(formatter.format(price)+" VNĐ"),created,description,catagoryId,status);
    }
}
