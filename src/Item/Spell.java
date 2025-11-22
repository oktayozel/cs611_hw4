package src.Item;

public class Spell extends Item{
    private int damage;
    private int manaCost;
    private String spellType;

    public Spell(String name, int price, int level, int damage, int manaCost, String spellType) {
        super(name, price, level);
        this.damage = damage;
        this.manaCost = manaCost;
        this.spellType = spellType;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getSpellType() {
        return spellType;
    }
    public String toString() {
        return String.format("[Spell] %s (Price: %d, Level: %d, Spell Type: %s, Damage: %d, Mana Cost: %d)", getName(), getPrice(), getLevel(), spellType, damage, manaCost);
    }
}
