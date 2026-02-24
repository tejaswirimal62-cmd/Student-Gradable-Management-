import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        GradeManager manager = new GradeManager();
        manager.loadData();
        int choice;

        do {
            System.out.println("\n--- Student Grade System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Graduate Student");
            System.out.println("3. Show Students");
            System.out.println("4. Save & Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter number 1-4.");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {

                    case 1: {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();

                        manager.addStudent(new Student(id, name, marks));
                        System.out.println("Student added successfully!");
                        break;
                    }

                    case 2: {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();

                        manager.addStudent(new GraduateStudent(id, name, marks));
                        System.out.println("Graduate Student added successfully!");
                        break;
                    }

                    case 3:
                        manager.showStudents();
                        break;

                    case 4:
                        manager.saveData();
                        System.out.println("Data saved. Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (choice != 4);

        sc.close();
    }
}
