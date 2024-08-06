
import java.io.*;
import java.util.*;

class Product implements Comparable<Product>, Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    // Getters
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Product{id=%-3d, name=%-15s, category=%-10s}", productId, "'" + productName + "'", "'" + category + "'");
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareToIgnoreCase(other.productName);
    }
}

public class ECommerceSearch {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "products.dat";

    public static void main(String[] args) {
        loadProducts();
        
        while (true) {
            displayMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    displayProducts();
                    break;
                case 5:
                    saveProducts();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("        E-Commerce Product Management");
        System.out.println("=".repeat(50));
        System.out.println("1. Add Product");
        System.out.println("2. Delete Product");
        System.out.println("3. Search Product");
        System.out.println("4. Display All Products");
        System.out.println("5. Save and Exit");
        System.out.println("-".repeat(50));
    }

    private static int getChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please try again.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void addProduct() {
        System.out.println("\n--- Add New Product ---");
        System.out.print("Enter product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product category: ");
        String category = scanner.nextLine();

        Product newProduct = new Product(id, name, category);
        products.add(newProduct);
        Collections.sort(products);
        System.out.println("Product added successfully.");
    }

    private static void deleteProduct() {
        System.out.println("\n--- Delete Product ---");
        System.out.print("Enter product ID to delete: ");
        int id = scanner.nextInt();
        boolean removed = products.removeIf(p -> p.getProductId() == id);
        if (removed) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void searchProduct() {
        System.out.println("\n--- Search Product ---");
        System.out.print("Enter product name to search: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();

        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        System.out.print("Choose search method: ");
        int searchChoice = scanner.nextInt();

        Product result;
        long startTime = System.nanoTime();

        if (searchChoice == 1) {
            result = linearSearch(name);
        } else {
            result = binarySearch(name);
        }

        long endTime = System.nanoTime();

        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Search Time: " + (endTime - startTime) + " ns");
    }

    private static Product linearSearch(String productName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    private static Product binarySearch(String productName) {
        int left = 0;
        int right = products.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products.get(mid).getProductName().compareToIgnoreCase(productName);

            if (comparison == 0) {
                return products.get(mid);
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    private static void displayProducts() {
        System.out.println("\n--- All Products ---");
        System.out.println("-".repeat(50));
        System.out.printf("%-5s %-20s %-15s\n", "ID", "Name", "Category");
        System.out.println("-".repeat(50));
        for (Product product : products) {
            System.out.printf("%-5d %-20s %-15s\n", 
                product.getProductId(), 
                product.getProductName(), 
                product.getCategory());
        }
        System.out.println("-".repeat(50));
    }

    private static void saveProducts() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
            System.out.println("Products saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadProducts() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                products = (List<Product>) ois.readObject();
                System.out.println("Products loaded successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error loading products: " + e.getMessage());
                initializeProducts(); // Initialize with default products if loading fails
            }
        } else {
            initializeProducts(); // Initialize with default products if file doesn't exist
        }
    }

    private static void initializeProducts() {
        products.add(new Product(1, "Laptop", "Electronics"));
        products.add(new Product(2, "Desk Chair", "Furniture"));
        products.add(new Product(3, "Coffee Maker", "Appliances"));
        products.add(new Product(4, "Bookshelf", "Furniture"));
        products.add(new Product(5, "Smartphone", "Electronics"));
        Collections.sort(products);
    }
}