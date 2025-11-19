package src.Core;

import src.Hero.Hero;

import java.util.ArrayList;
import java.util.List;

import src.Hero.Paladin;   
import src.Hero.Sorcerer;
import src.Hero.Warrior;
import src.Inventory.Inventory;
import src.Hero.Hero;
import src.Default.DefaultReader;

import IO.Input;

public class Party {

    private List<Hero> heroes;   // 1–3 heroes

    public Party() {
        this.heroes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        if (heroes.size() >= 3) {
            System.out.println("Party is full (max 3 heroes).");
            return;
        }
        heroes.add(hero);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public int size() {
        return heroes.size();
    }
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



    public void printPartyInfo() {
        System.out.println("===== PARTY =====");
        for (Hero h : heroes) {
            IO.Output.displayHeroFullInfo(h);
        }
        System.out.println("=================");
    }

    public void initializeParty(int partySize) {
        for (int i = 1; i <= partySize; i++) {
            String romenNumber = (i==1?"I": i==2?"II":"III");
            int heroNumber = Input.getHeroName(i);
            String heroClass = heroNumber == 1 ? "Warrior" : heroNumber == 2 ? "Sorcerer" : "Paladin";
            DefaultReader.HeroStats stats = DefaultReader.readHero(heroClass);
            Inventory inv = new Inventory();
            Hero hero;
            if ("Warrior".equals(heroClass)) {
                hero = new Warrior("Warrior " + romenNumber, stats.level, stats.HP, stats.MP, stats.strength, stats.dexterity, stats.agility, stats.gold, inv);
            } else if ("Sorcerer".equals(heroClass)) {
                hero = new Sorcerer("Sorcerer " + romenNumber, stats.level, stats.HP, stats.MP, stats.strength, stats.dexterity, stats.agility, stats.gold, inv);
            } else {
                hero = new Paladin("Paladin " + romenNumber, stats.level, stats.HP, stats.MP, stats.strength, stats.dexterity, stats.agility, stats.gold, inv);
            }
            addHero(hero);
        }
    }
    


}
