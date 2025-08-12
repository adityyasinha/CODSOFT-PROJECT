import java.util.Scanner;

public class P2_Grade_Calculator {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numOfSubjects = sc.nextInt();

        int[] marks = new int[numOfSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numOfSubjects; i++) {
            System.out.print("Enter marks for each subject " + (i + 1) + " (out of 100): ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Given marks are invalid! Please enter a valid marks b/w 0 and 100.");
                i--; 
                continue;
            }

            totalMarks += marks[i];
        }

        double avgPercentage = (double) totalMarks / numOfSubjects;

        String grade;
        if (avgPercentage >= 95) {
            grade = "A+";
        } else if (avgPercentage >= 90) {
            grade = "A";
        } else if (avgPercentage >= 85) {
            grade = "B+";
        } else if (avgPercentage >= 80) {
            grade = "B";
        } else if (avgPercentage >= 70) {
            grade = "C+";
        }else if (avgPercentage >= 60) {
            grade = "C";
        }
        else if (avgPercentage >= 50) {
            grade = "D";
        }
        else if (avgPercentage >= 40) {
            grade = "E";
        }
         else {
            grade = "F";

        }

        System.out.println("\n===== RESULTS =====");
        System.out.println("Total Marks: " + totalMarks + " out of " + (numOfSubjects * 100));
        System.out.println("Average Percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}