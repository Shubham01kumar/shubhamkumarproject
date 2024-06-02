package task3;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentManagementSystem {
    private List<Student> students;
    private static final String DB_URL = "jdbc:sqlite:students.db";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        createDatabase();
    }

    // Add a student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student);
    }

    // Edit a student by roll number
    public void  editStudent(int RollNumber, Student newStudentData) {

        for (Student student : students) {
            if (student.getRollNumber() == RollNumber) {
                student.setName(newStudentData.getName());
                student.setGrade(newStudentData.getGrade());
                student.setAge(newStudentData.getAge());
                System.out.println("Student information updated: " + student);
                return;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
    }

    // Remove a student by roll number
    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student with roll number " + rollNumber + " removed.");
    }

    // Search for a student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        System.out.println("Student with roll number " + rollNumber + " not found.");
        return null;
    }

    // Display all students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Write students to file
    public void writeToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student data written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read students from file
    public void readFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Student data read from file: " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    // Create database
    private void createDatabase() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS Students (" +
                         "rollNumber INTEGER PRIMARY KEY, " +
                         "name TEXT NOT NULL, " +
                         "grade TEXT NOT NULL, " +
                         "age INTEGER NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Write students to database
    public void writeToDatabase() {
        String sql = "INSERT INTO Students (rollNumber, name, grade, age) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            for (Student student : students) {
                pstmt.setInt(1, student.getRollNumber());
                pstmt.setString(2, student.getName());
                pstmt.setString(3, student.getGrade());
                pstmt.setInt(4, student.getAge());
                pstmt.executeUpdate();
            }
            System.out.println("Student data written to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Read students from database
    public void readFromDatabase() {
        String sql = "SELECT rollNumber, name, grade, age FROM Students";
        students.clear();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int rollNumber = rs.getInt("rollNumber");
                String name = rs.getString("name");
                String grade = rs.getString("grade");
                int age = rs.getInt("age");

                Student student = new Student(name, rollNumber, grade, age);
                students.add(student);
            }
            System.out.println("Student data read from database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Write to File");
            System.out.println("7. Read from File");
            System.out.println("8. Write to Database");
            System.out.println("9. Read from Database");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
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
                    break;
                case 2:
                    System.out.print("Enter roll number of student to edit: ");
                    int editRollNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Student newStudentData = new Student(newName, editRollNumber, newGrade, newAge);
                    sms.editStudent(editRollNumber, newStudentData);
                    break;
                case 3:
                    System.out.print("Enter roll number of student to remove: ");
                    int removeRollNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    sms.removeStudent(removeRollNumber);
                    break;
                case 4:
                    System.out.print("Enter roll number of student to search: ");
                    int searchRollNumber = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    Student foundStudent = sms.searchStudent(searchRollNumber);
                    if (foundStudent != null) {
                        System.out.println("Found: " + foundStudent);
                    }
                    break;
                case 5:
                    sms.displayAllStudents();
                    break;
                case 6:
                    System.out.print("Enter filename to write to: ");
                    String writeFilename = scanner.nextLine();
                    sms.writeToFile(writeFilename);
                    break;
                case 7:
                    System.out.print("Enter filename to read from: ");
                    String readFilename = scanner.nextLine();
                    sms.readFromFile(readFilename);
                    break;
                case 8:
                    sms.writeToDatabase();
                    break;
                case 9:
                    sms.readFromDatabase();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}


