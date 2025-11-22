package src.Core;

import src.IO.Output;
import src.IO.Input;
import src.Battle;
import java.util.Random;
import src.Default.DefaultReader;

// Manages the overall game flow if user wants to play again we are creating a new instance of this 
// so that all game data is reset.
public class GameManager {

    private Random rand = new Random();

    private Board board;
    private Piece partyPiece;   
    private User user;
    
    // constructor 
    public GameManager() {
        setupGame();
    }


    // sets up the game by initializing user, party, and board
    private void setupGame() {
        Output.gameInitializationMessage(); // shows the initial banner
        Output.someSpace(); // spacing

        String name = Input.getUsername(); // get username 

        this.user = new User(name); // create new user

        int partySize = Input.getPartySize(); // get party size
        this.user.getParty().initializeParty(partySize); // initialize party with size


        // generate a new board until it is playable
        this.board = new Board(DefaultReader.getDefaultSettings("board_size"));
        while(!board.isBoardPlayable()){
            this.board = new Board(DefaultReader.getDefaultSettings("board_size"));
        }


        // this part finds the first accessible tile for placing the party

        int startRow = 0; 
        int startCol = 0;
        boolean found = false;
        for (int r = 0; r < board.getSize() && !found; r++) {
            for (int c = 0; c < board.getSize(); c++) {
                if (board.getTile(r, c).isAccessible()) {
                    startRow = r;
                    startCol = c;
                    found = true;
                    break;   
                }
            }
        }

        // place the party on the found tile
        this.partyPiece = new Piece(startRow, startCol);
    }


    // starts the main game loop
    public void start() {

        Output.displaySecondWelcomeMessage(user);
        
        // main game loop
        boolean running = true;
        while (running) {
            // if user not in market or battle then user should see the main flow.
            if (!user.isInMarket() && !user.isInBattle()) {
                board.printBoard(partyPiece.getRow(), partyPiece.getCol());
                Output.printMenu();
                running = Input.getInput(this);
            }
        }
        // game ended print thank you message
        Output.print("Thanks for playing!");
    }


    // handles if there is going to be a battle on the common tile when party reaches there
    public void handleTileEvent() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile == null) return;

        if (tile.isCommon()) {
            int encounterChance = rand.nextInt(100);
            if (encounterChance < DefaultReader.getDefaultSettings("battle_probability_percent")) {  // battle probability from settings
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

    // tries to enter market if party is on a market tile
    public void tryEnterMarket() {
        Tile tile = board.getTile(partyPiece.getRow(), partyPiece.getCol());
        if (tile != null && tile.isMarket()) {
            
            user.setInMarket(true);
            tile.getMarket().start(user);
        } 
        else {
            Output.print("You are not standing on a market tile.");
            Output.sleep(2000);
        }
    }


    // getters
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
