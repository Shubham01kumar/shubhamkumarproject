package task3;
import java.util.*;
public class six{
    private String name;
    private int rollNumber;
    private String grade;
    private int age;

    public six(String name, int rollNumber, String grade, int age ) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.age = age;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class six {//StudentManagementSystem {
    private Scanner scanner;

    public StudentManagementSystem() {
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = getIntegerInput();

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = getIntegerInput();

        Student student = new Student(name, rollNumber,grade,age,);
        System.out.println("Student added: " + student);
    }

    private int getIntegerInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static void main(String[] args) {
        //StudentManagementSystem sms = new StudentManagementSystem();
        six sms = new six();
        sms.addStudent();
    }
}

