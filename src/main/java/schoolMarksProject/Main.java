package schoolMarksProject;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {


        Teacher t1 = new Teacher("Anna", "Kornienko", "t1@gmail.com", "1a");
        Teacher t2 = new Teacher("Julia", "Sazonenko", "t2@gmail.com", "1a");

        Parent p1 = new Parent("Andrey", "Marchenko", "p1@gmail.com");
        List<Student> students = new ArrayList<>();
        students.add(new Student("Andrey", "Marchenko", "1a", "Julia",
                "Barchenko"));
        students.add(new Student("Inna", "Kovalska", "1a", "Hanna",
                "Artemchenko"));
        students.add(new Student("Artem", "Dmitruk", "1a", "Mark",
                "Dmitruk"));
        /*
         * creating a Student object in the JSON file///////////////////////
         * */

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
        System.out.println("JSON file created: " + jsonObject);

        ////////////// Creating the list of students and gardes///////////////////////////

        Map<Student, Grade> semesterGrades = new HashMap<>();
        semesterGrades.put(students.get(0), new Grade(12, 10, 10));
        semesterGrades.put(students.get(1), new Grade(11, 11, 8));
        semesterGrades.put(students.get(2), new Grade(10, 11, 12));
        ///////////////Updating the list to get the average scores and sort out the best student////////////

        semesterGrades.entrySet().stream()
                .collect(Collectors.toMap((Map.Entry::getKey), o -> o.getValue().avgScore()))
                .forEach((student, Double) -> System.out.println(student.toString() + " " + Double));

        //////////////////Getting the list of students by last name in alphabetical order///////////////////


        Collections.sort(students, Comparator.comparing(Student::getStudentLastName));


        for (Student student : students) {

            System.out.println(student);


        }
    }
}
