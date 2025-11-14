package assignment_4.Core;

import java.util.Scanner;

public class GameManager {

    private static final int DEFAULT_BOARD_SIZE = 8;

    private Board board;
    private Piece partyPiece;   
    private User user;
    private Scanner scanner;

    public GameManager() {
        this.scanner = new Scanner(System.in);
        setupGame();
    }

    private void setupGame() {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        this.user = new User(name);


        this.board = new Board(DEFAULT_BOARD_SIZE);

        int startRow = 0;
        int startCol = 0;
        outer:
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                if (board.getTile(r, c).isAccessible()) {
                    startRow = r;
                    startCol = c;
                    break outer;
                }
            }
        }
        this.partyPiece = new Piece(startRow, startCol);
    }

    public void start() {
        System.out.println("Welcome to Legends: Monsters and Heroes, " + user.getName() + "!");

        boolean running = true;
        while (running) {
            board.printBoard(partyPiece.getRow(), partyPiece.getCol());
            printMenu();

            String input = scanner.nextLine().trim().toUpperCase();
            switch (input) {
                case "W":
                    if (partyPiece.moveUp(board)) {
                        handleTileEvent();
                    }
                    break;
                case "A":
                    if (partyPiece.moveLeft(board)) {
                        handleTileEvent();
                    }
                    break;
                case "S":
                    if (partyPiece.moveDown(board)) {
                        handleTileEvent();
                    }
                    break;
                case "D":
                    if (partyPiece.moveRight(board)) {
                        handleTileEvent();
                    }
                    break;
                case "I":
                    user.getParty().printPartyInfo();
                    break;
                case "M":
                    tryEnterMarket();
                    break;
                case "Q":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown command.");
            }

        }

        System.out.println("Thanks for playing!");
    }

    private void printMenu() {
        System.out.println("\nControls:");
        System.out.println("W/A/S/D - move");
        System.out.println("I - show party info");
        System.out.println("M - enter market (if on market tile)");
        System.out.println("Q - quit");
        System.out.print("Your move: ");
    }

    private void handleTileEvent() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile == null) return;

        if (tile.isCommon()) {
            
            System.out.println("Battle starts now!");
        }
        // market tiles are handled by pressing 'M'
    }

    private void tryEnterMarket() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile != null && tile.isMarket()) {

            System.out.println("Market implementation");
        } else {
            System.out.println("You are not standing on a market tile.");
        }
    }
}
