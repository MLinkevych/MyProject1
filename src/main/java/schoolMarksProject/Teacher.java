package schoolMarksProject;


public class Teacher extends Person {
    private String grade;

    /*
     * Constructor
     * */

    public Teacher(String firstName, String lastName, String email, String grade) {
        super(firstName, lastName, email);
        this.grade = grade;
    }
    /*
     * Getters and setters. Getters are set for all the fields, while setters is only for the grade and email
     * */

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    /*////////////overriding the toString method/////////////////////////*/

    @Override
    public String toString() {
        return "Teacher: " + getFirstName() + getLastName() + getGrade() + getEmail();
    }
}

