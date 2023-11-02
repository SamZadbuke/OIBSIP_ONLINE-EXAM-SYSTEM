import java.util.Scanner;

public class ConsoleUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample questions for the exam
        Question[] questions = {
                new Question("What is the capital of France?", new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 2),
                new Question("Which planet is known as the Red Planet?",
                        new String[]{"Earth", "Mars", "Venus", "Jupiter"}, 2),
                new Question("What is the largest mammal?",
                        new String[]{"Elephant", "Whale", "Giraffe", "Dolphin"}, 2)
        };

        // Login
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        Users user = new Users(username, password);

        while (true) {
            // Menu
            System.out.println("\nMenu:");
            System.out.println("1. Update Profile");
            System.out.println("2. Change Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Update Profile
                    System.out.println("Profile updated successfully.");
                    break;
                case 2:
                    // Change Password
                    System.out.print("Enter your new password: ");
                    user.password = scanner.next();
                    System.out.println("Password updated successfully.");
                    break;
                case 3:
                    // Start Exam
                    Exam exam = new Exam(questions);
                    exam.conductExam();
                    int score = exam.evaluateExam();
                    System.out.println("Your score: " + score + "/" + questions.length);
                    break;
                case 4:
                    // Logout
                    System.out.println("Logging out. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}
