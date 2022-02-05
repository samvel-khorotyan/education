import storage.LessonStorage;
import storage.StudentStorage;

public interface StudentLessonUtil {

    static void chooseStudent() {
        System.out.println("please choose student");
        System.out.println("-----------------");
        StudentStorage.print();
        System.out.println("-----------------");
    }

    static void chooseLesson() {
        System.out.println("please choose lesson");
        System.out.println("-----------------");
        LessonStorage.print();
        System.out.println("-----------------");
    }
}
