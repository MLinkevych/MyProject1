package schoolMarksProject;


public class Parent extends Person{


    /*
    * Constructor for the parents objects
    *
    */

    public Parent(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public Parent() {
    }

    public Parent(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Parent: " + getFirstName() + getLastName();
    }
}
