import java.util.Scanner;

public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Create the dependency
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject the dependency
        CustomerService service = new CustomerService(repository);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCustomer Management System");
            System.out.println("1. Add Customer");
            System.out.println("2. Find Customer");
            System.out.println("3. Update Customer");
            System.out.println("4. Delete Customer");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    service.addCustomer(id, name);
                    System.out.println("Customer added successfully.");
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    id = scanner.nextLine();
                    name = service.getCustomerName(id);
                    if (name != null) {
                        System.out.println("Customer found: " + name);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter customer ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter new customer name: ");
                    name = scanner.nextLine();
                    service.updateCustomer(id, name);
                    System.out.println("Customer updated successfully.");
                    break;
                case 4:
                    System.out.print("Enter customer ID: ");
                    id = scanner.nextLine();
                    service.deleteCustomer(id);
                    System.out.println("Customer deleted successfully.");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}