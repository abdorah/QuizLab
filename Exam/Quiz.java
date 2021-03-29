package Exam;

import java.util.List;

import Player.Player;

public class Quiz extends Repository {

    static Player player;

    public Quiz() {
        questionsRepository();
        playersRepository();
    }

    @Override
    public boolean answerIsCorrect(String question, String answer) {

        for (int i = 0; i < questionsAnswers.values().size(); i++) {
            if (question.equals(questions.get(i)) && questionsAnswers.get(questions.get(i)).equals(answer)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void chooseAccount(String name) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                player = players.get(i);
            }
        }
    }

    @Override
    public List<String> takeQuiz() {
        return questions;
    }

    @Override
    public String getQuestionByNumber(int questionNumber) {
        return questions.get(questionNumber);
    }

    @Override
    public String getAnswerByQuestion(String question) {
        return questionsAnswers.get(question);
    }

    @Override
    public void updateScore(String question, String answer) {
        if (answerIsCorrect(question, answer)) {
            player.setHighScore(player.getHighScore() + 1);
            int i;
            for (i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(player.getName())) {
                    break;
                }
            }
            players.set(i, player);
        }
    }

    @Override
    public Player getPlayerByName(String name) {
        player = new Player();
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                player = players.get(i);
                break;
            }
        }
        return player;
    }

    @Override
    public Player addPlayer(String name) {
        Player player;
        boolean playerAlreadyExist = false;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(name)) {
                playerAlreadyExist = true;
                System.out.println("User Already exist! Please provid an other name.");
            }
        }
        if (!playerAlreadyExist) {
            player = new Player(name, 0);
            players.add(player);
            return player;
        } else {
            return new Player();
        }
    }

    @Override
    public void updatePlayer(String name) {
        boolean playerUpdated = false;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName().equals(player.getName())) {
                players.get(i).setName(name);
                playerUpdated = true;
                break;
            }
        }
        if (!playerUpdated) {
            System.out.println("User not found! Please provid an other name.");   
        }
    }
}
