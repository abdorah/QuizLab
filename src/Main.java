import Presentation.Presentation;

class Main {

    public static void main(String[] args) {

        Presentation presentation = new Presentation();
        System.out.println("Welcome into QuizLab!\n To start a quiz please first sign in or sign up.\n"
                + "to learn exactly how to do it enter either the \">choose a player\" command, or\n"
                + "\">add player\" command.");
        boolean BeforeGameStart = presentation.initiateTheGame();
        while (!BeforeGameStart) {
            BeforeGameStart = presentation.initiateTheGame();
        }
        while (presentation.gameIsOn) {
            presentation.startPresentation();
        }
    }
}
