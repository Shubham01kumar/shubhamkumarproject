package task3;
import java.util.ArrayList;
import java.util.List;
public class Student {
    private int studentId;
    private String name;
    private int age;

    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name + ", Age: " + age;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added: " + student);
    }

    public void removeStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                students.remove(student);
                System.out.println("Student removed: " + student);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public Student searchStudent(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
        return null;
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        
        Student student1 = new Student(1, "Alice", 20);
        Student student2 = new Student(2, "Bob", 22);
        
        sms.addStudent(student1);
        sms.addStudent(student2);
        
        System.out.println("Searching for student with ID 1:");
        System.out.println(sms.searchStudent(1));
        
        System.out.println("All students:");
        sms.displayAllStudents();
        
        sms.removeStudent(1);
        
        System.out.println("All students after removal:");
        sms.displayAllStudents();
    }
}


