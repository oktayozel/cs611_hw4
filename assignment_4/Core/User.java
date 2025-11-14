package assignment_4.Core;

public class User {

    private String name;
    private Party party;

    public User(String name) {
        this.name = name;
        this.party = new Party();
    }

    public String getName() {
        return name;
    }

}
