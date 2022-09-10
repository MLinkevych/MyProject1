package schoolMarksProject;


public class Student extends Parent implements Comparable<Student> {

    private String grade;
    private String studentFirstName;
    private String studentLastName;


    /*
     * Constructor for the students objects
     *
     */

    public Student(String firstName, String lastName, String email, String grade) {
        super(firstName, lastName, email);
        this.grade = grade;
    }

    public Student(String firstName, String lastName, String grade, String studentFirstName, String studentLastName) {
        super(firstName, lastName);
        this.grade = grade;
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public Student(String studentFirstName, String studentLastName) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    /*
     * Getters and setters. Getters are set for all the fields, while setters is only for the grade and email
     * */
    public String getGrade() {
        return grade;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student grade: "  + grade + " " + studentFirstName + " " + studentLastName;
    }


    @Override
    public int compareTo(Student o) {
        return getStudentLastName().compareTo(o.getStudentLastName());
    }

}
