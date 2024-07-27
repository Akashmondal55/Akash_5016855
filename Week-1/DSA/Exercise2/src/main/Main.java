import model.Product;
import search.LinearSearch;
import search.BinarySearch;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create sample products
        Product[] products = createSampleProducts();

        System.out.println("E-commerce Platform Search Function");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Choose search method (1 or 2): ");
        int searchMethod = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter product name to search: ");
        String searchTerm = scanner.nextLine();

        Product result;
        long startTime = System.nanoTime();

        if (searchMethod == 1) {
            result = LinearSearch.search(products, searchTerm);
        } else {
            result = BinarySearch.search(products, searchTerm);
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }

        System.out.println("Search time: " + duration + " nanoseconds");

        scanner.close();
    }

    private static Product[] createSampleProducts() {
        return new Product[] {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Smartphone", "Electronics"),
            new Product(3, "Headphones", "Electronics"),
            new Product(4, "Book", "Literature"),
            new Product(5, "Desk", "Furniture")
        };
    }
}