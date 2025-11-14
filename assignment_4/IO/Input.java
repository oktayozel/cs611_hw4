package IO;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    // Common method to handle input and check for the quit command 'Q'
    public String getInput() {
        String input = scanner.nextLine().trim().toLowerCase();

        if (input.equals("q")) {
            System.out.println("Exiting the game...");
            System.exit(0);  // Exits the game
        }
        return input;
    }

    public String getMoveDirection() {
        System.out.println("Enter your move (WASD): ");
        String input = getInput();

        while (!input.matches("[wsad]")) {
            System.out.println("Invalid input. Use W (up), A (left), S (down), or D (right): ");
            input = getInput();
        }
        return input;
    }
}
