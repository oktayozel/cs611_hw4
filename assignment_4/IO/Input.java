package IO;
import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public void isGameExit(String input){
        if (input.equals("q")) {
            System.out.println("Exiting the game...");
            System.exit(0);  
        }
    }

    public String getInput() {
        while(true){
            String input = scanner.nextLine().trim().toLowerCase();
            if(input!= "w" && input!= "a" && input!= "s" && input!= "d"  && input!= "i"  && input!= "m"  && input!= "q"){
                System.out.println("Invalid input. Please try again.");
            } else {
                isGameExit(input);
                return input;
            }
        }
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
