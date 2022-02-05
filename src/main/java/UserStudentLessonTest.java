import excaption.UserNotFoundException;
import model.Lesson;
import model.Student;
import model.User;
import storage.LessonStorage;
import storage.StudentStorage;
import storage.UserStorage;
import util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class UserStudentLessonTest implements StudentLessonUtil, UserCommands {

    static UserStorage userStorage = new UserStorage();
    static LessonStorage lessonStorage = new LessonStorage();
    static StudentStorage studentStorage = new StudentStorage();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {

        boolean isRun = true;

        while (isRun) {

            UserCommands.printCommands();

            String userCommands = scanner.nextLine();

            switch (userCommands) {
                case EXIT:
                    System.exit(0);
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                case REGISTER:
                    register();
                    break;
                case LOGIN:
                    login();
                    break;
                default:
                    System.out.println();
                    System.err.println("invalid command");
            }
        }
    }

    private static void register() {
        System.out.println("please input user email");
        String email = scanner.nextLine();
        try {
            userStorage.getByEmail(email);
            System.err.println("This user already exists");
        } catch (UserNotFoundException e) {
            System.out.println("please input user name");
            String name = scanner.nextLine();
            System.out.println("please input user surname");
            String surname = scanner.nextLine();
            System.out.println("please input user password");
            String password = scanner.nextLine();
            System.out.println("please input user type - (USER or ADMIN)");
            String type = scanner.nextLine();
            if (type.equalsIgnoreCase("ADMIN") || type.equalsIgnoreCase("USER")) {
                User user = new User(name, surname, email, password, type);

                userStorage.add(user);

                System.out.println();
                System.out.println("thank you,user added");
            } else {
                System.err.println("This type is incorrectly selected");
            }
        }
    }

    private static void login() {
        System.out.println("please input email");
        String email = scanner.nextLine();
        User user;
        try {
            user = userStorage.getByEmail(email);
            System.out.println("please input password");
            String password = scanner.nextLine();
            if (user.getPassword().equals(password)) {
                System.out.println("please input type - (USER or ADMIN)");
                String type = scanner.nextLine().toUpperCase(Locale.ROOT);
                if (type.equalsIgnoreCase("ADMIN")) {
                    adminSwitch();
                } else if (type.equalsIgnoreCase("USER")) {
                    userSwitch();
                } else {
                    System.err.println("This type does not exist");
                }
            }
        } catch (UserNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void adminSwitch() {

        boolean isRun = true;

        while (isRun) {

            UserCommands.printAdminCommands();

            String command = scanner.nextLine();

            switch (command) {
                case EXIT:
                    System.exit(0);
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                case DELETE_LESSON_BY_NAME:
                    deleteLessonByName();
                    break;
                case DELETE_STUDENT_BY_EMAIL:
                    deleteStudentByEmail();
                    break;
                default:
                    System.out.println();
                    System.err.println("INVALID COMMAND");
            }
        }
    }

    private static void userSwitch() {

        boolean isRun = true;

        while (isRun) {

            UserCommands.printUserCommands();

            String command = scanner.nextLine();

            switch (command) {
                case EXIT:
                    System.exit(0);
                    break;
                case LOGOUT:
                    isRun = false;
                    break;
                case ADD_LESSON:
                    addLesson();
                    break;
                case ADD_STUDENT:
                    addStudent();
                    break;
                case PRINT_STUDENTS:
                    studentStorage.print();
                    break;
                case PRINT_STUDENTS_BY_LESSON:
                    printStudentsByLesson();
                    break;
                case PRINT_LESSONS:
                    lessonStorage.print();
                    break;
                default:
                    System.out.println();
                    System.err.println("INVALID COMMAND");
            }
        }
    }

    private static void deleteStudentByEmail() {
        StudentLessonUtil.chooseStudent();
        System.out.println("please input student email");
        String email = scanner.nextLine();
        if (studentStorage.getByEmail(email) != null) {
            studentStorage.deleteStudentBYEmail(email);
            System.out.println();
            System.out.println("student data deleted");
        } else {
            System.out.println();
            System.err.println("There is no student by this email");
        }
    }

    private static void deleteLessonByName() {
        StudentLessonUtil.chooseLesson();
        System.out.println("please input lesson name");
        String name = scanner.nextLine();

        if (lessonStorage.getByName(name) != null) {
            lessonStorage.deleteLessonByName(name);
            System.out.println();
            System.out.println("The course with that name has been deleted");
        } else {
            System.out.println();
            System.err.println("There is no course by that name");
        }
    }

    private static void printStudentsByLesson() {
        StudentLessonUtil.chooseLesson();
        System.out.println("Please enter the name of the student course");
        String lessonName = scanner.nextLine();
        Lesson lesson = lessonStorage.getByName(lessonName);
        if (lesson != null) {
            studentStorage.printStudentsByLesson(lesson);

            System.out.println();
            System.out.println("are the students participating in the course");
        } else {
            System.out.println();
            System.err.println("This course is not available");
        }
    }

    private static void addStudent() {
        System.out.println("please input student email");
        String email = scanner.nextLine();
        if (studentStorage.getByEmail(email) == null) {
            System.out.println("please input student name");
            String name = scanner.nextLine();
            System.out.println("please input student surname");
            String surName = scanner.nextLine();
            System.out.println("please input student age,in this format [12/12/2021]");
            Date age;
            try {
                age = DateUtil.stringToDate(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("This format is incorrect");
                return;
            }
            System.out.println("please input student phoneNumber");
            String phoneNumber = scanner.nextLine();
            System.out.println("please choose lessonName");
            System.out.println("_______________");
            lessonStorage.print();
            System.out.println("_______________");
            System.out.println("please input lessonNames separating ,");
            String lessonName = scanner.nextLine();
            String[] strings = lessonName.split(",");
            Lesson[] lessons = new Lesson[strings.length];
            for (int i = 0; i < strings.length; i++) {
                if (lessonStorage.getByName(strings[i]) != null) {
                    lessons[i] = lessonStorage.getByName(strings[i]);
                } else {
                    System.out.println();
                    System.err.println("This course is not available");
                }
            }

            Student student = new Student(name, surName, age, email, phoneNumber, lessons);

            studentStorage.add(student);

            System.out.println();
            System.out.println("student added");
        } else {
            System.out.println();
            System.err.println("There is already a student by this email");
        }
    }

    private static void addLesson() {
        System.out.println("Please enter a course name");
        String name = scanner.nextLine();

        Lesson lesson = lessonStorage.getByName(name);

        if (lesson == null) {
            System.out.println("Please enter the course length");
            String duration = scanner.nextLine();
            System.out.println("Please enter the name of the lecturer");
            String lecturerName = scanner.nextLine();
            System.out.println("Please enter the price of the course");
            int price = Integer.parseInt(scanner.nextLine());

            Lesson lesson1 = new Lesson(name, duration, lecturerName, price);

            lessonStorage.add(lesson1);

            System.out.println();
            System.out.println("Thanks, the course has been added");
        } else {
            System.out.println();
            System.err.println("There was already a course with that name");
        }
    }
}
