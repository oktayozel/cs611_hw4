package src;
import src.Core.GameManager;


public class Main {
    public static void main(String[] args) {
        Statistics stats = new Statistics();
        GameManager gameManager = new GameManager(stats);
        gameManager.start();
    }
}


