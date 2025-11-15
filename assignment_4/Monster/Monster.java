package assignment_4.Monster;
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
    
    // getters for monster attributes
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHP() {
        return HP;
    }   
    public int getBaseDamage() {
        return baseDamage;
    }
    public int getDefense() {
        return defense;
    }
    public double getDodge() {
        return dodge;
    }
}
