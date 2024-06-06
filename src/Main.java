import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date (e.g., 3/3/2020): ");
        String dateInput = scanner.nextLine();

        SimpleDateFormat inputFormat = new SimpleDateFormat("M/d/yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("MM/dd/yyyy");

        try {
            Date date = inputFormat.parse(dateInput);
            String formattedDate = outputFormat.format(date);
            System.out.println("Formatted date: " + formattedDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in M/d/yyyy format.");
        }


    }
}