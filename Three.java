package task3;
import java.util.Scanner;

public class Three {
    private StudentManagementSystem sms;
    private Scanner scanner;

    // Constructor
    public Three() {
        sms = new StudentManagementSystem();
        scanner = new Scanner(System.in);
    }

    // Method to display the main menu
    public void displayMenu() {
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Method to add a student
    private void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Student student = new Student(name, rollNumber, grade, age);
        sms.addStudent(student);
    }

    // Method to remove a student
    private void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        sms.removeStudent(rollNumber);
    }

    // Method to search for a student
    private void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Student student = sms.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student);
        }
    }

    // Method to display all students
    private void displayAllStudents() {
        sms.displayAllStudents();
    }

    // Main method to start the application
    public static void main(String[] args) {
        Three ui = new Three();
        ui.displayMenu();
    }
}
