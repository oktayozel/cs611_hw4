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



}
