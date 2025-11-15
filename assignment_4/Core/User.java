package assignment_4.Core;

public class User {

    private String name;
    private Party party;
    private boolean inMarket;

    public User(String name) {
        this.name = name;
        this.party = new Party();
        this.inMarket = false;
    }

    public String getName() {
        return name;
    }
    public Party getParty() {
        return party;
    }
    public boolean isInMarket() {
        return inMarket;
    }
    public void setInMarket(boolean inMarket) {
        this.inMarket = inMarket;
    }

}
