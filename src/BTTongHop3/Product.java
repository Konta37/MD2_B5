package BTTongHop3;

import java.util.Scanner;

public class Product {
    private String productId; //4Character, no re
    private String productName;
    private float importPrice;
    private float exportPrice; //higher than import 30%
    private float profit; //profit = export - import
    private int quantity;
    private String productDescription;
    private boolean productStatus;

    public Product(){}

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

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public boolean getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner sc){
        this.productId = inputProductId(sc);
        this.productName = inputProductName(sc);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = inputExportPrice(sc);
//        this.profit = this.exportPrice - this.importPrice;
        this.quantity = inputQuantity(sc);
        this.productDescription = inputProductDescription(sc);
        this.productStatus = inputProductStatus(sc);
    }

    public void displayData(){
        System.out.println("==============Product Information==============");
        System.out.printf("Product ID: %s\nName: %s\nImport Price: %f     Export Price: %f\nQuantity: %d     Profit: %f\nDescription: %s\nStatus: %s\n",
                productId, productName, importPrice, exportPrice, quantity, profit, productDescription, productStatus);
    }

    public String inputProductId(Scanner sc){
        System.out.println("Enter product ID: ");
        do {
            String productId = sc.nextLine();
            if(productId.length() == 4){
                return productId;
            }else {
                System.err.println("Invalid product ID. Must have 4 characters! Please try again.");
            }
        }while (true);
    }
    public String inputProductName(Scanner sc){
        System.out.println("Enter product name: ");
        do {
            String productName = sc.nextLine();
            if(productName.length() >= 6 && productName.length() <= 50){
                return productName;
            }else {
                System.err.println("Invaild product name. Must between 6 to 50 characters. Please try again.");
            }
        }while (true);
    }
    public float inputImportPrice(Scanner sc){
        System.out.println("Enter product import price: ");
        do {
            float importPrice = Float.parseFloat(sc.nextLine());
            if(importPrice > 0){
                return importPrice;
            }else {
                System.err.println("Invalid product import price. Please try again.");
            }
        }while (true);
    }

    public float inputExportPrice(Scanner sc){
        System.out.println("Enter product export price: ");
        do {
            float exportPrice = Float.parseFloat(sc.nextLine());
            if(exportPrice > this.importPrice +  this.importPrice * 0.3){
                return exportPrice;
            }else {
                System.err.println("Invalid product export price. More expensive than importPrice Please try again.");
            }
        }while (true);
    }

    public int inputQuantity(Scanner sc){
        System.out.println("Enter product quantity: ");
        do {
            int quantity = Integer.parseInt(sc.nextLine());
            if(quantity > 0){
                return quantity;
            } else {
                System.err.println("Invalid product quantity. Please try again.");
            }
        }while (true);
    }

    public String inputProductDescription(Scanner sc){
        System.out.println("Enter product description: ");
        return sc.nextLine();
    }

    public boolean inputProductStatus(Scanner sc){
        System.out.println("Enter product status: ");
        do {
            String productStatus = sc.nextLine();
            if(productStatus.equalsIgnoreCase("true") || productStatus.equalsIgnoreCase("false")){
                return Boolean.parseBoolean(productStatus);
            }else {
                System.err.println("Invalid product status. Please try again.");
            }
        }while (true);
    }
}
