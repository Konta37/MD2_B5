package BTTongHop2.B1;

import BTTongHop.Categories;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BookImp {
    public static Book[] bookArray = new Book[100];
    public static int currentBookIndex = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("==========MENU==========");
            System.out.println("1. Add book");
            System.out.println("2. Caculate interest");
            System.out.println("3. Show books");
            System.out.println("4. Sort by price from low to high");
            System.out.println("5. Sort by interest from low to high");
            System.out.println("6. Search book by name");
            System.out.println("7. Sort book by year");
            System.out.println("8. Count book by author");
            System.out.println("9. Exit");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inputListBooks(sc);
                    break;
                case 2:
                    caculateInterest();
                    break;
                case 3:
                    displayBooks(sc);
                    break;
                case 4:
                    sortByPriceLH();
                    break;
                case 5:
                    sortByInterest();
                    break;
                case 6:
                    searchBookByName(sc);
                    break;
                case 7:
                    sortByYear(sc);
                    break;
                case 8:
                    sortByAuthor(sc);
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        } while (true);
    }

    //add book
    public static void inputListBooks(Scanner sc) {
        System.out.println("Enter the number of books");
        int numberOfBooks = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberOfBooks; i++) {
            bookArray[currentBookIndex] = new Book();
            bookArray[currentBookIndex].inputData(sc);
            currentBookIndex++;
        }
    }

    //show books list
    public static void displayBooks(Scanner sc) {
        for (int i = 0; i < currentBookIndex; i++) {
            bookArray[i].displayData();
        }
        if (currentBookIndex == 0) {
            System.out.println("No books found");
        }
    }

    public static void caculateInterest() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        for (int i = 0; i < currentBookIndex; i++) {
            System.out.printf("Book Id: %s     interest: %s\n", bookArray[i].getBookId(), formatter.format(bookArray[i].getInterest()) + " VNĐ");
        }
        if (currentBookIndex == 0) {
            System.out.println("No books found");
        }
    }

    public static void sortByPriceLH() {
        for (int i = 0; i < currentBookIndex; i++) {
            for (int j = i + 1; j < currentBookIndex; j++) {
                if (bookArray[i].getExportPrice() > bookArray[j].getExportPrice()) {
                    Book temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;
                }
            }
        }
        System.out.println("Finished sort products by price (low to high)");
    }

    public static void sortByInterest() {
        for (int i = 0; i < currentBookIndex; i++) {
            for (int j = i + 1; j < currentBookIndex; j++) {
                if (bookArray[i].getInterest() < bookArray[j].getInterest()) {
                    Book temp = bookArray[i];
                    bookArray[i] = bookArray[j];
                    bookArray[j] = temp;
                }
            }
        }
    }

    public static void searchBookByName(Scanner sc) {
        System.out.println("Enter the book name");
        String bookName = sc.nextLine().toLowerCase();
        int count=0;
        for (int i = 0; i < currentBookIndex; i++) {
            if (bookArray[i].getBookName().toLowerCase().contains(bookName)) {
                bookArray[i].displayData();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No book found");
        }
    }
    public static void sortByYear(Scanner sc) {
        System.out.println("Enter the year");
        String year = sc.nextLine();
        int count =0;
        for (int i = 0; i < currentBookIndex; i++) {
            if(bookArray[i].getYear().equals(year)) {
                bookArray[i].displayData();
                count++;
            }
        }
        if(count==0){
            System.out.println("No book found");
        }
    }
    public static void sortByAuthor(Scanner sc){
        System.out.println("Enter the Author");
        String author = sc.nextLine().toLowerCase();
        int count =0;
        for (int i = 0; i < currentBookIndex; i++) {
            //find if name of author have that character
            if(bookArray[i].getAuthor().toLowerCase().contains(author)) {
                bookArray[i].displayData();
                count++;
            }
        }
        if(count==0){
            System.out.println("No book found");
        }
    }
}
