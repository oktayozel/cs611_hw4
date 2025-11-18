package src.Core;

import src.Hero.Hero;

import java.util.ArrayList;
import java.util.List;

import src.Hero.Paladin;   
import src.Hero.Sorcerer;
import src.Hero.Warrior;
import src.Inventory.Inventory;
import src.Hero.Hero;

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
            String romenNumber = "0";
            if (i ==1 ){
                romenNumber = "I";
            }
            if (i ==2 ){
                romenNumber = "II";
            }
            if (i ==3 ){
                romenNumber = "III";
            }   
            int heroNumber = Input.getHeroName(i);
            Hero hero = null;
            if (heroNumber == 1) {
                hero = new Warrior("Warrior " + romenNumber, 1, 100, 50, 20, 15, 10, 100, new Inventory());
            } else if (heroNumber == 2) {
                hero = new Sorcerer("Sorcerer " + romenNumber, 1, 100, 50, 20, 15, 10, 100, new Inventory());
            } else if (heroNumber == 3) {
                hero = new Paladin("Paladin " + romenNumber, 1, 100, 50, 20, 15, 10, 100, new Inventory());
            }
            addHero(hero);
        }
        return;
    }
    


}
