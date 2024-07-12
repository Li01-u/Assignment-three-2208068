import java.io.IOException;

public class ExamProgram {
    public static void main(String[] args) throws IOException {
        int choice;
        int cat1 = 0, cat2 = 0, ass1 = 0, ass2 = 0, ass3 = 0, finalExam = 0;
        double coursework = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Enter your choice: ");
            
            choice = readChoice();
            
            switch (choice) {
                case 1:
                    // View coursework results
                    cat1 = readScore("Enter CAT 1 score: ");
                    cat2 = readScore("Enter CAT 2 score: ");
                    ass1 = readScore("Enter Assignment 1 score: ");
                    ass2 = readScore("Enter Assignment 2 score: ");
                    ass3 = readScore("Enter Assignment 3 score: ");
                    
                    int[] assessments = {cat1, cat2, ass1, ass2, ass3};
                    coursework = computeCoursework(assessments);
                    
                    System.out.println("Coursework Results:");
                    System.out.println("CAT 1: " + cat1 + "%");
                    System.out.println("CAT 2: " + cat2 + "%");
                    System.out.println("Assignment 1: " + ass1 + "%");
                    System.out.println("Assignment 2: " + ass2 + "%");
                    System.out.println("Assignment 3: " + ass3 + "%");
                    System.out.println("Coursework Score (50% of total): " + coursework + "%");
                    System.out.println();

                    checkCourseworkCompletion(assessments);
                    break;

                case 2:
                    // View exam results
                    finalExam = readScore("Enter final exam score: ");
                    double totalScore = finalExam * 0.50 + coursework;
                    
                    System.out.println("Exam Results:");
                    System.out.println("Final Exam Score (50% of total): " + finalExam * 0.50 + "%");
                    System.out.println("Total Score (100%): " + totalScore + "%");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 3);
    }

    public static int readChoice() throws IOException {
        int choice = 0;
        int input;

        while ((input = System.in.read()) != '\n') {
            if (input >= '0' && input <= '9') {
                choice = choice * 10 + (input - '0');
            } else {
                System.out.println("Invalid input. Please enter a number.");
                while ((input = System.in.read()) != '\n');
                return readChoice();
            }
        }

        return choice;
    }

    public static int readScore(String prompt) throws IOException {
        System.out.print(prompt);
        return readChoice();
    }

    public static double computeCoursework(int[] assessments) {
        int total = 0;
        for (int i = 0; i < assessments.length; i++) {
            total += assessments[i];
        }
        return total / 5.0 * 0.50;
    }

    public static void checkCourseworkCompletion(int[] assessments) {
        int count = assessments.length;
        double requiredCompletion = assessments.length * (2.0 / 3.0);
        if (count >= requiredCompletion) {
            System.out.println("The student has completed 2/3 of the coursework.");
        } else {
            System.out.println("The student has not completed 2/3 of the coursework and must repeat the unit irrespective of the final exam grade.");
        }
    }
}