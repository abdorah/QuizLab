package Exam;

import java.util.List;

/**
 * @author KOTBI Abderrahmane
 * @version 1.0
 * <p>
 * This is the Question interface. It consists of the methods that
 * manages the quiz's questions and the user's answers.
 * </p>
 */

public interface Question {

    void chooseAccount(String name);

    List<String> takeQuiz();

    boolean answerIsCorrect(String question, String answer);
}
