public interface UserCommands {

    String EXIT = "0";
    String LOGOUT = "1";
    String ADD_LESSON = "2";
    String ADD_STUDENT = "3";
    String PRINT_STUDENTS = "4";
    String PRINT_STUDENTS_BY_LESSON = "5";
    String PRINT_LESSONS = "6";
    String DELETE_LESSON_BY_NAME = "7";
    String DELETE_STUDENT_BY_EMAIL = "8";
    // user commands
    String REGISTER = "2";
    String LOGIN = "3";

    static void printCommands() {
        System.out.println();
        System.out.println("please input " + LOGOUT + " for logout");
        System.out.println("please input " + REGISTER + " for register");
        System.out.println("please input " + LOGIN + " for login");
    }

    static void printAdminCommands() {
        System.out.println();
        System.out.println("please input " + EXIT + " for exit");
        System.out.println("please input " + LOGOUT + " for logout");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student");
        System.out.println("please input " + PRINT_STUDENTS + " for print student");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lessons");
        System.out.println("please input " + DELETE_LESSON_BY_NAME + " for delete lesson by name");
        System.out.println("please input " + DELETE_STUDENT_BY_EMAIL + " for delete student by email");
        System.out.println();
    }

    static void printUserCommands() {
        System.out.println();
        System.out.println("please input " + EXIT + " for exit");
        System.out.println("please input " + LOGOUT + " for logout");
        System.out.println("please input " + ADD_LESSON + " for add lesson");
        System.out.println("please input " + ADD_STUDENT + " for add student");
        System.out.println("please input " + PRINT_STUDENTS + " for print student");
        System.out.println("please input " + PRINT_STUDENTS_BY_LESSON + " for print students by lesson");
        System.out.println("please input " + PRINT_LESSONS + " for print lessons");
        System.out.println();
    }
}
