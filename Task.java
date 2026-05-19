import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Student {

    String name;
    int rollno;
    char grade;
    char section;

    Student(String name, int rollno, char grade, char section) {

        this.name = name;
        this.rollno = rollno;
        this.grade = grade;
        this.section = section;
    }
}

class StudentManagementSystem {

    ArrayList<Student> students = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

  
    void addStudent() {

        System.out.println("Enter Name:");

        String name;

      while (true) {

    name = sc.next();

    boolean valid = true;

    for (int i = 0; i < name.length(); i++) {

        if (!Character.isLetter(name.charAt(i))) {

            valid = false;
            break;
        }
    }

    if (valid) {
        break;
    }

    System.out.println("Enter Valid Name:");
}

        System.out.println("Enter Roll Number:");

        int rollno;

        while (true) {

            rollno = sc.nextInt();

            if (rollno > 0) {
                break;
            }

            System.out.println("Enter Valid Roll Number");
        }

        System.out.println("Enter Grade (A-F):");

        char grade;

        while (true) {

            grade = Character.toUpperCase(sc.next().charAt(0));

            if (grade >= 'A' && grade <= 'F') {
                break;
            }

            System.out.println("Enter Valid Grade");
        }

        System.out.println("Enter Section:");

        char section;

        while (true) {

            section = sc.next().charAt(0);

            if (Character.isLetter(section)) {
                break;
            }

            System.out.println("Enter Valid Section");
        }

        Student s =
                new Student(name, rollno, grade, section);

        students.add(s);

        saveToFile();

        System.out.println("Student Added Successfully");
    }


    void removeStudent() {

        System.out.println("Enter Roll Number to Remove:");

        int roll = sc.nextInt();

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).rollno == roll) {

                students.remove(i);

                saveToFile();

                System.out.println("Student Removed");

                return;
            }
        }

        System.out.println("Student Not Found");
    }

  
    void editStudent() {

        System.out.println("Enter Roll Number to Edit:");

        int roll = sc.nextInt();

        for (Student s : students) {

            if (s.rollno == roll) {

                System.out.println("Enter New Name:");
                s.name = sc.next();

                System.out.println("Enter New Grade:");
                s.grade = Character.toUpperCase(sc.next().charAt(0));

                System.out.println("Enter New Section:");
                s.section = sc.next().charAt(0);

                saveToFile();

                System.out.println("Student Updated");

                return;
            }
        }

        System.out.println("Student Not Found");
    }

    void searchStudent() {

        System.out.println("Enter Roll Number to Search:");

        int roll = sc.nextInt();

        for (Student s : students) {

            if (s.rollno == roll) {

                System.out.println("----------------");

                System.out.println("Name: " + s.name);
                System.out.println("Roll No: " + s.rollno);
                System.out.println("Grade: " + s.grade);
                System.out.println("Section: " + s.section);

                return;
            }
        }

        System.out.println("Student Not Found");
    }

    void displayStudents() {

        if (students.isEmpty()) {

            System.out.println("No Students Found");

            return;
        }

        for (Student s : students) {

            System.out.println("----------------");

            System.out.println("Name: " + s.name);
            System.out.println("Roll No: " + s.rollno);
            System.out.println("Grade: " + s.grade);
            System.out.println("Section: " + s.section);
        }
    }

   
    void saveToFile() {

        try {

            FileWriter fw =
                    new FileWriter("students.txt");

            for (Student s : students) {

                fw.write(s.name + " ");
                fw.write(s.rollno + " ");
                fw.write(s.grade + " ");
                fw.write(s.section + "\n");
            }

            fw.close();
        }

        catch (Exception e) {

            System.out.println("Error Saving File");
        }
    }

    
    void loadFromFile() {

        try {

            File file = new File("students.txt");

            if (!file.exists()) {
                return;
            }

            Scanner read = new Scanner(file);

            while (read.hasNext()) {

                String name = read.next();
                int roll = read.nextInt();
                char grade = read.next().charAt(0);
                char section = read.next().charAt(0);

                Student s =
                        new Student(name, roll, grade, section);

                students.add(s);
            }

            read.close();
        }

        catch (Exception e) {

            System.out.println("Error Loading File");
        }
    }
}

public class Task {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManagementSystem sms =
                new StudentManagementSystem();

       
        sms.loadFromFile();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display Students");
            System.out.println("6. Exit");

            System.out.println("Enter Your Choice:");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sms.addStudent();
                    break;

                case 2:
                    sms.removeStudent();
                    break;

                case 3:
                    sms.editStudent();
                    break;

                case 4:
                    sms.searchStudent();
                    break;

                case 5:
                    sms.displayStudents();
                    break;

                case 6:
                    System.out.println("Exited");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
