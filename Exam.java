
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class Exam {
        Question[] questions;
        Map<Integer, Integer> usersAnswers;

        Exam(Question[] questions) {
            this.questions = questions;
            this.usersAnswers = new HashMap<>();
        }

        void displayQuestion(Question question) {
            System.out.println(question.text);
            for (int i = 0; i < question.options.length; i++) {
                System.out.println((i + 1) + ". " + question.options[i]);
            }
            System.out.println();
        }

        void conductExam() {
            Scanner scanner = new Scanner(System.in);

            for (int index = 0; index < questions.length; index++) {
                displayQuestion(questions[index]);
                while (true) {
                    try {
                        System.out.print("Select your answer for question " + (index + 1) + ": ");
                        int userAnswer = scanner.nextInt();
                        if (userAnswer >= 1 && userAnswer <= questions[index].options.length) {
                            usersAnswers.put(index + 1, userAnswer);
                            break;
                        } else {
                            System.out.println("Invalid option. Please select a valid option.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.next(); // Clear the input buffer
                    }
                }
            }
        }

        int evaluateExam() {
            int score = 0;
            for (Map.Entry<Integer, Integer> entry : usersAnswers.entrySet()) {
                int questionIndex = entry.getKey();
                int userAnswer = entry.getValue();
                if (userAnswer == questions[questionIndex - 1].correctOption) {
                    score++;
                }
            }
            return score;
        }
    }


