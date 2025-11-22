package src.Item;

public class Armor extends Item {
    private int damageReduction;
    private int durability;
    private int maxDurability;

    public Armor(String name, int price, int level, int damageReduction ) {
        super(name, price, level);
        this.damageReduction = damageReduction;
        this.maxDurability = 10;  // Default: 10 uses
        this.durability = maxDurability;
    }

    public int getDamageReduction() {
        return damageReduction;
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
        return String.format("[Armor] %s %s (Price: %d, Level: %d, Damage Reduction: %d)" ,getName(), durabilityStr, getPrice(), getLevel(), damageReduction);

    }
}
