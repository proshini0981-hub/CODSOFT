import java.util.Scanner;

public class Currency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User enters currencies
        System.out.print("Enter Base Currency: ");
        String baseCurrency = sc.next();

        System.out.print("Enter Target Currency: ");
        String targetCurrency = sc.next();

        // User enters amount
        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        // User enters exchange rate
        System.out.print("Enter Exchange Rate: ");
        double exchangeRate = sc.nextDouble();

        // Conversion
        double convertedAmount = amount * exchangeRate;

        // Display result
        System.out.println("\n===== Conversion Result =====");
        System.out.println(amount + " " + baseCurrency + " = "
                + convertedAmount + " " + targetCurrency);

        sc.close();
    }
}