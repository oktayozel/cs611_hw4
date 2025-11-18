package src.Item;

public class Weapon extends Item {
    private int damage;
    private int hands;

    public Weapon(String name, int price, int level, int damage, int hands) {
        super(name, price, level);
        this.damage = damage;
        this.hands = hands;
    }

    public int getDamage() {
        return damage;
    }

    public int getHands() {
        return hands;
    }
    public String toString() {
        return String.format("%s (Price: %d, Level: %d, Damage: %d, Hands: %d)", getName(), getPrice(), getLevel(), damage, hands);
    }
}
