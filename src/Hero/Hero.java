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


    // general constructor
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


    // adds gold
    public void addGold(int amount) { 
        if (amount > 0) this.gold += amount; 
    }

    // decreases gold if possible if not enough gold, return false
    public boolean spendGold(int amount) {
        if (amount <= 0) return true;
        if (amount > gold) return false;
        gold -= amount; return true;
    }
    // direct setter for gold
    public void setGold(int gold) { 
        this.gold = Math.max(0, gold); 
    }

    // Experience helpers
    public void addExperience(int xp) { 
        if (xp > 0) this.experience += xp;
    }
    public void setExperience(int xp) { 
        this.experience = Math.max(0, xp); 
    }





    // function to embed dodge chance
    public double getDodgeChance() {
        double chance = agility * 0.002; 
        if (chance < 0) chance = 0;
        if (chance > 0.6) chance = 0.6;
        return chance;
    }

    // computes attack damage
    public int computeAttackDamage() {
        int weaponDamage = (equippedWeapon != null ? equippedWeapon.getDamage() : 0);
        double raw = (strength + weaponDamage) * 0.05; 
        return Math.max(1, (int)Math.round(raw));
    }

    // damage reduces if armor is equipped.
    public int getArmorReduction() {
        return (equippedArmor != null ? equippedArmor.getDamageReduction() : 0);
    }

    // apply damage to the hero
    public void takeDamage(int amount) {
        int dmg = Math.max(0, amount - getArmorReduction());
        HP -= dmg;
        if (HP < 0) HP = 0;
    }


    // am i dead
    public boolean isFainted() { return HP <= 0; }

    // increase HP
    public void healHP(int amount) { 
        if (amount > 0) HP += amount; 
    }

    // decrease MP
    public boolean spendMP(int amount) {
        if (amount < 0) return false;
        if (MP < amount) return false;
        MP -= amount; return true;
    }

    // increase MP
    public void restoreMP(int amount) {
         if (amount > 0) MP += amount; 
    }

    // if not dead, increase 10% HP and MP after each round
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

    // Get list of weapons from inventory
    public java.util.List<Weapon> getAvailableWeapons() {
        java.util.List<Weapon> weapons = new java.util.ArrayList<>();
        for (src.Inventory.InventoryEntry entry : inventory.getEntries()) {
            if (entry.getItem() instanceof Weapon) {
                weapons.add((Weapon) entry.getItem());
            }
        }
        return weapons;
    }

    // Get list of armor from inventory
    public java.util.List<Armor> getAvailableArmor() {
        java.util.List<Armor> armors = new java.util.ArrayList<>();
        for (src.Inventory.InventoryEntry entry : inventory.getEntries()) {
            if (entry.getItem() instanceof Armor) {
                armors.add((Armor) entry.getItem());
            }
        }
        return armors;
    }

    // Get list of potions from inventory
    public java.util.List<Potion> getAvailablePotions() {
        java.util.List<Potion> potions = new java.util.ArrayList<>();
        for (src.Inventory.InventoryEntry entry : inventory.getEntries()) {
            if (entry.getItem() instanceof Potion) {
                potions.add((Potion) entry.getItem());
            }
        }
        return potions;
    }

    // Equip a weapon from inventory
    public boolean equipWeaponByIndex(int index) {
        java.util.List<Weapon> weapons = getAvailableWeapons();
        if (index < 0 || index >= weapons.size()) return false;
        this.equippedWeapon = weapons.get(index);
        return true;
    }

    // Equip armor from inventory
    public boolean equipArmorByIndex(int index) {
        java.util.List<Armor> armors = getAvailableArmor();
        if (index < 0 || index >= armors.size()) return false;
        this.equippedArmor = armors.get(index);
        return true;
    }

    // Use a potion and consume it from inventory
    public boolean usePotionByIndex(int index) {
        java.util.List<Potion> potions = getAvailablePotions();
        if (index < 0 || index >= potions.size()) return false;
        Potion potion = potions.get(index);
        applyPotion(potion);
        
        // Remove one from inventory
        src.Inventory.InventoryEntry entry = inventory.getEntryByName(potion.getName());
        if (entry != null) {
            entry.decreaseQuantity(1);
            if (entry.getQuantity() <= 0) {
                inventory.removeItemByName(potion.getName());
            }
        }
        return true;
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
