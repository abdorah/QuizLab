package Presentation;

import java.util.List;
import java.util.Scanner;

import Exam.Quiz;
import Player.Player;

public class Presentation {

    public Quiz quiz;
    public Player player;
    public boolean gameIsOn;
    public boolean signInPerformed;

    public Presentation() {
        this.gameIsOn = true;
        this.signInPerformed = false;
        this.quiz = new Quiz();
        this.player = new Player();
    }

    public String getAnswerFromUser() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        // scanner.close();
        if (!answer.isEmpty()) {
            return answer;
        }
        return getAnswerFromUser();
    }

    void helpCommand() {
        if (signInPerformed) {
            System.out.println("Hello and welcome into QuizLab! This is the help panel.\n"
                    + "To use this application all what you have to do is to pick\n"
                    + "one choice that you will find on your display.\n"
                    + "There are two types of answers: answers on the quiz \n"
                    + "questions that take only one answer, or command that\n"
                    + "you give so that you can choose an option in the application.\n"
                    + "For the second type, all what you have to right is \">\","
                    + "then you add a command from this list below:\n" + "quit: to quit the quiz\n"
                    + "start: to start a quiz\n" + "help: to see this help panel\n"
                    + "score: to see the high score of the current player\n" + "exit: to exit the game\n"
                    + "choose a player: to choose a player by giving his or her name\n"
                    + "add player: to add a new player\n" + "edit player: to edit the player's informations");
        } else {
            System.out.println("Hello and welcome into QuizLab! This is the help panel.\n"
                    + "To use this application you have to sign in or sign up first.\n"
                    + "To do so, all what you have to right is \">\","
                    + "then you add a command from this list below:\n" + "help: to see this help panel\n"
                    + "exit: to exit the game\n" + "choose a player: to choose a player by giving his or her name\n"
                    + "add player: to add a new player\n");
        }
    }

    void startCommand() {
        List<String> exam = this.quiz.takeQuiz();
        String answer;
        for (int i = 0; i < exam.size(); i++) {
            System.out.println("question" + i + ": " + exam.get(i));
            answer = this.getAnswerFromUser();
            if (answer.equals(">quit")) {
                quitCommand();
                break;
            } else {
                System.out.println(this.quiz.answerIsCorrect(exam.get(i), answer) ? "correct answer" : "wrong answer");
                quiz.updateScore(exam.get(i), answer);
            }
        }

    }

    void addPlayerCommand() {
        System.out.println("Please insert your name:\n");
        player = quiz.addPlayer(getAnswerFromUser());
        if (player.equals(null)) {
            System.out.println("Player saving error!");
        } else {
            System.out.println("Welcome to the game: " + player.getName() + ".\n Now your journey begin!\n");
        }
    }

    void highScoreCommand() {
        System.out.println("The player " + player.getName() + "'s high score is: " + player.getHighScore());
    }

    void choosePlayerCommand() {
        System.out.println("Please insert your name:\n");
        String answer = "";
        answer = getAnswerFromUser();
        if (!answer.isEmpty()) {
            this.player = this.quiz.getPlayerByName(answer);
            if (!this.player.getName().equals("")) {
                System.out.println("The current connected player is: " + this.player.getName() + ".\n Welcome again!");
            } else {
                System.out.println("Player unrecognized! Please retry to insert you name.\n");
                choosePlayerCommand();
            }
        }
    }

    void editPlayerCommand() {
        System.out.println("Please insert your new name:\n");
        quiz.updatePlayer(getAnswerFromUser());
        System.out.println("What a great name for a great player " + player.getName() + "!\n");
    }

    void quitCommand() {
        System.out.println("QuizLab\n So what's gonna be your next goal?\n" + "It's your decision to take.\n");
    }

    void exitCommand() {
        System.out.println("Good by for the moment.\n"
                + "Remember that the greatest players don't stop till they acheive their goals!\n");
        gameIsOn = false;
    }

    public boolean initiateTheGame() {
        String answer = getAnswerFromUser();
        switch (answer) {
        case ">help":
            helpCommand();
            break;
        case ">choose a player":
            choosePlayerCommand();
            this.signInPerformed = true;
            break;
        case ">add player":
            addPlayerCommand();
            this.signInPerformed = true;
            break;
        default:
            this.signInPerformed = false;
            System.out.println("the provided command is unkown .\n"
                    + "Please try to get help by typing the command \">help\" to open the help panel.");
            break;
        }
        return signInPerformed;
    }

    public void startPresentation() {
        String answer = getAnswerFromUser();
        switch (answer) {
        case ">start":
            startCommand();
            break;
        case ">score":
            highScoreCommand();
            break;
        case ">help":
            helpCommand();
            break;
        case ">exit":
            exitCommand();
            break;
        case ">quit":
            quitCommand();
            break;
        case ">edit player":
            editPlayerCommand();
            break;
        default:
            System.out.println("the provided command is unkown .\n"
                    + "Please try to get help by typing the command \">help\" to open the help panel.");
            break;
        }
    }
}