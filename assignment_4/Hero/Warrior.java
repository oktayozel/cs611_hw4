package assignment_4.Hero;
import assignment_4.Inventory.Inventory;

// favors strength and agility


public class Warrior extends Hero {
    public Warrior(String name, int level, int HP, int MP, int strength, int dexterity, int agility, int gold, Inventory inventory) {
        super(name, level, HP, MP, strength, dexterity, agility, gold, inventory);
        this.heroClass = "Warrior";
    }
}


