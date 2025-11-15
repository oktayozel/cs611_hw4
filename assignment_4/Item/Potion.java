package assignment_4.Item;

public class Potion extends Item {

    private int effectAmount;
    private String effectType;

    public Potion(String name, int price, int level, int effectAmount, String effectType) {
        super(name, price, level);
        this.effectAmount = effectAmount;
        this.effectType = effectType;
    }

    public int getEffectAmount() {
        return effectAmount;
    }

    public String getEffectType() {
        return effectType;
    }
}
