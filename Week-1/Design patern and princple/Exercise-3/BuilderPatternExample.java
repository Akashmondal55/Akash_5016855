import java.util.Scanner;

public class BuilderPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputerDatabase database = new ComputerDatabase();

        while (true) {
            System.out.println("\nComputer Builder Menu:");
            System.out.println("1. Add a new computer");
            System.out.println("2. View all computers");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addComputer(scanner, database);
                    break;
                case 2:
                    viewComputers(database);
                    break;
                case 3:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addComputer(Scanner scanner, ComputerDatabase database) {
        System.out.println("\nEnter computer details:");
        
        System.out.print("CPU: ");
        String cpu = scanner.nextLine();

        System.out.print("RAM (GB): ");
        int ram = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Storage (GB): ");
        int storage = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("GPU: ");
        String gpu = scanner.nextLine();

        System.out.print("Operating System: ");
        String os = scanner.nextLine();

        Computer computer = new Computer.Builder()
                .cpu(cpu)
                .ram(ram)
                .storage(storage)
                .gpu(gpu)
                .operatingSystem(os)
                .build();

        database.addComputer(computer);
        System.out.println("Computer added successfully!");
    }

    private static void viewComputers(ComputerDatabase database) {
        System.out.println("\nAll computers in the database:");
        for (Computer computer : database.getAllComputers()) {
            System.out.println(computer);
        }
    }
}