public class Question {
    String text;
    String[] options;
    int correctOption;

    Question(String text, String[] options, int correctOption) {
        this.text = text;
        this.options = options;
        this.correctOption = correctOption;
    }
}
