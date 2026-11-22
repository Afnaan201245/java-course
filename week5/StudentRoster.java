package week5;

import java.util.ArrayList;
import java.util.Scanner;

// This program integrates arrays and ArrayLists to manage a student roster.
public class StudentRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Fixed data: subjects
        String[] subjects = {"Math", "English", "Science"};

        // Dynamic data: student names and marks
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<int[]> studentMarks = new ArrayList<>();

        // Add initial students
        studentNames.add("Alice");
        studentMarks.add(new int[]{85, 90, 78});

        studentNames.add("Bob");
        studentMarks.add(new int[]{72, 88, 91});

        studentNames.add("Charlie");
        studentMarks.add(new int[]{65, 75, 80});

        int choice;

        do {
            System.out.println("\n==============================================");
            System.out.println(" STUDENT ROSTER MANAGER");
            System.out.println("==============================================");
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Class Average");
            System.out.println("4. Search Student by Name");
            System.out.println("5. Remove Student");
            System.out.println("6. Exit");
            System.out.println("==============================================");
            System.out.print("Enter your choice (1-6): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    int[] marks = new int[subjects.length];
                    for (int i = 0; i < subjects.length; i++) {
                        System.out.print("Enter mark for " + subjects[i] + ": ");
                        marks[i] = scanner.nextInt();
                    }
                    scanner.nextLine();

                    studentNames.add(name);
                    studentMarks.add(marks);
                    System.out.println("Student '" + name + "' added successfully.");
                    break;

                case 2:
                    System.out.println("\n=== STUDENT ROSTER ===");
                    if (studentNames.isEmpty()) {
                        System.out.println("No students in the roster.");
                    } else {
                        System.out.printf("%-12s", "Student");
                        for (String subject : subjects) {
                            System.out.printf("%-12s", subject);
                        }
                        System.out.println("Average");
                        System.out.println("------------------------------------------------");

                        for (int i = 0; i < studentNames.size(); i++) {
                            System.out.printf("%-12s", studentNames.get(i));

                            int total = 0;
                            int[] studentMark = studentMarks.get(i);
                            for (int mark : studentMark) {
                                System.out.printf("%-12d", mark);
                                total += mark;
                            }

                            double average = (double) total / studentMark.length;
                            System.out.printf("%.2f%n", average);
                        }
                    }
                    break;

                case 3:
                    if (studentNames.isEmpty()) {
                        System.out.println("No students to calculate average.");
                    } else {
                        int grandTotal = 0;
                        int totalMarks = 0;

                        for (int[] studentMark : studentMarks) {
                            for (int mark : studentMark) {
                                grandTotal += mark;
                                totalMarks++;
                            }
                        }

                        double classAverage = (double) grandTotal / totalMarks;
                        System.out.printf("Class Average: %.2f%n", classAverage);
                    }
                    break;

                case 4:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.nextLine();
                    int index = studentNames.indexOf(searchName);

                    if (index != -1) {
                        System.out.println("\n=== STUDENT FOUND ===");
                        System.out.println("Name: " + studentNames.get(index));
                        int[] studentMark = studentMarks.get(index);
                        for (int i = 0; i < subjects.length; i++) {
                            System.out.println(subjects[i] + ": " + studentMark[i]);
                        }
                    } else {
                        System.out.println("Student '" + searchName + "' not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter name to remove: ");
                    String removeName = scanner.nextLine();
                    int removeIndex = studentNames.indexOf(removeName);

                    if (removeIndex != -1) {
                        studentNames.remove(removeIndex);
                        studentMarks.remove(removeIndex);
                        System.out.println("Student '" + removeName + "' removed.");
                    } else {
                        System.out.println("Student '" + removeName + "' not found.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using the Student Roster Manager!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1-6.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }
}