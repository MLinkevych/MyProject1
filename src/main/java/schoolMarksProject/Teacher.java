package schoolMarksProject;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

    public void comment(String comment) {
        try (FileOutputStream fos = new FileOutputStream
                (".src\\main\\java\\schoolMarksProject\\teachersComment.txt")) {
            byte[] buffer = comment.getBytes();

            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

