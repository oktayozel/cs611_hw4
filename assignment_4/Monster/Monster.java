package Monster;
public class Monster {
    private String name;
    private int level;
    private int HP; // health points
    private int baseDamage;
    private int defense;
    private double dodge; // dodge ability

    public Monster(String name, int level, int HP, int baseDamage, int defense, double dodge) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.dodge = dodge;
    }
}
