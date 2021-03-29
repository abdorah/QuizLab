package Exam;

import java.util.List;

public interface Question {

    void chooseAccount(String name);

    List<String> takeQuiz();

    boolean answerIsCorrect(String question, String answer);
}
