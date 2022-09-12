package schoolMarksProject;


import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Teacher extends Person implements Comment{
    private String grade;

    /*
     * Constructor
     * */

    public Teacher(String firstName, String lastName, String email, String grade) {
        super(firstName, lastName, email);
        this.grade = grade;
    }
    /*
     * Getters and setters
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

    @Override
    public void comment(String comment) {
        try (FileOutputStream fos = new FileOutputStream("src/main/java/schoolMarksProject/teachersComment.txt");
             BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            String fName = getFirstName() + " ";
            byte[] firstName = fName.getBytes();
            String lName = getLastName() + " : ";
            byte[] lastName = lName.getBytes();
            byte[] buffer = comment.getBytes();
            bos.write(firstName, 0, firstName.length);
            bos.write(lastName, 0, lastName.length);
            bos.write(buffer, 0, buffer.length);
            System.out.println("The comment has been written");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

