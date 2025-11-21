package src.Core;

import src.Market.Market; 

// the Tile class represents each tile on the board
public class Tile {


    // 3 types of tiles
    public enum Type {
        INACCESSIBLE,
        MARKET,
        COMMON
    }

    private final int row;
    private final int col;
    private final Type type;
    private final Market market;  

    // constructor
    public Tile(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
        this.market = (type == Type.MARKET) ? new Market() : null;
    }

    // helpers
    public boolean isAccessible() {
        return type != Type.INACCESSIBLE;
    }

    public boolean isMarket() {
        return type == Type.MARKET;
    }

    public boolean isCommon() {
        return type == Type.COMMON;
    }

    // getters
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Type getType() {
        return type;
    }

    public Market getMarket() {
        if (isMarket()) {
            return market;
        }
        return null;
    }


    public char getSymbol(boolean hasPartyHere) {
        if (hasPartyHere) {
            return 'P';
        }
        if(type == Type.INACCESSIBLE){
            return 'X';
        }
        if(type == Type.MARKET){
            return 'M';
        }
        if(type == Type.COMMON){
            return ' ';
        }
        
        return ' ';
    }
}
