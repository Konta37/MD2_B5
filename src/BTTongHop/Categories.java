package BTTongHop;

import java.util.Scanner;

public class Categories {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;
    private boolean categoryStatus;

    public Categories(){}
    public Categories(String categoryId, String categoryName, String categoryDescription, boolean categoryStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.categoryStatus = categoryStatus;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public boolean isCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    public void inputData(Scanner sc, int index){

        //id auto S001
//        this.categoryId = "S"+String.valueOf ((index));
        this.categoryId = String.format("%03d",index);
        //
        this.categoryName = inputCategoryName(sc);
        this.categoryDescription = inputCategoryDescription(sc);
        this.categoryStatus = inputCategoryStatus(sc);
    }
    public void displayData(){
        System.out.printf("id: S%s     status:%s\nName: %s\nDescription: %s\n", categoryId, categoryStatus,categoryName,categoryDescription);
    }

    //validate name
    public String inputCategoryName(Scanner sc){
        System.out.println("Enter category name: ");
        do {
            String categoryName = sc.nextLine();
            if(categoryName.length()>=5 && categoryName.length()<=50){
                boolean isExit = false;
                for(int i =0; i< Main.currentCategoryIndex; i++){
                    if(Main.categoriesArray[i].getCategoryName().equals(categoryName)){
                        isExit = true;
                        break;
                    }
                }
                if(isExit){
                    System.out.println("Category already exists!");
                }else {
                    return categoryName;
                }
            } else {
                System.out.println("Invalid category name. Name must be larger than 5 characters!");
            }
        }while(true);
    }
    //validate description
    public String inputCategoryDescription(Scanner sc){
        System.out.println("Enter category description: ");
        do {
            String categoryDescription = sc.nextLine();
            if(categoryDescription.length()>=5){
                return categoryDescription;
            }else {
                System.out.println("Invalid category description. Description must be larger than 5 characters!");
            }
        }while(true);
    }
    public boolean inputCategoryStatus(Scanner sc){
        System.out.println("Enter category status (true/false): ");
        do {
            String status = sc.nextLine();
            if(status.equals("true") || status.equals("false")){
                return Boolean.parseBoolean(status);
            }else {
                System.out.println("Invalid category status. Status must be either 'true' or 'false'");
            }
        }while(true);
    }
}
