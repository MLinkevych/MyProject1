package schoolMarksProject;

import org.json.JSONObject;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        /////////////Creating objects of the Teacher class in a List///////////////////////////////////////////


        Teacher t1 = new Teacher("Anna", "Kornienko", "t1@gmail.com", "1a");
        Teacher t2 = new Teacher("Julia", "Ivanova", "t2@gmail.com", "1a");

        //////////////Creating objects of the Parent class in a List///////////////////////////////////////////

        Parent p1 = new Parent("Andrey", "Marchenko", "p1@gmail.com");
        //////////////Creating objects of the Student class in a List///////////////////////////////////////////
        List<Student> students = new ArrayList<>();
        students.add(new Student("Andrey", "Marchenko", "1a", "Julia",
                "Marchenko"));
        students.add(new Student("Inna", "Kovalska", "1a", "Hanna",
                "Artemchenko"));
        students.add(new Student("Artem", "Dmitruk", "1a", "Mark",
                "Dmitruk"));
        students.add(new Student("Artem", "Dmitruk", "1a", "Stas",
                "Dmitruk"));
        students.add(new Student("Inna", "Ostapenko", "2a", "Maya",
                "Ostapenko"));
        students.add(new Student("Anna", "Sadalska", "2a", "Sergei",
                "Sadalskyi"));
        students.add(new Student("Valentina", "Sazonenko", "2a", "Dmitry",
                "Sazonenko"));
        students.add(new Student("Valentina", "Sazonenko", "3a", "Svetlana",
                "Sazonenko"));
        students.add(new Student("Ihor", "Kovalenko", "3a", "Mark",
                "Kovalenko"));
        students.add(new Student("Iryna", "Stasenko", "3a", "Iryna",
                "Danylenko"));

        //////////////////Getting the list of students by last name in alphabetical order///////////////////


        Collections.sort(students, Comparator.comparing(Student::getGrade).thenComparing(Student::getStudentLastName));


        /*for (Student student : students) {

            System.out.println(student);


        }*/

        /*
         * creating a Student object in the JSON file///////////////////////
         * */
/*
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("parentFirstName", "Alina");
        jsonObject.put("parentLastName", "Ivanova");
        jsonObject.put("grade", "1a");
        jsonObject.put("studentFirstName", "Denys");
        jsonObject.put("studentLastName", "Ivanov");
        FileWriter file = null;
        try {
            file = new FileWriter(".\\src\\student.json");
            file.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            file.close();
        }
        System.out.println("JSON file created: " + jsonObject);*/

        ////////////// Creating the list of students and gardes///////////////////////////

        Map<Student, Grade> semesterGrades = new HashMap<>();
        semesterGrades.put(students.get(0), new Grade(12, 10, 10));
        semesterGrades.put(students.get(1), new Grade(11, 11, 8));
        semesterGrades.put(students.get(2), new Grade(10, 11, 12));
        semesterGrades.put(students.get(3), new Grade(7, 9, 11));
        semesterGrades.put(students.get(4), new Grade(7, 9, 8));
        semesterGrades.put(students.get(5), new Grade(8, 11, 10));
        semesterGrades.put(students.get(6), new Grade(6, 7, 7));
        semesterGrades.put(students.get(7), new Grade(10, 10, 9));
        semesterGrades.put(students.get(8), new Grade(12, 11, 12));
        semesterGrades.put(students.get(9), new Grade(12, 11, 12));
        ///////////////Updating the list to get the average scores and sort out the best student////////////

        semesterGrades.entrySet().stream()
                .collect(Collectors.toMap((Map.Entry::getKey), o -> o.getValue().avgScore()));
             /*   .forEach((student, Double) -> System.out.println(student.toString() + " " + Double));*/

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a grade: ");
        String grade = scanner.nextLine();
        switch (grade){
            case "1a":
                students.stream()
                        .filter(student -> (student.getGrade()=="1a"))
                        .forEach(student -> System.out.println(student));
                break;

            case "2a":
                students.stream()
                        .filter(student -> (student.getGrade()=="2a"))
                        .forEach(student -> System.out.println(student));
                break;

            case "3a":

            students.stream()
                    .filter(student -> (student.getGrade()=="3a"))
                    .forEach(student -> System.out.println(student));
            break;
            default:
                System.out.println("There is no such grade");
        }


        System.out.println("Input a message for the parent: ");
        Scanner scannerComment = new Scanner(System.in);
        String commentByTeacher = scannerComment.nextLine();

        t1.comment(commentByTeacher);



    }
}
