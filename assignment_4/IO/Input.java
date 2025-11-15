package IO;
import java.util.Scanner;

import assignment_4.Core.GameManager;
import assignment_4.Core.Piece;
public  class Input {
    private static Scanner scanner = new Scanner(System.in);

    public Input() {
    }


    public static void isGameExit(String input){
        if (input.equals("Q")) {
            System.out.println("Exiting the game...");
            System.exit(0);  
        }
    }

    public static String getUsername(){
        String name = scanner.nextLine();
        isGameExit(name);
        return name;
    }
    public static boolean getInput(GameManager gm) {
        boolean running = true;
        String input;
        while(true){
            input = scanner.nextLine().trim().toUpperCase();
        if (!input.equals("W") &&
            !input.equals("A") &&
            !input.equals("S") &&
            !input.equals("D") &&
            !input.equals("I") &&
            !input.equals("M") &&
            !input.equals("Q")) {
            
            System.out.println("Invalid input. Please try again.");
            }
        else {
                isGameExit(input);
                break;
            }
        }

        if (input.equals("W")) {
            if (gm.getPartyPiece().moveUp(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("A")) {
            if (gm.getPartyPiece().moveLeft(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("S")) {
            if (gm.getPartyPiece().moveDown(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("D")) {
            if (gm.getPartyPiece().moveRight(gm.getBoard())) {
                gm.handleTileEvent();
            }

        } else if (input.equals("I")) {
            gm.getUser().getParty().printPartyInfo();

        } else if (input.equals("M")) {
            gm.tryEnterMarket();

        } else if (input.equals("Q")) {
            running = false;

        } else {
            System.out.println("Unknown command.");
        }
        return running;

    }

    public static boolean getMarketInput(GameManager gm) {
        boolean running = true;
        String input;
        while(true){
            input = scanner.nextLine().trim().toUpperCase();
        if (!input.equals("W") &&
            !input.equals("S") &&
            !input.equals("B") &&
            !input.equals("S") &&
            !input.equals("Q")) {
            
            System.out.println("Invalid input. Please try again.");
            }
        else {
                isGameExit(input);
                break;
            }
        }

        if (input.equals("W")) {
            // implement move up in market here
            System.out.println("Move up in market - feature not implemented yet.");

        } 

        else if (input.equals("S")) {
            // implement move down in market here
            System.out.println("Move down in market - feature not implemented yet.");

        } 

        else if (input.equals("B")) {
            // implement buy here
            System.out.println("Buy hero - feature not implemented yet.");

        } else if (input.equals("S")) {
            // implement sell here
            System.out.println("Sell hero - feature not implemented yet.");

        } else if (input.equals("Q")) {
            running = false;

        } else {
            System.out.println("Unknown command.");
        }
        return running;

    }






}
