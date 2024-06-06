package BTTongHop;

import java.util.Scanner;

public class Main {
    public static Categories[] categoriesArray = new Categories[100];
    public static int currentCategoryIndex = 0;
    public static Product[] productArray = new Product[100];
    public static int currentProductIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mainMenu(sc);
    }
    public static void mainMenu(Scanner sc) {
        do {
            System.out.println("==========MENU==========");
            System.out.println("1. Category management");
            System.out.println("2. Product management");
            System.out.println("3. Exit");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    menuCategories(sc);
                    break;
                case 2:
                    menuProductManagement(sc);
                    break;
                case 3:
                    System.exit(0);
            }
        } while (true);
    }

    public static void menuCategories(Scanner sc) {
        do {
            System.out.println("==========CATEGORY MANAGEMENT==========");
            System.out.println("1. Add Category");
            System.out.println("2. Show Category");
            System.out.println("3. Edit Category");
            System.out.println("4. Delete Category");
            System.out.println("5. Edit Status Category");
            System.out.println("6. Exit Category management");
            int choice1 = Integer.parseInt(sc.nextLine());
            switch (choice1) {
                case 1:
                    //add
                    inputListCategory(sc);
                    break;
                case 2:
                    displayCategory(sc);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    mainMenu(sc);
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }

    //add category
    public static void inputListCategory(Scanner sc) {
        System.out.println("Enter number of Categories");
        int numberOfCategories = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfCategories; i++) {
            categoriesArray[currentCategoryIndex] = new Categories();
            categoriesArray[currentCategoryIndex].inputData(sc, currentCategoryIndex);
            currentCategoryIndex++;
        }
    }

    public static void displayCategory(Scanner sc) {
        for (int i = 0; i < currentCategoryIndex; i++) {
            categoriesArray[i].displayData();
        }
    }

    public static void updateCategory(Scanner sc) {
        System.out.println("Enter Category ID (example: S00x)");
        String categoryId = sc.nextLine();
        int indexUpdate = getIndexById(categoryId);
        if (indexUpdate != -1) {
            boolean isExit = true;
            do {
                System.out.println("1. Update Category Name");
                System.out.println("2. Update Category Description");
                System.out.println("3. Update Category Status");
                System.out.println("4. Exit");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        categoriesArray[indexUpdate].setCategoryName(sc.nextLine());
                        break;
                    case 2:
                        categoriesArray[indexUpdate].setCategoryDescription(sc.nextLine());
                        break;
                    case 3:
                        categoriesArray[indexUpdate].setCategoryStatus(Boolean.parseBoolean(sc.nextLine()));
                        break;
                    default:
                        isExit = false;
                }
            } while (isExit);
        } else {
            System.err.println("Invalid Category ID");
        }
    }

    //tim index. ko thay thi =-1
    public static int getIndexById(String categoryId) {
        for (int i = 0; i < currentCategoryIndex; i++) {
            if (categoriesArray[i].getCategoryId().equals(categoryId)) {
                return i;
            }
        }
        return -1;
    }


    //product
    public static void menuProductManagement(Scanner sc) {
        do {
            System.out.println("==========PRODUCT MANAGEMENT==========");
            System.out.println("1. Add Product");
            System.out.println("2. Show Products");
            System.out.println("3. Sort Products With Price");
            System.out.println("4. Edit Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Find Product By Name");
            System.out.println("7. Find Product By Price Spread");
            System.out.println("8. Exit");
            int choice2 = Integer.parseInt(sc.nextLine());
            switch (choice2) {
                case 1:
                    inputListProduct(sc);
                    break;
                case 2:
                    displayProduct(sc);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    mainMenu(sc);
            }
        }while (true);
    }
    public static void inputListProduct(Scanner sc) {
        System.out.println("Enter Number of Product");
        int numberOfProducts = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfProducts; i++) {
            productArray[currentProductIndex] = new Product();
            productArray[currentProductIndex].inputData(sc);
            currentProductIndex++;
        }
    }
    public static void displayProduct(Scanner sc){
        for (int i = 0; i < currentProductIndex; i++) {
            productArray[i].displayData();
        }
    }

    public static void UpdateCategory(Scanner sc) {
        System.out.println("Enter Category ID (example: S00x)");
    }
}
