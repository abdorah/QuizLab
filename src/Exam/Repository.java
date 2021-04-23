package Exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Player.Player;

/**
 * @author KOTBI Abderrahmane
 * @version 1.0
 * <p>
 * This is the Repository abstracts class. It implements the Question
 * interface and stores the application users and quizs informations.
 * </p>
 */

public abstract class Repository implements Question {

    public static List<String> questions = new ArrayList<String>();
    public static HashMap<String, String> questionsAnswers = new HashMap<String, String>();
    public static List<Player> players = new ArrayList<Player>();

    static void questionsRepository() {
        questions.add("A");
        questionsAnswers.put("A", "A");
        questions.add("B");
        questionsAnswers.put("B", "B");
        questions.add("C");
        questionsAnswers.put("C", "C");
        questions.add("D");
        questionsAnswers.put("D", "D");
        questions.add("E");
        questionsAnswers.put("E", "E");
        questions.add("F");
        questionsAnswers.put("F", "F");
        questions.add("G");
        questionsAnswers.put("G", "G");
    }

    static void playersRepository() {
        players.add(new Player("Mohamed", 0));
        players.add(new Player("Abderrahmane", 0));
        players.add(new Player("Hajar", 0));
        players.add(new Player("Omar", 0));
        players.add(new Player("Youssef", 0));
    }

    abstract String getQuestionByNumber(int questionNumber);

    abstract String getAnswerByQuestion(String question);

    abstract Player getPlayerByName(String name);

    abstract void updateScore(String questionNumber, String answerNumber);

    abstract Player addPlayer(String name);

    abstract void updatePlayer(String name);
}
