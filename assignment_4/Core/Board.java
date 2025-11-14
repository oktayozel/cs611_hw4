package assignment_4.Core;

import java.util.Random;

public class Board {

    private final int size;
    private final Tile[][] grid;
    private final Random random = new Random();

    public Board(int size) {
        this.size = size;
        this.grid = new Tile[size][size];
        generateRandomLayout();
    }

    public int getSize() {
        return size;
    }

    public boolean isInside(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public Tile getTile(int row, int col) {
        if (!isInside(row, col)) return null;
        return grid[row][col];
    }

    // %20 inaccessible, 30% market, 50% common
    private void generateRandomLayout() {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                double p = random.nextDouble();
                Tile.Type type;
                if (p < 0.20) {
                    type = Tile.Type.INACCESSIBLE;
                } else if (p < 0.50) { 
                    type = Tile.Type.MARKET;
                } else {
                    type = Tile.Type.COMMON;
                }
                grid[r][c] = new Tile(r, c, type);
            }
        }
    }

    public void printBoard(int partyRow, int partyCol) {
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
}
