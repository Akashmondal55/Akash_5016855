import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransactionRecord {
    private static List<String> transactions = new ArrayList<>();

    public static void addTransaction(String paymentMethod, double amount) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String transaction = String.format("%s - %s: $%.2f", timestamp, paymentMethod, amount);
        transactions.add(transaction);
    }

    public static void displayTransactions() {
        System.out.println("\nTransaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public static void saveTransactionsToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (String transaction : transactions) {
                writer.write(transaction + "\n");
            }
            System.out.println("Transactions saved to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while saving transactions: " + e.getMessage());
        }
    }
}