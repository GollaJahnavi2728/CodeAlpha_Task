import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker{

    static class Student {
        String name;
        ArrayList<Integer> grades = new ArrayList<>();

        Student(String name) {
            this.name = name;
        }

        void addGrade(int grade) {
            grades.add(grade);
        }

        double getAverage() {
            int sum = 0;
            for (int grade : grades) {
                sum += grade;
            }
            return grades.size() > 0 ? (double) sum / grades.size() : 0;
        }

        int getHighest() {
            int max = Integer.MIN_VALUE;
            for (int grade : grades) {
                if (grade > max) max = grade;
            }
            return max;
        }

        int getLowest() {
            int min = Integer.MAX_VALUE;
            for (int grade : grades) {
                if (grade < min) min = grade;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("🎓 Student Grade Tracker");
        System.out.println("Enter number of students:");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < numStudents; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }
            scanner.nextLine(); // consume newline
            students.add(student);
        }

        // Summary Report
        System.out.println("\n📊 Summary Report:");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.println("Average: " + s.getAverage());
            System.out.println("Highest: " + s.getHighest());
            System.out.println("Lowest: " + s.getLowest());
            System.out.println("-----------------------");
        }

        scanner.close();
    }
}
