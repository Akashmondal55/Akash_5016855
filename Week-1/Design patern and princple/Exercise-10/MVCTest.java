import java.util.Scanner;

public class MVCTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(view);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Update student name");
            System.out.println("3. Update student grade");
            System.out.println("4. Display student details");
            System.out.println("5. Display all students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student grade (0-100): ");
                    int grade = scanner.nextInt();
                    controller.addStudent(name, id, grade);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    name = scanner.nextLine();
                    controller.updateStudentName(id, name);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();
                    System.out.print("Enter new grade (0-100): ");
                    grade = scanner.nextInt();
                    controller.updateStudentGrade(id, grade);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    id = scanner.nextLine();
                    controller.displayStudent(id);
                    break;
                case 5:
                    controller.displayAllStudents();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}