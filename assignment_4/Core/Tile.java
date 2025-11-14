package assignment_4.Core;

public class Tile {

    public enum Type {
        INACCESSIBLE,
        MARKET,
        COMMON
    }

    private final int row;
    private final int col;
    private final Type type;

    public Tile(int row, int col, Type type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Type getType() {
        return type;
    }

    public boolean isAccessible() {
        return type != Type.INACCESSIBLE;
    }

    public boolean isMarket() {
        return type == Type.MARKET;
    }

    public boolean isCommon() {
        return type == Type.COMMON;
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

    }
}
