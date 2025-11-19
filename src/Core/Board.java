package src.Core;

import java.util.Random;

import IO.Output;
import src.Default.DefaultReader;

// represents the game board
public class Board {

    
    private final int size; // board is a square
    private final Tile[][] grid; // 2D array of tiles
    private final Random random = new Random();

    // constructor for the board
    public Board(int size) {
        this.size = size;
        this.grid = new Tile[size][size];
        generateRandomLayout();
    }


    // checks if the given coordinates are inside the board
    public boolean isInside(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    // returns the size of the board
    public int getSize() {
        return size;
    }
    // return the tile at the given coordinates
    public Tile getTile(int row, int col) {
        if (!isInside(row, col)) return null;
        return grid[row][col];
    }

    // generetes a random layout for the board based on default settings
    private void generateRandomLayout() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                double p = random.nextDouble();
                Tile.Type type;
                if (p < (double) DefaultReader.getDefaultSettings("inaccessible_ratio")/100) {
                    type = Tile.Type.INACCESSIBLE;
                } else if (p < (double) (DefaultReader.getDefaultSettings("market_ratio") + DefaultReader.getDefaultSettings("inaccessible_ratio"))/100) {
                    type = Tile.Type.MARKET;
                } else {
                    type = Tile.Type.COMMON;
                }
                grid[r][c] = new Tile(r, c, type);
            }
        }
    }

    // prints the board to the console, having it here simplifies the code in Output.java however it can be moved there if needed
    public void printBoard(int partyRow, int partyCol) {
        Output.clearScreen();
        Output.boardBanner();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                System.out.print("+---");
            }
            System.out.println("+");

            for (int c = 0; c < size; c++) {
                Tile tile = grid[r][c];
                boolean hasParty = (r == partyRow && c == partyCol);
                char symbol = tile.getSymbol(hasParty);
                System.out.print("| " + symbol + " ");
            }
            System.out.println("|");
        }
        for (int c = 0; c < size; c++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    // checking if the P has space to move which is same as chechin 0,1 and 1,0 are not X.
    public boolean isBoardPlayable(){
        return grid[0][1].isAccessible() || grid[1][0].isAccessible();
    }
}
