package src.Core;

import java.util.Scanner;
import IO.Output;
import IO.Input;
import src.Battle;
import java.util.Random;


public class GameManager {
    private Random rand = new Random();
    private static final int DEFAULT_BOARD_SIZE = 8;

    private Board board;
    private Piece partyPiece;   
    private User user;
    private int partySize;
    
    public GameManager() {
        setupGame();
    }

    private void setupGame() {
        Output.gameInitialization();
        Output.someSpace();
        Output.print("Enter your name: ");
        String name = Input.getUsername();
        this.user = new User(name);
        int partySize = Input.getPartySize();
        this.user.getParty().initializeParty(partySize);


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
        Output.displaySecondWelcomeMessage(user);
        
        boolean running = true;
        while (running) {

            if (!user.isInMarket() && !user.isInBattle()) {
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
            int encounterChance = rand.nextInt(10);
            if (encounterChance < 2) {  // %20 chance to battle
                Output.narrative("OH NO! Monsters here! Battle starts now!");
                user.setInBattle(true);
                Battle battle = new Battle(this);
                battle.start();    
            }
            else {
                Output.printRandomNoBattleMessage(encounterChance);
            }





        }
    }

    public void tryEnterMarket() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile != null && tile.isMarket()) {
            
            user.setInMarket(true);
            tile.getMarket().start(user);
            


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
