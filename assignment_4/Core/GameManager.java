package assignment_4.Core;

import java.util.Scanner;
import IO.Output;
import IO.Input;
import assignment_4.Battle;

public class GameManager {

    private static final int DEFAULT_BOARD_SIZE = 8;

    private Board board;
    private Piece partyPiece;   
    private User user;
    
    public GameManager() {
        setupGame();
    }

    private void setupGame() {
        Output.gameInitialization();
        Output.someSpace();
        Output.print("Enter your name: ");
        String name = Input.getUsername();
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

            if (user.isInMarket()) {
                Output.printMarketMenu();
                running = Input.getMarketInput(this);
            }
            if( user.isInBattle()){
                Battle battle = new Battle(this);
                battle.start();
            }
            else{
                board.printBoard(partyPiece.getRow(), partyPiece.getCol());
                Output.printMenu();

                running = Input.getInput(this);


            }
        }

        System.out.println("Thanks for playing!");
    }



    public void handleTileEvent() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile == null) return;

        if (tile.isCommon()) {
            
            System.out.println("Battle starts now!");
            user.setInBattle(true);
        }
    }

    public void tryEnterMarket() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile != null && tile.isMarket()) {

            Output.displayMarket(tile.getMarket());
            user.setInMarket(true);
        } else {
            System.out.println("You are not standing on a market tile.");
        }
    }
    public Board getBoard() {
        return board;
    }
    public User getUser() {
        return user;
    }
    public Piece getPartyPiece() {
        return partyPiece;
    }
}
