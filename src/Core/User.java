package src.Core;


// the class that represents a user in the game
public class User {

    private String name;
    private Party party;
    private boolean inMarket;
    private boolean inBattle;

    // constructor
    public User(String name) {
        this.name = name;
        this.party = new Party();
        this.inMarket = false;
        this.inBattle = false;
    }


    // to control whether user in main loop or in other places
    public boolean isInMarket() {
        return inMarket;
    }
    public void setInMarket(boolean inMarket) {
        this.inMarket = inMarket;
    }
    public boolean isInBattle() {
        return inBattle;
    }
    public void setInBattle(boolean inBattle) {
        this.inBattle = inBattle;
    }   

    // getters
    public String getName() {
        return name;
    }
    public Party getParty() {
        return party;
    }


}
