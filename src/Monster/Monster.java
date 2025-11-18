package src.Monster;
public class Monster {
    private String name;
    private int level;
    private int HP; // health points
    private int baseDamage;
    private int defense;
    private double dodge; // dodge ability (0..1)

    public Monster(String name, int level, int HP, int baseDamage, int defense, double dodge) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.baseDamage = baseDamage;
        this.defense = defense;
        this.dodge = dodge;
    }
    
    // getters for monster attributes
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getHP() { return HP; }
    public int getBaseDamage() { return baseDamage; }
    public int getDefense() { return defense; }
    public double getDodge() { return dodge; }

    // check if monster is defeated
    public boolean isDefeated() { return HP <= 0; }

    // apply damage to the monster
    public void takeDamage(int amount) {
        int dmg = Math.max(0, amount);
        HP -= dmg;
        if (HP < 0) HP = 0;
    }

    // recuce the spell effect 
    public void reduceBaseDamageBy10Percent() {
        baseDamage = (int)Math.max(0, Math.round(baseDamage * 0.9));
    }
    // reduce the defense effect
    public void reduceDefenseBy10Percent() {
        defense = (int)Math.max(0, Math.round(defense * 0.9));
    }

    public void reduceDodgeBy10Percent() {
        dodge = Math.max(0.0, dodge * 0.9);
    }

}
