import java.util.Scanner;

public class AdapterPatternTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentProcessor gPayProcessor = new GPayAdapter(new GPayGateway());
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Make a payment");
            System.out.println("2. View transaction history");
            System.out.println("3. Save transactions to file");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    processPayment(scanner, gPayProcessor, stripeProcessor);
                    break;
                case 2:
                    TransactionRecord.displayTransactions();
                    break;
                case 3:
                    System.out.print("Enter filename to save transactions: ");
                    String filename = scanner.next();
                    TransactionRecord.saveTransactionsToFile(filename);
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void processPayment(Scanner scanner, PaymentProcessor gPayProcessor, PaymentProcessor stripeProcessor) {
        System.out.println("\nChoose a payment method:");
        System.out.println("1. GPay");
        System.out.println("2. Stripe");
        System.out.print("Enter your choice (1-2): ");

        int paymentChoice = scanner.nextInt();

        if (paymentChoice != 1 && paymentChoice != 2) {
            System.out.println("Invalid choice. Payment cancelled.");
            return;
        }

        System.out.print("Enter the payment amount: $");
        double amount = scanner.nextDouble();

        String paymentMethod;
        if (paymentChoice == 1) {
            gPayProcessor.processPayment(amount);
            paymentMethod = "GPay";
        } else {
            stripeProcessor.processPayment(amount);
            paymentMethod = "Stripe";
        }

        TransactionRecord.addTransaction(paymentMethod, amount);
    }
}