package assignment_4.Hero;

import assignment_4.Inventory.Inventory;

public class Hero {
    private String name;
    private int level;
    private int HP; // health points
    private int MP;// magic points
    private int strength;
    private int dexterity; // 
    private int agility;
    private int gold;
    private Inventory inventory;

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
    // getter for inventory
    public Inventory getInventory() {
        return inventory;
    }


}
