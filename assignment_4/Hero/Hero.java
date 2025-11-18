package assignment_4.Hero;

import assignment_4.Inventory.Inventory;
import assignment_4.Item.Weapon;
import assignment_4.Item.Armor;

public class Hero {
    private String name;
    private int level;
    private int HP; // health points
    private int MP;// magic points
    private int strength;
    private int dexterity; // 
    private int agility;
    private int gold;
    private int experience;
    protected String heroClass;
    private Inventory inventory;
    private Weapon equippedWeapon; 
    private Armor equippedArmor;  

    public Hero(String name, int level, int HP, int MP, int strength, int dexterity, int agility, int gold, Inventory inventory) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.MP = MP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.inventory = inventory;
        this.experience = 0;
        this.equippedWeapon = null;
        this.equippedArmor = null;
    }

    //getters and setters 
    //getter for name
    public String getName() {
        return name;
    }
    // getter for level
    public int getLevel() {
        return level;
    }
    // getter for HP
    public int getHP() {
        return HP;
    }
    //getter for MP
    public int getMP() {
        return MP;
    }
    // getter for strength
    public int getStrength() {
        return strength;
    }
    // getter for dexterity
    public int getDexterity() {
        return dexterity;
    }
    // getter for agility
    public int getAgility() {
        return agility;
    }
    // getter for gold
    public int getGold() {
        return gold;
    }
    public int getExperience() {
        return experience;
    }
    // getter for inventory
    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getEquippedWeapon() { return equippedWeapon; }
    public Armor getEquippedArmor() { return equippedArmor; }
    public void setEquippedWeapon(Weapon w) { this.equippedWeapon = w; }
    public void setEquippedArmor(Armor a) { this.equippedArmor = a; }
    public void addExperience(int xp) { if (xp > 0) this.experience += xp; }
    public void setExperience(int xp) { this.experience = Math.max(0, xp); }

    // Add gold to hero (e.g. from selling or battle rewards)
    public void addGold(int amount) {
        if (amount <= 0) return;
        this.gold += amount;
    }

    // Attempt to spend gold; return true if successful
    public boolean spendGold(int amount) {
        if (amount <= 0) return true; // spending 0 succeeds trivially
        if (amount > gold) return false;
        gold -= amount;
        return true;
    }

    // Convenience: set gold directly (use cautiously)
    public void setGold(int gold) {
        this.gold = Math.max(0, gold);
    }

    public String getHeroClass() {
        return heroClass;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "Name='" + name + '\'' +
                ", Level=" + level +
                ", HP=" + HP +
                ", MP=" + MP +
                ", EXP=" + experience +
                ", Gold=" + gold +
                '}';
    }


}
