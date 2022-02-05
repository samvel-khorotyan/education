package storage;

import model.Lesson;

import java.util.ArrayList;

public class LessonStorage {

    private static ArrayList<Lesson> lesson = new ArrayList<>();

    public void add(Lesson lessons) {
        lesson.add(lessons);
    }

    public static void print() {
        for (Lesson lesson1 : lesson) {
            System.out.println(lesson1);
        }
    }

    public Lesson getByName(String name) {
        for (Lesson lesson1 : lesson) {
            if (lesson1.getName().equals(name)) {
                return lesson1;
            }
        }
        return null;
    }

    public void deleteLessonByName(String name) {
        for (Lesson lesson1 : lesson) {
            if (lesson1.getName().equals(name)) {
                lesson.remove(lesson1);
                break;
            }
        }
    }
}
