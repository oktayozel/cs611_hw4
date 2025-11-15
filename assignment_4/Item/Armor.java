package assignment_4.Item;

public class Armor extends Item {
    private int damageReduction;

    public Armor(String name, int price, int level, int damageReduction ) {
        super(name, price, level);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }
}
