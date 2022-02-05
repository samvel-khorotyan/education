package storage;

import model.Lesson;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentStorage {

    private static List<Student> student = new ArrayList<>();

    public void add(Student students) {
        student.add(students);
    }

    public static void print() {
        for (Student student1 : student) {
            System.out.println(student1);
        }
    }

    public Student getByEmail(String email) {
        for (Student student1 : student) {
            if (student1.getEmail().equals(email)) {
                return student1;
            }
        }
        return null;
    }

    public void deleteStudentBYEmail(String email) {
        for (Student student1 : student) {
            if (student1.getEmail().equals(email)) {
                student.remove(student1);
                break;
            }
        }
    }

    public void printStudentsByLesson(Lesson lesson) {
        for (Student student1 : student) {
            for (Lesson lesson1 : student1.getLesson()) {
                if (lesson1.equals(lesson)) {
                    System.out.println(student1);
                }
            }
        }
    }
}
