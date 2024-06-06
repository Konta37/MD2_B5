package BTTongHop2.B1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private float importPrice; //Gia nhap
    private float exportPrice; //>30% gia nhap
    private String author;
    private float interest; //Loi nhuan
    private String year;

    public Book() {
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public float getInterest() {
        return interest;
    }

    //input data
    public void inputData(Scanner sc) {
        this.bookId = inputBookId(sc);
        this.bookName = inputBookName(sc);
        this.importPrice = inputImportPrice(sc);
        this.exportPrice = inputExportPrice(sc);
        this.interest = this.exportPrice - this.importPrice;
        this.author = inputAuthor(sc);
        this.year = inputYear(sc);
    }

    //show data
    public void displayData() {
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        System.out.printf("Book Id: %s     Name: %s\nImport Price: %s     Export Price: %s\nAuthor: %s     Year: %s\nInterest: %s\n",
                bookId, bookName, formatter.format(importPrice) + " VNĐ", formatter.format(exportPrice) + " VNĐ", author, year, formatter.format(interest) + " VNĐ");
    }

    //validate
    public String inputBookId(Scanner sc) {
        System.out.println("Enter Book ID: ");
        do {
            String bookId = sc.nextLine();
            boolean isExist = false;
            for (int i = 0; i < BookImp.currentBookIndex; i++) {
                if (BookImp.bookArray[i].getBookId().equals(bookId)) {
                    isExist = true;
                }
            }
            if (!isExist) {
                return bookId;
            } else {
                System.out.println("Book ID already exist");
            }
        } while (true);
    }

    public String inputBookName(Scanner sc) {
        System.out.println("Enter Book Name: ");
        do {
            String bookName = sc.nextLine();
            if (bookName.startsWith("B") && bookName.length() >= 4) {
                boolean isExist = false;
                for (int i = 0; i < BookImp.currentBookIndex; i++) {
                    if (BookImp.bookArray[i].getBookName().equals(bookName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    return bookName;
                } else {
                    System.out.println("Book Name already exist");
                }
            } else {
                System.out.println("Invalid Book Name! Must has B on first and length > 4");
            }
        } while (true);
    }

    public float inputImportPrice(Scanner sc) {
        System.out.println("Enter Import Price: ");
        do {
            float importPrice = Float.parseFloat(sc.nextLine());
            if (importPrice > 0) {
                return importPrice;
            } else {
                System.out.println("Import Price not valid! Must enter a number > 0.");
            }
        } while (true);
    }

    public float inputExportPrice(Scanner sc) {
        System.out.println("Enter Export Price (>30% Import Price): ");
        do {
            float exportPrice = Float.parseFloat(sc.nextLine());
            //export > 30% importPrice
            if (exportPrice > this.importPrice - 0.3 * this.importPrice) {
                return exportPrice;
            } else {
                System.out.println("Export Price not valid! Must enter a number > 30% Import Price.");
            }
        } while (true);
    }

    public String inputAuthor(Scanner sc) {
        System.out.println("Enter Author: ");
        do {
            String author = sc.nextLine();
            if (author.length() >= 6 && author.length() <= 50) {
                return author;
            } else {
                System.out.println("Author length not valid! Must enter about from 6 to 50 characters");
            }
        } while (true);
    }

    public String inputYear(Scanner sc) {
        System.out.println("Enter Year: ");
        do {
            String year = sc.nextLine();
            if (year.length() == 4 && Integer.parseInt(year) >= 2000) {
                return year;
            } else {
                System.out.println("Year length not valid! Must enter a Year after 2000");
            }
        } while (true);
    }

}
