import java.util.HashMap;
import java.util.Map;

public class StudentController {
    private Map<String, Student> studentDatabase;
    private StudentView view;

    public StudentController(StudentView view) {
        this.studentDatabase = new HashMap<>();
        this.view = view;
    }

    public void addStudent(String name, String id, int grade) {
        Student student = new Student(name, id, grade);
        studentDatabase.put(id, student);
    }

    public void updateStudentName(String id, String name) {
        Student student = studentDatabase.get(id);
        if (student != null) {
            student.setName(name);
            view.displayMessage("Name updated successfully.");
        } else {
            view.displayMessage("Student not found.");
        }
    }

    public void updateStudentGrade(String id, int grade) {
        Student student = studentDatabase.get(id);
        if (student != null) {
            try {
                student.setGrade(grade);
                view.displayMessage("Grade updated successfully.");
            } catch (IllegalArgumentException e) {
                view.displayMessage(e.getMessage());
            }
        } else {
            view.displayMessage("Student not found.");
        }
    }

    public void displayStudent(String id) {
        Student student = studentDatabase.get(id);
        if (student != null) {
            view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
        } else {
            view.displayMessage("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (studentDatabase.isEmpty()) {
            view.displayMessage("No students in the database.");
        } else {
            for (Student student : studentDatabase.values()) {
                view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
                System.out.println();
            }
        }
    }
}