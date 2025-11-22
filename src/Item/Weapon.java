package src.Item;

public class Weapon extends Item {
    private int damage;
    private int hands;
    private int durability;
    private int maxDurability;

    public Weapon(String name, int price, int level, int damage, int hands) {
        super(name, price, level);
        this.damage = damage;
        this.hands = hands;
        this.maxDurability = 10;  // Default: 10 uses
        this.durability = maxDurability;
    }

    public int getDamage() {
        return damage;
    }

    public int getHands() {
        return hands;
    }
    
    public int getDurability() {
        return durability;
    }
    
    public int getMaxDurability() {
        return maxDurability;
    }
    
    public boolean isBroken() {
        return durability <= 0;
    }
    
    public void useDurability() {
        if (durability > 0) {
            durability--;
        }
    }
    
    public void repair() {
        durability = maxDurability;
    }
    
    public String toString() {
        String durabilityStr = isBroken() ? "(BROKEN)" : "(" + durability + "/" + maxDurability + ")";
        return String.format("[Weapon] %s %s (Price: %d, Level: %d, Damage: %d, Hands: %d)", getName(), durabilityStr, getPrice(), getLevel(), damage, hands);
    }
}
