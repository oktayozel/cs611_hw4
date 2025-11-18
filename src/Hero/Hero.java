package src.Hero;

import src.Inventory.Inventory;
import src.Item.Weapon;
import src.Item.Armor;
import src.Item.Potion;

public class Hero {
    private String name;
    private int level;
    private int HP; // health points
    private int MP; // magic points
    private int strength;
    private int dexterity;
    private int agility;
    private int gold;
    private int experience; // XP
    protected String heroClass;
    private Inventory inventory;
    private Weapon equippedWeapon;  // if the hero has equipped a weapon
    private Armor equippedArmor;   // if the hero has equipped an armor

    public Hero(String name, int level, int HP, int MP, int strength, int dexterity, int agility, int gold, Inventory inventory) {
        this.name = name;
        this.level = level;
        this.HP = HP;
        this.MP = MP;
        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
        this.gold = gold;
        this.experience = 0;
        this.inventory = inventory;
        this.equippedWeapon = null;
        this.equippedArmor = null;
    }





    // Gold helpers
    public void addGold(int amount) { if (amount > 0) this.gold += amount; }
    public boolean spendGold(int amount) {
        if (amount <= 0) return true;
        if (amount > gold) return false;
        gold -= amount; return true;
    }
    public void setGold(int gold) { this.gold = Math.max(0, gold); }

    // Experience helpers
    
    public void addExperience(int xp) { if (xp > 0) this.experience += xp; }
    public void setExperience(int xp) { this.experience = Math.max(0, xp); }


    public double getDodgeChance() {
        double chance = agility * 0.002; // spec: agility * 0.002
        if (chance < 0) chance = 0;
        if (chance > 0.6) chance = 0.6; // optional safety cap
        return chance;
    }

    public int computeAttackDamage() {
        int weaponDamage = (equippedWeapon != null ? equippedWeapon.getDamage() : 0);
        double raw = (strength + weaponDamage) * 0.05; // spec
        return Math.max(1, (int)Math.round(raw));
    }

    public int getArmorReduction() {
        return (equippedArmor != null ? equippedArmor.getDamageReduction() : 0);
    }

    public void takeDamage(int amount) {
        int dmg = Math.max(0, amount - getArmorReduction());
        HP -= dmg;
        if (HP < 0) HP = 0;
    }

    public boolean isFainted() { return HP <= 0; }

    public void healHP(int amount) { if (amount > 0) HP += amount; }
    public boolean spendMP(int amount) {
        if (amount < 0) return false;
        if (MP < amount) return false;
        MP -= amount; return true;
    }
    public void restoreMP(int amount) { if (amount > 0) MP += amount; }

    public void regenAfterRound() {
        if (!isFainted()) {
            HP = (int)Math.round(HP * 1.1);
            MP = (int)Math.round(MP * 1.1);
        }
    }

    public void reviveHalf() {
        if (isFainted()) {
            int baseHP = Math.max(1, level * 100);
            HP = Math.max(1, baseHP / 2);
            MP = Math.max(1, MP / 2);
        }
    }

    public void applyPotion(Potion p) {
        if (p == null) return;
        String type = p.getEffectType();
        int amount = p.getEffectAmount();
        if (type == null) return;
        switch (type.toUpperCase()) {
            case "HP": healHP(amount); break;
            case "MP": restoreMP(amount); break;
            case "STRENGTH": strength += amount; break;
            case "DEXTERITY": dexterity += amount; break;
            case "AGILITY": agility += amount; break;
            case "DEFENSE": /* extend later if needed */ break;
            default: break;
        }
    }

    // level up logic for the hero
    public boolean checkLevelUp() {
        boolean leveled = false;
        while (experience >= level * 10) {
            level++;
            leveled = true;

            // HP refresh  and starts increase
            HP = level * 100; 
            MP = (int)Math.round(MP * 1.10);
            strength = (int)Math.max(1, Math.round(strength * 1.05));
            dexterity = (int)Math.max(1, Math.round(dexterity * 1.05));
            agility = (int)Math.max(1, Math.round(agility * 1.05));

            // some extra increases
            if ("Warrior".equals(heroClass)) {
                strength = (int)Math.max(1, Math.round(strength * 1.05));
                agility  = (int)Math.max(1, Math.round(agility  * 1.05));
            } else if ("Sorcerer".equals(heroClass)) {
                dexterity = (int)Math.max(1, Math.round(dexterity * 1.05));
                agility   = (int)Math.max(1, Math.round(agility   * 1.05));
            } else if ("Paladin".equals(heroClass)) {
                strength = (int)Math.max(1, Math.round(strength * 1.05));
                dexterity = (int)Math.max(1, Math.round(dexterity * 1.05));
            }
        }
        if (leveled) {
            System.out.println(name + " leveled up! New level: " + level);
        }
        return leveled;
    }
    // Basic getters
    public String getName(){ 
        return name; 
    }
    public int getLevel() { 
        return level; 
    }
    public int getHP() { 
        return HP; 
    }
    public int getMP() { 
        return MP; 
    }
    public int getStrength() { 
        return strength; 
    }
    public int getDexterity() { 
        return dexterity; 
    }
    public int getAgility() { 
        return agility; 
    }
    public int getGold() { 
        return gold; 
    }
    public int getExperience() { 
        return experience; 
    }
    public Inventory getInventory() { 
        return inventory; 
    }
    public String getHeroClass() { 
        return heroClass; 
    }
    public Weapon getEquippedWeapon() { 
        return equippedWeapon; 
    }
    public Armor getEquippedArmor() { 
        return equippedArmor; 
    }
    public void setEquippedWeapon(Weapon weapon) { 
        this.equippedWeapon = weapon; 
    }
    public void setEquippedArmor(Armor armor) { 
        this.equippedArmor = armor; 
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
