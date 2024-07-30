public class Student {
    private String name;
    private String id;
    private int grade;

    public Student(String name, String id, int grade) {
        this.name = name;
        this.id = id;
        setGrade(grade);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) {
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }
}