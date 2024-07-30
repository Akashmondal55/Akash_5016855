public class StudentView {
    public void displayStudentDetails(String name, String id, int grade) {
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade + "/100");
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}