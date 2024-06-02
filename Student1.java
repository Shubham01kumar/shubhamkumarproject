package task3;

public class Student1 {
        private String name;
        private int rollNumber;
        private String grade;
        private int age;
    
        // Constructor
        public Student1(String name, int rollNumber, String grade, int age) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.grade = grade;
            this.age = age;
        }
    
        // Getter and Setter for name
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        // Getter and Setter for rollNumber
        public int getRollNumber() {
            return rollNumber;
        }
    
        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }
    
        // Getter and Setter for grade
        public String getGrade() {
            return grade;
        }
    
        public void setGrade(String grade) {
            this.grade = grade;
        }
    
        // Getter and Setter for age
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        // toString method for easy representation
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", rollNumber=" + rollNumber +
                    ", grade='" + grade + '\'' +
                    ", age=" + age +
                    '}';
        }
    
        // Main method to test the Student class
        public static void main(String[] args) {
            Student1 student1 = new Student1("John Doe", 101, "A", 20);
            System.out.println(student1);
    
            // Updating student's grade
            student1.setGrade("A+");
            System.out.println("Updated grade: " + student1.getGrade());
    
            // Updating student's age
            student1.setAge(21);
            System.out.println("Updated age: " + student1.getAge());
    
            System.out.println(student1);
        }
}

