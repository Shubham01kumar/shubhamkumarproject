package task3;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two {
    private String id;
    private String name;

    public two(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student ID: " + id + ", Name: " + name;
    }
}

class StudentManagementSystem {
    private List<two> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(String id, String name) {
        students.add(new two(id, name));
        System.out.println("Student added: " + id + " - " + name);
    }

    public void removeStudent(String id) {
        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                studentToRemove = student;
                break;
            }
        }
        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed: " + id);
        } else {
            System.out.println("Student not found: " + id);
        }
    }

    public void searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student found: " + student);
                return;
            }
        }
        System.out.println("Student not found: " + id);
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("Displaying all students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    sms.addStudent(id, name);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    String removeId = scanner.nextLine();
                    sms.removeStudent(removeId);
                    break;
                case 3:
                    System.out.print("Enter student ID to search: ");
                    String searchId = scanner.nextLine();
                    sms.searchStudent(searchId);
                    break;
                case 4:
                    sms.displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


