package src.Core;
import src.Hero.Hero;
import java.util.ArrayList;
import java.util.List;
import src.Hero.Paladin;   
import src.Hero.Sorcerer;
import src.Hero.Warrior;
import src.Inventory.Inventory;
import src.Default.DefaultReader;
import src.IO.Input;

public class Party {

    private List<Hero> heroes;   // list that holds the heroes in the party

    // general constructor
    public Party() {
        this.heroes = new ArrayList<>();
    }

    // adds a hero to the party
    public void addHero(Hero hero) {
        if (heroes.size() >= 3) {
            System.out.println("Party is full (max 3 heroes).");
            return;
        }
        heroes.add(hero);
    }

    // getter for heroes
    public List<Hero> getHeroes() {
        return heroes;
    }

    // returns the number of heroes in the party
    public int size() {
        return heroes.size();
    }

    // returns the average level of the heroes in the party
    public int getAverageLevel() {
        if (heroes.isEmpty()) {
            return 0;
        }
        int totalLevel = 0;
        for (Hero h : heroes) {
            totalLevel += h.getLevel();
        }
        return totalLevel / heroes.size();
    }
    
    // returns the highest level of the heroes in the party (for monster scaling)
    public int getHighestLevel() {
        if (heroes.isEmpty()) {
            return 0;
        }
        int maxLevel = heroes.get(0).getLevel();
        for (Hero h : heroes) {
            if (h.getLevel() > maxLevel) {
                maxLevel = h.getLevel();
            }
        }
        return maxLevel;
    }





    public void initializeParty(int partySize) {
        for (int i = 1; i <= partySize; i++) {
            String romanNumber = (i==1?"I": i==2?"II":"III");
            int heroNumber = Input.getHeroName(i);
            String classPlural = heroNumber == 1 ? "Warriors" : heroNumber == 2 ? "Sorcerers" : "Paladins";
            List<DefaultReader.HeroTemplate> templates = DefaultReader.loadHeroClass(classPlural);
            DefaultReader.HeroTemplate chosen = templates.isEmpty() ? null : templates.get((i-1) % templates.size()); // deterministic pick
            // fallback if file missing
            if (chosen == null) {
                chosen = new DefaultReader.HeroTemplate();
                chosen.name = classPlural.substring(0, classPlural.length()-1) + "_Default"; // Warrior_Default etc.
                chosen.MP = 50; chosen.strength = 20; chosen.dexterity = 15; chosen.agility = 10; chosen.gold = 100; chosen.startingExp = 0; chosen.level = 1; chosen.HP = 100;
            }
            Inventory inv = new Inventory();
            Hero hero;
            // create hero with stats from template
            if ("Warriors".equals(classPlural)) {
                Warrior warrior = new Warrior(chosen.name + " " + romanNumber, chosen.level, chosen.HP, chosen.MP, chosen.strength, chosen.dexterity, chosen.agility, chosen.gold, inv);
                warrior.equipDefaultWeapon();
                hero = warrior;
            } else if ("Sorcerers".equals(classPlural)) {
                Sorcerer sorcerer = new Sorcerer(chosen.name + " " + romanNumber, chosen.level, chosen.HP, chosen.MP, chosen.strength, chosen.dexterity, chosen.agility, chosen.gold, inv);
                sorcerer.equipDefaultWeapon();
                hero = sorcerer;
            } else {
                Paladin paladin = new Paladin(chosen.name + " " + romanNumber, chosen.level, chosen.HP, chosen.MP, chosen.strength, chosen.dexterity, chosen.agility, chosen.gold, inv);
                paladin.equipDefaultWeapon();
                hero = paladin;
            }
            addHero(hero);
        }
    }
    


}
